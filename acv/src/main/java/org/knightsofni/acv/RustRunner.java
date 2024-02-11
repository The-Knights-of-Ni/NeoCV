package org.knightsofni.acv;

import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.channels.SocketChannel;

public class RustRunner {
    SocketChannel channel;
    RustRunnerThread thread;

    public RustRunner(RustCamera input, RustNativeOptions options) {
        this.thread = new RustRunnerThread(input, options);
    }

    public void start() {
        thread.start();
    }

    public void join() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void abort() {
        thread.interrupt();
    } // TODO: Safe stop with socket message
}
