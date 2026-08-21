// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum ForcedPerspective {
    None(0),
    FirstPerson(1),
    ThirdPerson(2);

    public static final ForcedPerspective[] VALUES = values();

    private final int value;

    ForcedPerspective(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ForcedPerspective fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("ForcedPerspective", value);
    }
}