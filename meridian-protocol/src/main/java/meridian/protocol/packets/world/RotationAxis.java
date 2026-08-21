// Auto-generated - do not edit
package meridian.protocol.packets.world;

import meridian.protocol.io.ProtocolException;

public enum RotationAxis {
    X(0),
    Y(1),
    Z(2);

    public static final RotationAxis[] VALUES = values();

    private final int value;

    RotationAxis(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RotationAxis fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("RotationAxis", value);
    }
}