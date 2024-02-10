package org.knightsofni.acv;

public class RustNative {
    static {
        System.loadLibrary("acv");
    }

    public static void run(RustCamera input, RustNativeOptions options) {
        nativeRun(input, options.cameraName, options.path, options.communicationMethod == RustNativeOptions.CommunicationMethod.SOCKET);
    }

    public static native void nativeRun(RustCamera input, String cameraName, String path, boolean useSocketInput);
}
