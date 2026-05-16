package meridian.api.module;

/**
 * Parsed {@code module.json} metadata.
 *
 * <p>Skeleton for Phase 1 — mirrors the current v1 schema. Phase 2 extends this
 * with {@code dependsOn}, {@code requires.packets/services} and the
 * {@code minProxyVersion}/{@code maxProxyVersion} range.
 *
 * @param name     unique module id
 * @param version  module SemVer
 * @param main     FQCN of the {@link ProxyModule} implementation
 * @param priority load-order hint within a dependency level (lower = earlier)
 */
public record ModuleManifest(String name, String version, String main, int priority) {
}
