// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

import meridian.protocol.io.ProtocolException;

public enum RotationFace {
    Up(0),
    Down(1),
    North(2),
    South(3),
    East(4),
    West(5),
    Camera(6);

    public static final RotationFace[] VALUES = values();

    private final int value;

    RotationFace(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RotationFace fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("RotationFace", value);
    }
}