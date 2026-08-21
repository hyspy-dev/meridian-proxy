// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum SmartMoveType {
    EquipOrMergeStack(0),
    PutInHotbarOrWindow(1),
    PutInHotbarOrBackpack(2);

    public static final SmartMoveType[] VALUES = values();

    private final int value;

    SmartMoveType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SmartMoveType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("SmartMoveType", value);
    }
}