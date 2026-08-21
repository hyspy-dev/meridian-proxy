// Auto-generated - do not edit
package meridian.protocol.packets.voice;

import meridian.protocol.io.ProtocolException;

public enum VoiceInputMode {
    VoiceActivity(0),
    PushToTalk(1),
    PushToTalkToggle(2);

    public static final VoiceInputMode[] VALUES = values();

    private final int value;

    VoiceInputMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static VoiceInputMode fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("VoiceInputMode", value);
    }
}