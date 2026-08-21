// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum ClickType {
    None(0),
    Left(1),
    Right(2),
    Middle(3);

    public static final ClickType[] VALUES = values();

    private final int value;

    ClickType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ClickType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("ClickType", value);
    }
}