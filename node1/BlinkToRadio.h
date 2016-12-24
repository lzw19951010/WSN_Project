// $Id: BlinkToRadio.h,v 1.4 2006/12/12 18:22:52 vlahan Exp $

#ifndef BLINKTORADIO_H
#define BLINKTORADIO_H

enum {
  AM_BLINKTORADIO = 0x93,
  TIMER_PERIOD_MILLI = 250
};

typedef nx_struct BlinkToRadioMsg {
  nx_uint16_t version; /* Version of the interval. */
  nx_uint16_t interval; /* Samping period. */
  nx_uint16_t ID;
  nx_uint16_t SeqNo;
  nx_uint16_t TempData;
  nx_uint16_t HumidityData;
  nx_uint16_t PhotoData;
  nx_uint32_t Time;
} BlinkToRadioMsg;

#endif
