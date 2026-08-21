// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum MouseButtonType {
    Left(0),
    Middle(1),
    Right(2),
    X1(3),
    X2(4);

    public static final MouseButtonType[] VALUES = values();

    private final int value;

    MouseButtonType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MouseButtonType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("MouseButtonType", value);
    }
}