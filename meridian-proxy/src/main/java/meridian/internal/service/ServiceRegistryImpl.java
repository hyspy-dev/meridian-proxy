package meridian.internal.service;

import meridian.api.service.ServiceRegistry;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/** Process-wide {@link ServiceRegistry}, scoped to one proxy run. */
public final class ServiceRegistryImpl implements ServiceRegistry {
    private final Map<Class<?>, Object> services = new ConcurrentHashMap<>();

    @Override
    public <T> void provide(Class<T> iface, T impl) {
        services.put(iface, impl);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Optional<T> get(Class<T> iface) {
        return Optional.ofNullable((T) services.get(iface));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T require(Class<T> iface) {
        T service = (T) services.get(iface);
        if (service == null) {
            throw new NoSuchElementException("No service registered for " + iface.getName());
        }
        return service;
    }
}
