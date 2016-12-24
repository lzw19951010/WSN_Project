// $Id$

/*                                  tab:4
 * "Copyright (c) 2000-2003 The Regents of the University  of California.  
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
 * Copyright (c) 2002-2003 Intel Corporation
 * All rights reserved.
 *
 * This file is distributed under the terms in the attached INTEL-LICENSE     
 * file. If you do not find these files, copies can be found by writing to
 * Intel Research Berkeley, 2150 Shattuck Avenue, Suite 1300, Berkeley, CA, 
 * 94704.  Attention:  Intel License Inquiry.
 */

import net.tinyos.util.*;
import net.tinyos.packet.*;
import java.io.*;

public class setInterval {
    public static void main(String[] args) throws IOException
    {
    String source = null;
    int interval = 250;
    if (args.length == 2) {
        source = args[0];
        interval = Integer.parseInt(args[1]);
    }
    PacketSource sfw = BuildSource.makePacketSource(source);
    sfw.open(PrintStreamMessenger.err);

    byte[] packet = new byte[26];
    packet[0] = (byte) 0x00;
    packet[1] = (byte) 0xff;  //destination
    packet[2] = (byte) 0xff;
    packet[3] = (byte) 0x10;  //source
    packet[4] = (byte) 0x04;
    packet[5] = (byte) 0x12;  //length
    packet[6] = (byte) 0x00;  //group
    packet[7] = (byte) 0x93;  //type
    packet[8] = (byte) 0x00;  //version
    packet[9] = (byte) 0x00;
    packet[10] = (byte) ((interval & 0x0ff00) >> 8); //interval
    packet[11] = (byte) (interval & 0x0ff);
    System.out.print(interval);
    for (int i = 12; i < 26; i++)
        packet[i] = (byte) 0x00;

    try {
        sfw.writePacket(packet);
    }
    catch (IOException e) {
        System.exit(2);
    }
    Dump.printPacket(System.out, packet);
    System.out.println();
    // A close would be nice, but javax.comm's close is deathly slow
    //sfw.close();
    System.exit(0);
    }
}