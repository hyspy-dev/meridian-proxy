package meridian.protocol.io;

import javax.annotation.Nonnull;

/**
 * Exception thrown when protocol data is malformed or exceeds defined limits.
 * Used for both read-side validation (untrusted input) and write-side validation (defense in depth).
 */
public class ProtocolException extends RuntimeException {

    public ProtocolException(@Nonnull String message) {
        super(message);
    }

    public ProtocolException(@Nonnull String message, @Nonnull Throwable cause) {
        super(message, cause);
    }

    /** Creates an exception for array length exceeding the maximum allowed. */
    @Nonnull
    public static ProtocolException arrayTooLong(@Nonnull String fieldName, int actual, int max) {
        return new ProtocolException(fieldName + ": array length " + actual + " exceeds maximum " + max);
    }

    /** Creates an exception for string length exceeding the maximum allowed. */
    @Nonnull
    public static ProtocolException stringTooLong(@Nonnull String fieldName, int actual, int max) {
        return new ProtocolException(fieldName + ": string length " + actual + " exceeds maximum " + max);
    }

    /** Creates an exception for dictionary count exceeding the maximum allowed. */
    @Nonnull
    public static ProtocolException dictionaryTooLarge(@Nonnull String fieldName, int actual, int max) {
        return new ProtocolException(fieldName + ": dictionary count " + actual + " exceeds maximum " + max);
    }

    /** Creates an exception for buffer being too small to read the expected data. */
    @Nonnull
    public static ProtocolException bufferTooSmall(@Nonnull String fieldName, int required, int available) {
        return new ProtocolException(fieldName + ": buffer too small, need " + required + " bytes but only " + available + " available");
    }

    /** Creates an exception for invalid VarInt encoding. */
    @Nonnull
    public static ProtocolException invalidVarInt(@Nonnull String fieldName) {
        return new ProtocolException(fieldName + ": invalid or incomplete VarInt");
    }

    /** Creates an exception for a collection entry that consumes no bytes. */
    @Nonnull
    public static ProtocolException nonAdvancingEntry(@Nonnull String fieldName, int offset) {
        return new ProtocolException(fieldName + ": entry at offset " + offset + " consumed no bytes");
    }

    /** Creates an exception for invalid offset values. */
    @Nonnull
    public static ProtocolException invalidOffset(@Nonnull String fieldName, int offset, int bufferLength) {
        return new ProtocolException(fieldName + ": offset " + offset + " is out of bounds (buffer length: " + bufferLength + ")");
    }

    /**
     * A writer lays the variable block out contiguously in field order, so a present field's offset slot
     * equals the end of the previous one and an absent field's slot is -1. Element loops advance by the
     * re-encoded size, which only equals the occupied span while that holds.
     */
    @Nonnull
    public static ProtocolException nonCanonicalLayout(@Nonnull String fieldName, int actual, int expected) {
        return new ProtocolException(fieldName + ": offset slot " + actual + " does not match the canonical layout position " + expected);
    }

    /** Creates an exception for unknown polymorphic type ID. */
    @Nonnull
    public static ProtocolException unknownPolymorphicType(@Nonnull String typeName, int typeId) {
        return new ProtocolException(typeName + ": unknown polymorphic type ID " + typeId);
    }

    /** Creates an exception for duplicate dictionary key. */
    @Nonnull
    public static ProtocolException duplicateKey(@Nonnull String fieldName, @Nonnull Object key) {
        return new ProtocolException(fieldName + ": duplicate key '" + key + "'");
    }

    /** Creates an exception for invalid enum value. */
    @Nonnull
    public static ProtocolException invalidEnumValue(@Nonnull String enumName, int value) {
        return new ProtocolException(enumName + ": invalid enum value " + value);
    }

    /** Creates an exception for array length below the minimum required. */
    @Nonnull
    public static ProtocolException arrayTooShort(@Nonnull String fieldName, int actual, int min) {
        return new ProtocolException(fieldName + ": array length " + actual + " is below minimum " + min);
    }

    /** Creates an exception for string length below the minimum required. */
    @Nonnull
    public static ProtocolException stringTooShort(@Nonnull String fieldName, int actual, int min) {
        return new ProtocolException(fieldName + ": string length " + actual + " is below minimum " + min);
    }

    /** Creates an exception for dictionary count below the minimum required. */
    @Nonnull
    public static ProtocolException dictionaryTooSmall(@Nonnull String fieldName, int actual, int min) {
        return new ProtocolException(fieldName + ": dictionary count " + actual + " is below minimum " + min);
    }

    /** Creates an exception for numeric value outside the allowed range. */
    @Nonnull
    public static ProtocolException valueOutOfRange(@Nonnull String fieldName, @Nonnull Object value, double min, double max) {
        return new ProtocolException(fieldName + ": value " + value + " is outside allowed range [" + min + ", " + max + "]");
    }

    /** Creates an exception for numeric value below the minimum. */
    @Nonnull
    public static ProtocolException valueBelowMinimum(@Nonnull String fieldName, @Nonnull Object value, double min) {
        return new ProtocolException(fieldName + ": value " + value + " is below minimum " + min);
    }

    /** Creates an exception for numeric value above the maximum. */
    @Nonnull
    public static ProtocolException valueAboveMaximum(@Nonnull String fieldName, @Nonnull Object value, double max) {
        return new ProtocolException(fieldName + ": value " + value + " exceeds maximum " + max);
    }

    /** Creates an exception for a string containing non-ASCII bytes. */
    @Nonnull
    public static ProtocolException invalidAsciiString(@Nonnull String fieldName) {
        return new ProtocolException(fieldName + ": string contains non-ASCII bytes");
    }

    /** Creates an exception for a string whose bytes are not well-formed in its declared charset. */
    @Nonnull
    public static ProtocolException malformedString(@Nonnull String fieldName) {
        return new ProtocolException(fieldName + ": string bytes are not well-formed");
    }

    /** Creates an exception for a non-finite (NaN or +/-Infinity) floating-point value. */
    @Nonnull
    public static ProtocolException valueNotFinite(@Nonnull String fieldName, @Nonnull Object value) {
        return new ProtocolException(fieldName + ": value " + value + " is not finite");
    }
}
