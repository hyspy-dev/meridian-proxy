// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum BlockSupportsRequiredForType {
    Any(0),
    All(1);

    public static final BlockSupportsRequiredForType[] VALUES = values();

    private final int value;

    BlockSupportsRequiredForType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BlockSupportsRequiredForType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("BlockSupportsRequiredForType", value);
    }
}