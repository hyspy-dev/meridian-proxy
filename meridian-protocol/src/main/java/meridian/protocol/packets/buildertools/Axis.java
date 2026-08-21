// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

import meridian.protocol.io.ProtocolException;

public enum Axis {
    X(0),
    Y(1),
    Z(2);

    public static final Axis[] VALUES = values();

    private final int value;

    Axis(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Axis fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("Axis", value);
    }
}