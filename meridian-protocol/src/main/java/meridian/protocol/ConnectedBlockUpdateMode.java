// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum ConnectedBlockUpdateMode {
    PlaceUpdate(0),
    UpdatePlaceUpdate(1),
    IgnoreUpdates(2);

    public static final ConnectedBlockUpdateMode[] VALUES = values();

    private final int value;

    ConnectedBlockUpdateMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ConnectedBlockUpdateMode fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("ConnectedBlockUpdateMode", value);
    }
}