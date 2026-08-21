// Auto-generated - do not edit
package meridian.protocol;

public enum NetworkChannel {
    Default(0),
    Chunks(1),
    WorldMap(2),
    Voice(3);

    public static final NetworkChannel[] VALUES = values();
    public static final int COUNT = VALUES.length;

    private final int value;

    NetworkChannel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static NetworkChannel fromValue(int value) {
        if (value >= 0 && value < VALUES.length) return VALUES[value];
        throw new IllegalArgumentException("Invalid network channel: " + value);
    }
}