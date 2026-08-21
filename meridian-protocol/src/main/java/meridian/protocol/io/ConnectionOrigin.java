package meridian.protocol.io;

import javax.annotation.Nullable;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Objects;

/**
 * Remote address comparison shared by every {@link ChannelConnection#isFromSameOrigin} implementation.
 */
public final class ConnectionOrigin {

    private ConnectionOrigin() {
    }

    /**
     * Tests if two remote addresses are from the same origin.
     * They are the same origin if the addresses are equal, or if both are an
     * {@link InetSocketAddress} with the same {@link java.net.InetAddress}.
     * Two loopback addresses are always the same origin.
     *
     * @param address1 the first remote address, or {@code null} if it is unknown
     * @param address2 the second remote address, or {@code null} if it is unknown
     * @return {@code true} if the two addresses are from the same origin
     */
    public static boolean isFromSameOrigin(@Nullable SocketAddress address1, @Nullable SocketAddress address2) {
        // Null means one is not connected, or we don't know, so there is no way to tell
        if (address1 == null || address2 == null) return false;

        if (Objects.equals(address1, address2)) return true;

        if (!address1.getClass().equals(address2.getClass())) return false;

        if (address1 instanceof InetSocketAddress inetAddress1 && address2 instanceof InetSocketAddress inetAddress2) {
            // An unresolved InetSocketAddress has no InetAddress to compare
            if (inetAddress1.getAddress() == null || inetAddress2.getAddress() == null) return false;

            if (inetAddress1.getAddress().isLoopbackAddress() && inetAddress2.getAddress().isLoopbackAddress()) {
                return true;
            }
            return inetAddress1.getAddress().equals(inetAddress2.getAddress());
        }

        return false;
    }
}
