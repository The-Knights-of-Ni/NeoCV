package org.knightsofni.acv;

public class RustRunnerThread extends Thread {
    RustNativeOptions options;
    RustCamera input;

    public RustRunnerThread(RustCamera input, RustNativeOptions options) {
        this.input = input;
        this.options = options;
    }

    public void run() {
        RustNative.run(input, options);
    }
}
