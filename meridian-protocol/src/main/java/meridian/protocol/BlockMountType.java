// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum BlockMountType {
    Seat(0),
    Bed(1);

    public static final BlockMountType[] VALUES = values();

    private final int value;

    BlockMountType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BlockMountType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("BlockMountType", value);
    }
}