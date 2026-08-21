// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum CanMoveType {
    AttachedToLocalPlayer(0),
    Always(1);

    public static final CanMoveType[] VALUES = values();

    private final int value;

    CanMoveType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CanMoveType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("CanMoveType", value);
    }
}