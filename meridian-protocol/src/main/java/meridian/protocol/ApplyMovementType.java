// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum ApplyMovementType {
    CharacterController(0),
    Position(1);

    public static final ApplyMovementType[] VALUES = values();

    private final int value;

    ApplyMovementType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ApplyMovementType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("ApplyMovementType", value);
    }
}