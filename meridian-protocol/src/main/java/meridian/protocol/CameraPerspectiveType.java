// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum CameraPerspectiveType {
    First(0),
    Third(1);

    public static final CameraPerspectiveType[] VALUES = values();

    private final int value;

    CameraPerspectiveType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CameraPerspectiveType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("CameraPerspectiveType", value);
    }
}