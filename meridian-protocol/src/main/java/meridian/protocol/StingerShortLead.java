// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum StingerShortLead {
    DropPickup(0),
    Skip(1),
    Defer(2),
    TrimPickup(3);

    public static final StingerShortLead[] VALUES = values();

    private final int value;

    StingerShortLead(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static StingerShortLead fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("StingerShortLead", value);
    }
}