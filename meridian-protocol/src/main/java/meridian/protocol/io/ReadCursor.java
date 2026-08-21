package meridian.protocol.io;

/**
 * Receives the end position of a decode. toObject reports through this where the encoding of the
 * value it decoded ends, so a caller reading a sequence of variable-size values can advance to the
 * next one without measuring the decoded value a second time.
 */
public final class ReadCursor {

    /** Absolute segment position of the first byte after the decoded value. */
    public int position;
}
