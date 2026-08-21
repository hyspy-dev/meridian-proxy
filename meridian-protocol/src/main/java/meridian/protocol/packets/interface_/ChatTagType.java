// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

import meridian.protocol.io.ProtocolException;

public enum ChatTagType {
    Item(0);

    public static final ChatTagType[] VALUES = values();

    private final int value;

    ChatTagType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ChatTagType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("ChatTagType", value);
    }
}