package meridian.protocol.io;

import meridian.protocol.FormattedMessage;
import meridian.protocol.ToClientPacket;
import meridian.protocol.packets.connection.QuicApplicationErrorCode;

import meridian.protocol.NetworkChannel;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.net.SocketAddress;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.BooleanSupplier;
import java.util.logging.Level;

public interface ChannelConnection {

    void flush();

    void write(ToClientPacket packet);

    void writeAndFlush(ToClientPacket packet);

    void write(ToClientPacket[] packets);

    void writeAndFlush(ToClientPacket[] packets);

    boolean isActive();

    boolean isWritable();

    SocketAddress remoteAddress();

    String formatRemoteAddress();

    void disconnect(@Nonnull final FormattedMessage message);

    @Nullable
    PacketStatsRecorder getPacketStatsRecorder();

    @Nullable
    String getSniHostname();

    /**
     * Tests if this connection and {@code other} come from the same remote origin.
     * A reconnecting player opens a new connection, so this must compare remote addresses.
     * It must not compare connection identity, which is never equal across two connections.
     * Implementations delegate to {@link ConnectionOrigin#isFromSameOrigin}.
     *
     * @param other the connection to compare against
     * @return {@code true} if both connections are from the same origin
     */
    boolean isFromSameOrigin(ChannelConnection other);

    void execute(Runnable runnable);

    X509Certificate getClientCertificate();

    /**
     * Initializes the timeout context for a new connection.
     * Call this once when the first handler is registered.
     *
     * @param stage      The initial stage name.
     * @param identifier The player identifier (typically remote address at this point).
     */
    void initTimeoutContext(@Nonnull String stage, @Nonnull String identifier);

    /**
     * Updates the timeout context with a new stage and identifier.
     *
     * @param stage      The new stage name.
     * @param identifier The new player identifier.
     */
    void updateTimeoutContext(@Nonnull String stage, @Nonnull String identifier);

    /**
     * Updates the timeout context with a new stage, keeping the existing identifier.
     *
     * @param stage The new stage name.
     */
    void updateTimeoutContext(@Nonnull String stage);

    /**
     * Sets the packet read timeout for the decoder.
     *
     * @param timeout The timeout duration.
     */
    void setPacketTimeout(@Nonnull Duration timeout);

    /**
     * Cancels any currently scheduled packet read timeout.
     */
    void clearPacketTimeout();

    /**
     * Schedules a stage timeout that fires the given callback if the condition is not met
     * within the specified duration. Cancels any previously scheduled stage timeout.
     *
     * @param stage     The stage name (for logging).
     * @param timeout   The timeout duration.
     * @param condition Returns true if the stage completed successfully (timeout should not fire).
     * @param onTimeout Callback to run when the timeout fires and the condition is not met.
     */
    void setStageTimeout(@Nonnull String stage, @Nonnull Duration timeout,
                         @Nonnull BooleanSupplier condition, @Nonnull Runnable onTimeout);

    /**
     * Cancels any currently scheduled stage timeout.
     */
    void clearStageTimeout();

    /**
     * Logs connection timing information, tracking the time delta between consecutive calls.
     *
     * @param message The message describing the event.
     * @param level   The log level.
     */
    void logConnectionTimings(@Nonnull String message, @Nonnull Level level);

    /**
     * Creates auxiliary network channels (e.g., Chunks, WorldMap) for this connection.
     * For multiplexed transports (QUIC), creates separate unidirectional streams.
     *
     * @param handler        The connection handler for pipeline setup on new streams.
     * @param onChannelReady Called for each auxiliary channel when it is ready, with the
     *                       {@link NetworkChannel} and the corresponding {@link ChannelConnection}.
     * @return a future that completes when all auxiliary channels are set up.
     */
    @Nonnull
    CompletableFuture<Void> setupAuxiliaryChannels(@Nonnull ConnectionHandler handler,
                                                   @Nonnull BiConsumer<NetworkChannel, ChannelConnection> onChannelReady);

    /**
     * Replaces the current packet handler on this connection.
     * Manages lifecycle callbacks (unregistered/registered) on old and new handlers.
     *
     * @param handler The new handler to set
     */
    void setChannelHandler(@Nonnull ConnectionHandler handler);

    void closeConnection();

    /**
     * Closes the connection gracefully as an application-level close with no error.
     * Use this after sending a Disconnect packet for clean shutdown.
     */
    void closeApplicationConnection();

    /**
     * Closes the connection gracefully with a specific application error code.
     * For QUIC, sends an APPLICATION_CLOSE frame to properly notify the client.
     *
     * @param errorCode Application-defined error code
     */
    void closeApplicationConnection(@Nonnull QuicApplicationErrorCode errorCode);

    /**
     * Closes the connection gracefully with an application error code and reason message.
     * The reason is serialized as a {@link FormattedMessage} into the QUIC CONNECTION_CLOSE
     * frame so the peer can render a localized disconnect reason.
     *
     * @param errorCode Application-defined error code
     * @param reason    Reason message carried in the CONNECTION_CLOSE reason phrase
     */
    void closeApplicationConnection(@Nonnull QuicApplicationErrorCode errorCode, @Nonnull FormattedMessage reason);

    /**
     * Updates the QUIC stream priority for this connection's stream.
     * Lower urgency values indicate higher priority. Incremental streams may be
     * interleaved with other streams at the same urgency level.
     *
     * @param urgency     The urgency level (0 = highest priority)
     * @param incremental Whether this stream's data can be interleaved with other streams
     */
    void updateStreamPriority(int urgency, boolean incremental);
}
