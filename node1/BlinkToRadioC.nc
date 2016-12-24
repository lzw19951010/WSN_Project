// $Id: BlinkToRadioC.nc,v 1.5 2007/09/13 23:10:23 scipio Exp $

/*
 * "Copyright (c) 2000-2006 The Regents of the University  of California.  
 * All rights reserved.
 *
 * Permission to use, copy, modify, and distribute this software and its
 * documentation for any purpose, without fee, and without written agreement is
 * hereby granted, provided that the above copyright notice, the following
 * two paragraphs and the author appear in all copies of this software.
 * 
 * IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR
 * DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES ARISING OUT
 * OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF THE UNIVERSITY OF
 * CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY
 * AND FITNESS FOR A PARTICULAR PURPOSE.  THE SOFTWARE PROVIDED HEREUNDER IS
 * ON AN "AS IS" BASIS, AND THE UNIVERSITY OF CALIFORNIA HAS NO OBLIGATION TO
 * PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS."
 *
 */

/**
 * Implementation of the BlinkToRadio application.  A counter is
 * incremented and a radio message is sent whenever a timer fires.
 * Whenever a radio message is received, the three least significant
 * bits of the counter in the message payload are displayed on the
 * LEDs.  Program two motes with this application.  As long as they
 * are both within range of each other, the LEDs on both will keep
 * changing.  If the LEDs on one (or both) of the nodes stops changing
 * and hold steady, then that node is no longer receiving any messages
 * from the other node.
 *
 * @author Prabal Dutta
 * @date   Feb 1, 2006
 */
#include <Timer.h>
#include <SensirionSht11.h>
#include "BlinkToRadio.h"


module BlinkToRadioC {
  uses interface Boot;
  uses interface Leds;
  uses interface Timer<TMilli> as Timer0;
  uses interface Packet;
  uses interface AMPacket;
  uses interface AMSend;
  uses interface Receive;
  uses interface SplitControl as AMControl;
  uses interface Read<uint16_t> as readTemp;
  uses interface Read<uint16_t> as readHumidity;
  uses interface Read<uint16_t> as readPhoto;
}
implementation {
  uint16_t TempData;
  uint16_t HumidityData;
  uint16_t PhotoData;
  uint16_t SeqNo = 1;
  message_t pkt;
  bool busy = FALSE;
  uint16_t myAddress = 4101;
  uint16_t sendAddress = 4100;
  uint16_t receiveAddress = 4102;
  uint16_t baseAddress = 4100;

  message_t* my_msg;
  void* my_payload;
  uint8_t my_len;

  task void my_receive();

  void setLeds(uint16_t val) {
    if (val & 0x01)
      call Leds.led0On();
    else 
      call Leds.led0Off();
    if (val & 0x02)
      call Leds.led1On();
    else
      call Leds.led1Off();
    if (val & 0x04)
      call Leds.led2On();
    else
      call Leds.led2Off();
  }

  event void Boot.booted() {
    call AMControl.start();
  }

  event void AMControl.startDone(error_t err) {
    if (err == SUCCESS) {
      call Timer0.startPeriodic(TIMER_PERIOD_MILLI);
    }
    else {
      call AMControl.start();
    }
  }

  event void AMControl.stopDone(error_t err) {
  }

  event void Timer0.fired() {
  	call readTemp.read();
  	call readHumidity.read();
  	call readPhoto.read();
    if (!busy) {
      BlinkToRadioMsg* btrpkt = 
	(BlinkToRadioMsg*)(call Packet.getPayload(&pkt, sizeof(BlinkToRadioMsg)));
      if (btrpkt == NULL) {
		return;
      }
      btrpkt->ID = myAddress;
      btrpkt->SeqNo = SeqNo;
      btrpkt->TempData = TempData;
      btrpkt->HumidityData = HumidityData;
      btrpkt->PhotoData = PhotoData;
      btrpkt->Time = call Timer0.getNow();
      if (call AMSend.send(sendAddress, 
          &pkt, sizeof(BlinkToRadioMsg)) == SUCCESS) {
        busy = TRUE;
      }
    }
    SeqNo++;
  }

  event void readTemp.readDone(error_t result, uint16_t val) {
	if (result == SUCCESS){
		val = -40.1+ 0.01*val;
		TempData = val;
	}
  	else TempData = 0xffff;
  	call Leds.led0Toggle();
  }

  event void readHumidity.readDone(error_t result, uint16_t val) {
	if (result == SUCCESS){
	HumidityData = -4 + 4*val/100 + (-28/1000/10000)*(val*val);//转换成带温度补偿的湿度值
	HumidityData = (TempData-25)*(1/100+8*val/100/1000)+HumidityData;//但结果不知道这个转换公式转换的结果对不对
  }
	else HumidityData = 0xffff;
	call Leds.led1Toggle();
  }

  event void readPhoto.readDone(error_t result, uint16_t val) {
	if (result == SUCCESS){
		PhotoData = val;
	}
	else PhotoData = 0xffff;
	call Leds.led2Toggle();
  }

  event void AMSend.sendDone(message_t* msg, error_t err) {
    if (&pkt == msg) {
      busy = FALSE;
    }
  }

  event message_t* Receive.receive(message_t* msg, void* payload, uint8_t len){
  	my_msg = msg;
  	my_payload = payload;
  	my_len = len;
    post my_receive();
    return msg;
  }

  task void my_receive(){
    if (my_len == sizeof(BlinkToRadioMsg)) {
      BlinkToRadioMsg* btrpkt = (BlinkToRadioMsg*)my_payload;
      if (!busy && call AMPacket.source(my_msg) == receiveAddress) {
        BlinkToRadioMsg* btrpktTemp = (BlinkToRadioMsg*)(call Packet.getPayload(&pkt, sizeof(BlinkToRadioMsg)));
        if (btrpktTemp == NULL) {
          return;
        }
        btrpktTemp->ID = btrpkt->ID;
        btrpktTemp->SeqNo = btrpkt->SeqNo;
        btrpktTemp->TempData = btrpkt->TempData;
        btrpktTemp->HumidityData = btrpkt->HumidityData;
        btrpktTemp->PhotoData = btrpkt->PhotoData;
        btrpktTemp->Time = btrpkt->Time;
        if (call AMSend.send(sendAddress, &pkt, sizeof(BlinkToRadioMsg)) == SUCCESS) {
          busy = TRUE;
        }
      }
      else if(!busy && call AMPacket.source(my_msg) == baseAddress) {
        call Timer0.startPeriodic(btrpkt->interval);
      }
      else if(call AMPacket.source(my_msg) == receiveAddress || call AMPacket.source(my_msg) == baseAddress) {
        post my_receive();
      }
      setLeds(btrpkt->SeqNo);
    }
  }

}
