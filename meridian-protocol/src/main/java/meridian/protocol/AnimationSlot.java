// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum AnimationSlot {
    Movement(0),
    Status(1),
    Action(2),
    Face(3),
    Emote(4),
    ServerAction(5);

    public static final AnimationSlot[] VALUES = values();

    private final int value;

    AnimationSlot(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AnimationSlot fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("AnimationSlot", value);
    }
}