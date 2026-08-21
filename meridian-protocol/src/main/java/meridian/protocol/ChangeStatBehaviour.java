// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum ChangeStatBehaviour {
    Add(0),
    Set(1),
    Min(2),
    Max(3);

    public static final ChangeStatBehaviour[] VALUES = values();

    private final int value;

    ChangeStatBehaviour(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ChangeStatBehaviour fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("ChangeStatBehaviour", value);
    }
}