package meridian.api.service;

import java.util.Optional;

/**
 * Per-proxy registry through which Layer-1 modules publish services and
 * Layer-2 modules consume them.
 *
 * <p>Skeleton for Phase 1 — declares the contract only. The implementation is
 * wired into {@code ModuleContext} in Phase 3.
 */
public interface ServiceRegistry {
    <T> void provide(Class<T> iface, T impl);

    <T> Optional<T> get(Class<T> iface);

    /** @throws java.util.NoSuchElementException if no provider is registered. */
    <T> T require(Class<T> iface);
}
