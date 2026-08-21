// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum DrawType {
    Empty(0),
    GizmoCube(1),
    Cube(2),
    Model(3),
    CubeWithModel(4);

    public static final DrawType[] VALUES = values();

    private final int value;

    DrawType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DrawType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("DrawType", value);
    }
}