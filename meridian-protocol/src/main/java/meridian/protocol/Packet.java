package meridian.protocol;


import javax.annotation.Nonnull;
import java.lang.foreign.MemorySegment;

/**
 * Interface for all new protocol packets.
 * Matches C# IPacket from Hytale.Protocol.
 */
public interface Packet extends meridian.api.packet.Packet {
    /**
     * Returns the unique packet ID.
     */
    int getId();

    /**
     * Returns the channel this packet should be sent on.
     */
    NetworkChannel getChannel();

    /**
     * Writes this packet at {@code offset} and returns the number of bytes written, which callers rely on
     * being exactly {@link #computeSize()}. The framed write path reserves and length-prefixes on that
     * figure before serializing, so a shorter or longer write corrupts the frame rather than failing.
     */
    int serialize(@Nonnull MemorySegment buffer, int offset);

    /**
     * Compute the exact number of bytes needed to serialize this packet.
     */
    int computeSize();
}
