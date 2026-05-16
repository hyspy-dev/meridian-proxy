package meridian.internal.module;

import meridian.api.module.Scheduler;

import java.time.Duration;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Per-module {@link Scheduler} backed by a single daemon thread. Calling
 * {@link #shutdown()} cancels every outstanding task — invoked when the
 * process shuts down so modules need not track their own futures.
 */
public final class SchedulerImpl implements Scheduler {
    private final ScheduledThreadPoolExecutor executor;

    public SchedulerImpl(String moduleName) {
        this.executor = new ScheduledThreadPoolExecutor(1, runnable -> {
            Thread t = new Thread(runnable, "module-" + moduleName + "-scheduler");
            t.setDaemon(true);
            return t;
        });
        executor.setRemoveOnCancelPolicy(true);
    }

    @Override
    public ScheduledFuture<?> schedule(Runnable task, Duration delay) {
        return executor.schedule(task, delay.toMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, Duration initialDelay, Duration period) {
        return executor.scheduleAtFixedRate(
                task, initialDelay.toMillis(), period.toMillis(), TimeUnit.MILLISECONDS);
    }

    /** Cancels all tasks and stops the scheduler thread. */
    public void shutdown() {
        executor.shutdownNow();
    }
}
