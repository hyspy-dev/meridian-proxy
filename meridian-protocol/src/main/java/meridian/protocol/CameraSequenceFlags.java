// Auto-generated - do not edit
package meridian.protocol;

public final class CameraSequenceFlags {
    private CameraSequenceFlags() {
    }

    public static final byte None = (byte) 0;
    public static final byte LockInput = (byte) 1;
    public static final byte HideLocalPlayer = (byte) 2;
    public static final byte ReturnToGameplayCameraOnEnd = (byte) 4;
    public static final byte ALL = (byte) 7;

    public static boolean has(byte value, byte flag) {
        return (value & flag) == flag;
    }

    public static byte with(byte value, byte flag) {
        return (byte) (value | flag);
    }

    public static byte without(byte value, byte flag) {
        return (byte) (value & ~flag);
    }

    public static byte none() {
        return (byte) 0;
    }
}