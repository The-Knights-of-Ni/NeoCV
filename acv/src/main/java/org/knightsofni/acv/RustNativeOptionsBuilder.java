package org.knightsofni.acv;

public class RustNativeOptionsBuilder {
    public String cameraName;
    public String socketPath;
    public boolean useSocketInput; // Experimental

    public RustNativeOptionsBuilder cameraName(String cameraName) {
        this.cameraName = cameraName;
        return this;
    }

    public RustNativeOptionsBuilder socketPath(String socketPath) {
        this.socketPath = socketPath;
        return this;
    }

    public RustNativeOptionsBuilder useSocketInput(boolean useSocketInput) {
        this.useSocketInput = useSocketInput;
        return this;
    }

    public RustNativeOptions build() {
        return new RustNativeOptions(cameraName, socketPath, useSocketInput);
    }
}
