// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum InteractionItemChangeBehavior {
    Cancel(0),
    Fail(1),
    Finish(2),
    Ignore(3);

    public static final InteractionItemChangeBehavior[] VALUES = values();

    private final int value;

    InteractionItemChangeBehavior(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static InteractionItemChangeBehavior fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("InteractionItemChangeBehavior", value);
    }
}