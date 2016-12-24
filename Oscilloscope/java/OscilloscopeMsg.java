/**
 * This class is automatically generated by mig. DO NOT EDIT THIS FILE.
 * This class implements a Java interface to the 'OscilloscopeMsg'
 * message type.
 */

public class OscilloscopeMsg extends net.tinyos.message.Message {

    /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 18;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 147;

    /** Create a new OscilloscopeMsg of size 18. */
    public OscilloscopeMsg() {
        super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new OscilloscopeMsg of the given data_length. */
    public OscilloscopeMsg(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new OscilloscopeMsg with the given data_length
     * and base offset.
     */
    public OscilloscopeMsg(int data_length, int base_offset) {
        super(data_length, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new OscilloscopeMsg using the given byte array
     * as backing store.
     */
    public OscilloscopeMsg(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new OscilloscopeMsg using the given byte array
     * as backing store, with the given base offset.
     */
    public OscilloscopeMsg(byte[] data, int base_offset) {
        super(data, base_offset);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new OscilloscopeMsg using the given byte array
     * as backing store, with the given base offset and data length.
     */
    public OscilloscopeMsg(byte[] data, int base_offset, int data_length) {
        super(data, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new OscilloscopeMsg embedded in the given message
     * at the given base offset.
     */
    public OscilloscopeMsg(net.tinyos.message.Message msg, int base_offset) {
        super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /**
     * Create a new OscilloscopeMsg embedded in the given message
     * at the given base offset and length.
     */
    public OscilloscopeMsg(net.tinyos.message.Message msg, int base_offset, int data_length) {
        super(msg, base_offset, data_length);
        amTypeSet(AM_TYPE);
    }

    /**
    /* Return a String representation of this message. Includes the
     * message type name and the non-indexed field values.
     */
    public String toString() {
      String s = "Message <OscilloscopeMsg> \n";
      try {
        s += "  [version=0x"+Long.toHexString(get_version())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [interval=0x"+Long.toHexString(get_interval())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [ID=0x"+Long.toHexString(get_ID())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [SeqNo=0x"+Long.toHexString(get_SeqNo())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [TempData=0x"+Long.toHexString(get_TempData())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [HumidityData=0x"+Long.toHexString(get_HumidityData())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [PhotoData=0x"+Long.toHexString(get_PhotoData())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      try {
        s += "  [Time=0x"+Long.toHexString(get_Time())+"]\n";
      } catch (ArrayIndexOutOfBoundsException aioobe) { /* Skip field */ }
      return s;
    }

    // Message-type-specific access methods appear below.

    /////////////////////////////////////////////////////////
    // Accessor methods for field: version
    //   Field type: int, unsigned
    //   Offset (bits): 0
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'version' is signed (false).
     */
    public static boolean isSigned_version() {
        return false;
    }

    /**
     * Return whether the field 'version' is an array (false).
     */
    public static boolean isArray_version() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'version'
     */
    public static int offset_version() {
        return (0 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'version'
     */
    public static int offsetBits_version() {
        return 0;
    }

    /**
     * Return the value (as a int) of the field 'version'
     */
    public int get_version() {
        return (int)getUIntBEElement(offsetBits_version(), 16);
    }

    /**
     * Set the value of the field 'version'
     */
    public void set_version(int value) {
        setUIntBEElement(offsetBits_version(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'version'
     */
    public static int size_version() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'version'
     */
    public static int sizeBits_version() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: interval
    //   Field type: int, unsigned
    //   Offset (bits): 16
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'interval' is signed (false).
     */
    public static boolean isSigned_interval() {
        return false;
    }

    /**
     * Return whether the field 'interval' is an array (false).
     */
    public static boolean isArray_interval() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'interval'
     */
    public static int offset_interval() {
        return (16 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'interval'
     */
    public static int offsetBits_interval() {
        return 16;
    }

    /**
     * Return the value (as a int) of the field 'interval'
     */
    public int get_interval() {
        return (int)getUIntBEElement(offsetBits_interval(), 16);
    }

    /**
     * Set the value of the field 'interval'
     */
    public void set_interval(int value) {
        setUIntBEElement(offsetBits_interval(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'interval'
     */
    public static int size_interval() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'interval'
     */
    public static int sizeBits_interval() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: ID
    //   Field type: int, unsigned
    //   Offset (bits): 32
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'ID' is signed (false).
     */
    public static boolean isSigned_ID() {
        return false;
    }

    /**
     * Return whether the field 'ID' is an array (false).
     */
    public static boolean isArray_ID() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'ID'
     */
    public static int offset_ID() {
        return (32 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'ID'
     */
    public static int offsetBits_ID() {
        return 32;
    }

    /**
     * Return the value (as a int) of the field 'ID'
     */
    public int get_ID() {
        return (int)getUIntBEElement(offsetBits_ID(), 16);
    }

    /**
     * Set the value of the field 'ID'
     */
    public void set_ID(int value) {
        setUIntBEElement(offsetBits_ID(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'ID'
     */
    public static int size_ID() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'ID'
     */
    public static int sizeBits_ID() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: SeqNo
    //   Field type: int, unsigned
    //   Offset (bits): 48
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'SeqNo' is signed (false).
     */
    public static boolean isSigned_SeqNo() {
        return false;
    }

    /**
     * Return whether the field 'SeqNo' is an array (false).
     */
    public static boolean isArray_SeqNo() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'SeqNo'
     */
    public static int offset_SeqNo() {
        return (48 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'SeqNo'
     */
    public static int offsetBits_SeqNo() {
        return 48;
    }

    /**
     * Return the value (as a int) of the field 'SeqNo'
     */
    public int get_SeqNo() {
        return (int)getUIntBEElement(offsetBits_SeqNo(), 16);
    }

    /**
     * Set the value of the field 'SeqNo'
     */
    public void set_SeqNo(int value) {
        setUIntBEElement(offsetBits_SeqNo(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'SeqNo'
     */
    public static int size_SeqNo() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'SeqNo'
     */
    public static int sizeBits_SeqNo() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: TempData
    //   Field type: int, unsigned
    //   Offset (bits): 64
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'TempData' is signed (false).
     */
    public static boolean isSigned_TempData() {
        return false;
    }

    /**
     * Return whether the field 'TempData' is an array (false).
     */
    public static boolean isArray_TempData() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'TempData'
     */
    public static int offset_TempData() {
        return (64 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'TempData'
     */
    public static int offsetBits_TempData() {
        return 64;
    }

    /**
     * Return the value (as a int) of the field 'TempData'
     */
    public int get_TempData() {
        return (int)getUIntBEElement(offsetBits_TempData(), 16);
    }

    /**
     * Set the value of the field 'TempData'
     */
    public void set_TempData(int value) {
        setUIntBEElement(offsetBits_TempData(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'TempData'
     */
    public static int size_TempData() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'TempData'
     */
    public static int sizeBits_TempData() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: HumidityData
    //   Field type: int, unsigned
    //   Offset (bits): 80
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'HumidityData' is signed (false).
     */
    public static boolean isSigned_HumidityData() {
        return false;
    }

    /**
     * Return whether the field 'HumidityData' is an array (false).
     */
    public static boolean isArray_HumidityData() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'HumidityData'
     */
    public static int offset_HumidityData() {
        return (80 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'HumidityData'
     */
    public static int offsetBits_HumidityData() {
        return 80;
    }

    /**
     * Return the value (as a int) of the field 'HumidityData'
     */
    public int get_HumidityData() {
        return (int)getUIntBEElement(offsetBits_HumidityData(), 16);
    }

    /**
     * Set the value of the field 'HumidityData'
     */
    public void set_HumidityData(int value) {
        setUIntBEElement(offsetBits_HumidityData(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'HumidityData'
     */
    public static int size_HumidityData() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'HumidityData'
     */
    public static int sizeBits_HumidityData() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: PhotoData
    //   Field type: int, unsigned
    //   Offset (bits): 96
    //   Size (bits): 16
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'PhotoData' is signed (false).
     */
    public static boolean isSigned_PhotoData() {
        return false;
    }

    /**
     * Return whether the field 'PhotoData' is an array (false).
     */
    public static boolean isArray_PhotoData() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'PhotoData'
     */
    public static int offset_PhotoData() {
        return (96 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'PhotoData'
     */
    public static int offsetBits_PhotoData() {
        return 96;
    }

    /**
     * Return the value (as a int) of the field 'PhotoData'
     */
    public int get_PhotoData() {
        return (int)getUIntBEElement(offsetBits_PhotoData(), 16);
    }

    /**
     * Set the value of the field 'PhotoData'
     */
    public void set_PhotoData(int value) {
        setUIntBEElement(offsetBits_PhotoData(), 16, value);
    }

    /**
     * Return the size, in bytes, of the field 'PhotoData'
     */
    public static int size_PhotoData() {
        return (16 / 8);
    }

    /**
     * Return the size, in bits, of the field 'PhotoData'
     */
    public static int sizeBits_PhotoData() {
        return 16;
    }

    /////////////////////////////////////////////////////////
    // Accessor methods for field: Time
    //   Field type: long, unsigned
    //   Offset (bits): 112
    //   Size (bits): 32
    /////////////////////////////////////////////////////////

    /**
     * Return whether the field 'Time' is signed (false).
     */
    public static boolean isSigned_Time() {
        return false;
    }

    /**
     * Return whether the field 'Time' is an array (false).
     */
    public static boolean isArray_Time() {
        return false;
    }

    /**
     * Return the offset (in bytes) of the field 'Time'
     */
    public static int offset_Time() {
        return (112 / 8);
    }

    /**
     * Return the offset (in bits) of the field 'Time'
     */
    public static int offsetBits_Time() {
        return 112;
    }

    /**
     * Return the value (as a long) of the field 'Time'
     */
    public long get_Time() {
        return (long)getUIntBEElement(offsetBits_Time(), 32);
    }

    /**
     * Set the value of the field 'Time'
     */
    public void set_Time(long value) {
        setUIntBEElement(offsetBits_Time(), 32, value);
    }

    /**
     * Return the size, in bytes, of the field 'Time'
     */
    public static int size_Time() {
        return (32 / 8);
    }

    /**
     * Return the size, in bits, of the field 'Time'
     */
    public static int sizeBits_Time() {
        return 32;
    }

}