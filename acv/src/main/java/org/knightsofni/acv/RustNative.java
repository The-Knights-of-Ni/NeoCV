package org.knightsofni.acv;

public class RustNative {
    static {
        System.loadLibrary("acv");
    }

    public void run(RustCamera input, RustNativeOptions options) {
        nativeRun(input, options.cameraName, options.socketPath, options.useSocketInput);
    }

    public native void nativeRun(RustCamera input, String cameraName, String socketPath, boolean useSocketInput);
}
