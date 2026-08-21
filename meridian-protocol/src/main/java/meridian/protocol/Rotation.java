// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum Rotation {
    None(0),
    Ninety(1),
    OneEighty(2),
    TwoSeventy(3);

    public static final Rotation[] VALUES = values();

    private final int value;

    Rotation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Rotation fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("Rotation", value);
    }
}