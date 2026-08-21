// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum FlyMode {
    Disabled(0),
    Allowed(1),
    Forced(2);

    public static final FlyMode[] VALUES = values();

    private final int value;

    FlyMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static FlyMode fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("FlyMode", value);
    }
}