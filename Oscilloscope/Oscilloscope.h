/*
 * Copyright (c) 2006 Intel Corporation
 * All rights reserved.
 *
 * This file is distributed under the terms in the attached INTEL-LICENSE     
 * file. If you do not find these files, copies can be found by writing to
 * Intel Research Berkeley, 2150 Shattuck Avenue, Suite 1300, Berkeley, CA, 
 * 94704.  Attention:  Intel License Inquiry.
 */

// @author David Gay

#ifndef OSCILLOSCOPE_H
#define OSCILLOSCOPE_H

enum {
  /* Number of readings per message. If you increase this, you may have to
     increase the message_t size. */
  NREADINGS = 10,

  /* Default sampling period. */
  DEFAULT_INTERVAL = 256,

  AM_OSCILLOSCOPE = 0x93
};

typedef nx_struct oscilloscope {
  nx_uint16_t version; /* Version of the interval. */
  nx_uint16_t interval; /* Samping period. */
  nx_uint16_t ID;
  nx_uint16_t SeqNo;
  nx_uint16_t TempData;
  nx_uint16_t HumidityData;
  nx_uint16_t PhotoData;
  nx_uint32_t Time;
} oscilloscope_t;

#endif
