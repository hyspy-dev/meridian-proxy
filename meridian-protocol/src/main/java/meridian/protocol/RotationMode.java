// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum RotationMode {
    None(0),
    Velocity(1),
    VelocityDamped(2),
    VelocityRoll(3);

    public static final RotationMode[] VALUES = values();

    private final int value;

    RotationMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RotationMode fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("RotationMode", value);
    }
}