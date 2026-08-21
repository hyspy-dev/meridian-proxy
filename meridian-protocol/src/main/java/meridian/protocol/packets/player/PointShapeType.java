// Auto-generated - do not edit
package meridian.protocol.packets.player;

import meridian.protocol.io.ProtocolException;

public enum PointShapeType {
    Block(0),
    Sphere(1);

    public static final PointShapeType[] VALUES = values();

    private final int value;

    PointShapeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PointShapeType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("PointShapeType", value);
    }
}