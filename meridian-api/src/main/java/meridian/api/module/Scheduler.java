package meridian.api.module;

import java.time.Duration;
import java.util.concurrent.ScheduledFuture;

/**
 * Per-module scheduler for tickers and deferred actions.
 *
 * <p>All futures returned here are automatically cancelled when the process
 * shuts down — a module does not need to track them itself. Tasks run off the
 * Netty event loop, so short blocking work is acceptable; heavy or long
 * blocking work belongs on {@link ModuleContext#offloadExecutor()}.
 */
public interface Scheduler {
    /** Runs {@code task} once after {@code delay}. */
    ScheduledFuture<?> schedule(Runnable task, Duration delay);

    /** Runs {@code task} repeatedly: first after {@code initialDelay}, then every {@code period}. */
    ScheduledFuture<?> scheduleAtFixedRate(Runnable task, Duration initialDelay, Duration period);
}
