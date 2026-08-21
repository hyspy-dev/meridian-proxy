// Auto-generated - do not edit
package meridian.protocol;

public final class ProtocolSettings {
    public static final int PROTOCOL_CRC = 245610536;
    public static final int PROTOCOL_VERSION = 3;
    public static final int PROTOCOL_BUILD_NUMBER = 208;
    public static final int PACKET_COUNT = 367;
    public static final int STRUCT_COUNT = 423;
    public static final int ENUM_COUNT = 169;
    public static final int MAX_PACKET_SIZE = 1677721600;

    private ProtocolSettings() {}

    public static boolean validateCrc(int crc) {
        return PROTOCOL_CRC == crc;
    }
}