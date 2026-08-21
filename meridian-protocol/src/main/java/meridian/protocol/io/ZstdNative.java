package meridian.protocol.io;

import java.io.IOException;
import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Locale;

/**
 * FFM bindings for libzstd compression library.
 * Loads the native library from classpath resources (same binaries as the client).
 * <p>
 * All target platforms (Linux x64, macOS arm64, Windows x64) are 64-bit,
 * so size_t is always 8 bytes and mapped to Java long.
 */
public final class ZstdNative {
    private ZstdNative() {}

    private static final Linker LINKER = Linker.nativeLinker();
    private static final Arena GLOBAL_ARENA = Arena.global();
    private static final SymbolLookup LOOKUP;

    private static final ValueLayout.OfLong C_SIZE_T;
    private static final ValueLayout.OfInt C_INT = ValueLayout.JAVA_INT;
    private static final ValueLayout.OfLong C_UNSIGNED_LONG_LONG = ValueLayout.JAVA_LONG;
    private static final AddressLayout C_POINTER = ValueLayout.ADDRESS;

    static {
        var canonicalSizeT = LINKER.canonicalLayouts().get("size_t");
        if (!(canonicalSizeT instanceof ValueLayout.OfLong sizeT)) {
            throw new UnsupportedOperationException("ZstdNative requires a 64-bit platform (size_t is " + canonicalSizeT + ")");
        }
        C_SIZE_T = sizeT;

        var osName = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        var arch = System.getProperty("os.arch").toLowerCase(Locale.ROOT);

        String resourcePath;
        if (osName.contains("linux")) {
            if (!"amd64".equals(arch) && !"x86_64".equals(arch)) {
                throw new UnsupportedOperationException("Unsupported Linux architecture: " + arch);
            }
            resourcePath = "/native/linux-x64/libzstd.so";
        } else if (osName.contains("mac") || osName.contains("darwin")) {
            if (!"aarch64".equals(arch)) {
                throw new UnsupportedOperationException("Unsupported macOS architecture: " + arch);
            }
            resourcePath = "/native/osx-arm64/libzstd.dylib";
        } else if (osName.contains("win")) {
            if (!"amd64".equals(arch) && !"x86_64".equals(arch)) {
                throw new UnsupportedOperationException("Unsupported Windows architecture: " + arch);
            }
            resourcePath = "/native/win-x64/zstd.dll";
        } else {
            throw new UnsupportedOperationException("Unsupported OS: " + osName);
        }

        try (var stream = ZstdNative.class.getResourceAsStream(resourcePath)) {
            if (stream == null) {
                throw new IllegalStateException("Native library not found on classpath: " + resourcePath);
            }
            var tmpDir = Files.createTempDirectory("zstd-native");
            var libPath = tmpDir.resolve(Path.of(resourcePath).getFileName());
            Files.copy(stream, libPath, StandardCopyOption.REPLACE_EXISTING);
            libPath.toFile().deleteOnExit();
            tmpDir.toFile().deleteOnExit();
            LOOKUP = SymbolLookup.libraryLookup(libPath, GLOBAL_ARENA);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    // size_t ZSTD_compress(void* dst, size_t dstCapacity, const void* src, size_t srcSize, int compressionLevel)
    private static final MethodHandle ZSTD_COMPRESS = downcall("ZSTD_compress",
            FunctionDescriptor.of(C_SIZE_T, C_POINTER, C_SIZE_T, C_POINTER, C_SIZE_T, C_INT));

    // size_t ZSTD_decompress(void* dst, size_t dstCapacity, const void* src, size_t compressedSize)
    private static final MethodHandle ZSTD_DECOMPRESS = downcall("ZSTD_decompress",
            FunctionDescriptor.of(C_SIZE_T, C_POINTER, C_SIZE_T, C_POINTER, C_SIZE_T));

    // size_t ZSTD_compressBound(size_t srcSize)
    private static final MethodHandle ZSTD_COMPRESS_BOUND = downcall("ZSTD_compressBound",
            FunctionDescriptor.of(C_SIZE_T, C_SIZE_T));

    // unsigned long long ZSTD_getFrameContentSize(const void* src, size_t srcSize)
    private static final MethodHandle ZSTD_GET_FRAME_CONTENT_SIZE = downcall("ZSTD_getFrameContentSize",
            FunctionDescriptor.of(C_UNSIGNED_LONG_LONG, C_POINTER, C_SIZE_T));

    // unsigned ZSTD_isError(size_t code)
    private static final MethodHandle ZSTD_IS_ERROR = downcall("ZSTD_isError",
            FunctionDescriptor.of(C_INT, C_SIZE_T));

    // const char* ZSTD_getErrorName(size_t code)
    private static final MethodHandle ZSTD_GET_ERROR_NAME = downcall("ZSTD_getErrorName",
            FunctionDescriptor.of(C_POINTER, C_SIZE_T));

    // ZSTD_CCtx* ZSTD_createCCtx(void)
    private static final MethodHandle ZSTD_CREATE_CCTX = downcall("ZSTD_createCCtx",
            FunctionDescriptor.of(C_POINTER));

    // size_t ZSTD_freeCCtx(ZSTD_CCtx* cctx)
    private static final MethodHandle ZSTD_FREE_CCTX = downcall("ZSTD_freeCCtx",
            FunctionDescriptor.of(C_SIZE_T, C_POINTER));

    // size_t ZSTD_compressCCtx(ZSTD_CCtx* cctx, void* dst, size_t dstCapacity, const void* src, size_t srcSize, int compressionLevel)
    private static final MethodHandle ZSTD_COMPRESS_CCTX = downcall("ZSTD_compressCCtx",
            FunctionDescriptor.of(C_SIZE_T, C_POINTER, C_POINTER, C_SIZE_T, C_POINTER, C_SIZE_T, C_INT));

    // ZSTD_DCtx* ZSTD_createDCtx(void)
    private static final MethodHandle ZSTD_CREATE_DCTX = downcall("ZSTD_createDCtx",
            FunctionDescriptor.of(C_POINTER));

    // size_t ZSTD_freeDCtx(ZSTD_DCtx* dctx)
    private static final MethodHandle ZSTD_FREE_DCTX = downcall("ZSTD_freeDCtx",
            FunctionDescriptor.of(C_SIZE_T, C_POINTER));

    // size_t ZSTD_decompressDCtx(ZSTD_DCtx* dctx, void* dst, size_t dstCapacity, const void* src, size_t compressedSize)
    private static final MethodHandle ZSTD_DECOMPRESS_DCTX = downcall("ZSTD_decompressDCtx",
            FunctionDescriptor.of(C_SIZE_T, C_POINTER, C_POINTER, C_SIZE_T, C_POINTER, C_SIZE_T));

    // int ZSTD_defaultCLevel(void)
    private static final MethodHandle ZSTD_DEFAULT_C_LEVEL = downcall("ZSTD_defaultCLevel",
            FunctionDescriptor.of(C_INT));

    private static MethodHandle downcall(String name, FunctionDescriptor descriptor) {
        return LINKER.downcallHandle(LOOKUP.find(name).orElseThrow(() ->
                new UnsatisfiedLinkError("Missing symbol: " + name)), descriptor);
    }

    /**
     * Compress src into dst.
     *
     * @return compressed size, or an error code (check with {@link #isError})
     */
    public static long compress(MemorySegment dst, long dstCapacity, MemorySegment src, long srcSize, int compressionLevel) {
        try {
            return (long) ZSTD_COMPRESS.invokeExact(dst, dstCapacity, src, srcSize, compressionLevel);
        } catch (Throwable t) {
            throw sneaky(t);
        }
    }

    /**
     * Decompress src into dst.
     *
     * @return decompressed size, or an error code (check with {@link #isError})
     */
    public static long decompress(MemorySegment dst, long dstCapacity, MemorySegment src, long compressedSize) {
        try {
            return (long) ZSTD_DECOMPRESS.invokeExact(dst, dstCapacity, src, compressedSize);
        } catch (Throwable t) {
            throw sneaky(t);
        }
    }

    /**
     * @return maximum compressed size for a given source size
     */
    public static long compressBound(long srcSize) {
        try {
            return (long) ZSTD_COMPRESS_BOUND.invokeExact(srcSize);
        } catch (Throwable t) {
            throw sneaky(t);
        }
    }

    /**
     * @return decompressed content size from the frame header, or {@link #CONTENT_SIZE_UNKNOWN} / {@link #CONTENT_SIZE_ERROR}
     */
    public static long getFrameContentSize(MemorySegment src, long srcSize) {
        try {
            return (long) ZSTD_GET_FRAME_CONTENT_SIZE.invokeExact(src, srcSize);
        } catch (Throwable t) {
            throw sneaky(t);
        }
    }

    public static boolean isError(long code) {
        try {
            return (int) ZSTD_IS_ERROR.invokeExact(code) != 0;
        } catch (Throwable t) {
            throw sneaky(t);
        }
    }

    public static String getErrorName(long code) {
        try {
            var ptr = (MemorySegment) ZSTD_GET_ERROR_NAME.invokeExact(code);
            return ptr.reinterpret(256).getString(0);
        } catch (Throwable t) {
            throw sneaky(t);
        }
    }

    public static int defaultCompressionLevel() {
        try {
            return (int) ZSTD_DEFAULT_C_LEVEL.invokeExact();
        } catch (Throwable t) {
            throw sneaky(t);
        }
    }

    /**
     * Create a compression context. The returned segment must be freed with {@link #freeCCtx}.
     *
     * @return opaque ZSTD_CCtx pointer, or {@link MemorySegment#NULL} on allocation failure
     */
    public static MemorySegment createCCtx() {
        try {
            return (MemorySegment) ZSTD_CREATE_CCTX.invokeExact();
        } catch (Throwable t) {
            throw sneaky(t);
        }
    }

    /**
     * Free a compression context previously created with {@link #createCCtx}.
     *
     * @return 0 on success, or an error code (check with {@link #isError})
     */
    public static long freeCCtx(MemorySegment cctx) {
        try {
            return (long) ZSTD_FREE_CCTX.invokeExact(cctx);
        } catch (Throwable t) {
            throw sneaky(t);
        }
    }

    /**
     * Compress src into dst using a reusable compression context.
     * The context is reset internally between calls so it can be reused without recreation.
     *
     * @return compressed size, or an error code (check with {@link #isError})
     */
    public static long compressCCtx(MemorySegment cctx, MemorySegment dst, long dstCapacity, MemorySegment src, long srcSize, int compressionLevel) {
        try {
            return (long) ZSTD_COMPRESS_CCTX.invokeExact(cctx, dst, dstCapacity, src, srcSize, compressionLevel);
        } catch (Throwable t) {
            throw sneaky(t);
        }
    }

    /**
     * Create a decompression context. The returned segment must be freed with {@link #freeDCtx}.
     *
     * @return opaque ZSTD_DCtx pointer, or {@link MemorySegment#NULL} on allocation failure
     */
    public static MemorySegment createDCtx() {
        try {
            return (MemorySegment) ZSTD_CREATE_DCTX.invokeExact();
        } catch (Throwable t) {
            throw sneaky(t);
        }
    }

    /**
     * Free a decompression context previously created with {@link #createDCtx}.
     *
     * @return 0 on success, or an error code (check with {@link #isError})
     */
    public static long freeDCtx(MemorySegment dctx) {
        try {
            return (long) ZSTD_FREE_DCTX.invokeExact(dctx);
        } catch (Throwable t) {
            throw sneaky(t);
        }
    }

    /**
     * Decompress src into dst using a reusable decompression context.
     * The context is reset internally between calls so it can be reused without recreation.
     *
     * @return decompressed size, or an error code (check with {@link #isError})
     */
    public static long decompressDCtx(MemorySegment dctx, MemorySegment dst, long dstCapacity, MemorySegment src, long compressedSize) {
        try {
            return (long) ZSTD_DECOMPRESS_DCTX.invokeExact(dctx, dst, dstCapacity, src, compressedSize);
        } catch (Throwable t) {
            throw sneaky(t);
        }
    }

    /** Returned by {@link #getFrameContentSize} when the size is unknown. */
    public static final long CONTENT_SIZE_UNKNOWN = -1L; // ZSTD_CONTENTSIZE_UNKNOWN (0ULL - 1)
    /** Returned by {@link #getFrameContentSize} on error. */
    public static final long CONTENT_SIZE_ERROR = -2L;    // ZSTD_CONTENTSIZE_ERROR (0ULL - 2)

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> RuntimeException sneaky(Throwable t) throws T {
        throw (T) t;
    }
}
