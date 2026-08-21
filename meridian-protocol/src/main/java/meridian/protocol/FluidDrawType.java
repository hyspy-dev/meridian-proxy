// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum FluidDrawType {
    None(0),
    Liquid(1);

    public static final FluidDrawType[] VALUES = values();

    private final int value;

    FluidDrawType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static FluidDrawType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("FluidDrawType", value);
    }
}