package meridian.internal;

import meridian.internal.core.ProxyConfig;

/**
 * A target server as typed into the Connect bar.
 *
 * <p>The port is optional: Hytale's stock server port is the same
 * {@value meridian.internal.core.ProxyConfig#DEFAULT_REMOTE_PORT} everywhere, so
 * {@code play.example.com} and {@code play.example.com:5520} mean the same thing and the
 * user only has to type the port when a server runs on a non-standard one.
 */
public record RemoteAddress(String host, int port) {

    /**
     * Parses {@code host}, {@code host:port}, {@code [v6]} or {@code [v6]:port}.
     *
     * <p>A bare IPv6 literal is accepted unbracketed too — it carries more than one colon,
     * which is unambiguous since a host:port pair has exactly one.
     *
     * @throws IllegalArgumentException if the host is empty or the port is not 1-65535
     */
    public static RemoteAddress parse(String text) {
        String s = text == null ? "" : text.trim();
        if (s.isEmpty()) {
            throw new IllegalArgumentException("Enter a server address.");
        }

        String host;
        String portPart = null;

        if (s.startsWith("[")) {
            int close = s.indexOf(']');
            if (close < 0) {
                throw new IllegalArgumentException("Unclosed '[' in the address.");
            }
            host = s.substring(1, close);
            String rest = s.substring(close + 1);
            if (rest.startsWith(":")) {
                portPart = rest.substring(1);
            } else if (!rest.isEmpty()) {
                throw new IllegalArgumentException("Unexpected text after ']'.");
            }
        } else {
            int colon = s.indexOf(':');
            if (colon >= 0 && colon == s.lastIndexOf(':')) {
                host = s.substring(0, colon);
                portPart = s.substring(colon + 1);
            } else {
                host = s;   // no port, or a bare IPv6 literal
            }
        }

        if (host.isBlank()) {
            throw new IllegalArgumentException("Missing host.");
        }
        if (portPart == null || portPart.isBlank()) {
            return new RemoteAddress(host, ProxyConfig.DEFAULT_REMOTE_PORT);
        }

        int port;
        try {
            port = Integer.parseInt(portPart.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Port '" + portPart + "' is not a number.");
        }
        if (port < 1 || port > 65535) {
            throw new IllegalArgumentException("Port must be 1-65535.");
        }
        return new RemoteAddress(host, port);
    }

    /** Best-effort parse for live UI feedback: null instead of an exception. */
    public static RemoteAddress tryParse(String text) {
        try {
            return parse(text);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /** {@code host:port}, bracketing an IPv6 literal — the form stored in the recents list. */
    public String toWire() {
        return (host.indexOf(':') >= 0 ? "[" + host + "]" : host) + ":" + port;
    }
}
