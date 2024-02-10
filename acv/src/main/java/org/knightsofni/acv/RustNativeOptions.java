package org.knightsofni.acv;

public class RustNativeOptions {
    public String cameraName;
    public String socketPath;
    public boolean useSocketInput; // Experimental

    public RustNativeOptions(String cameraName, String socketPath, boolean useSocketInput) {
        this.cameraName = cameraName;
        this.socketPath = socketPath;
        this.useSocketInput = useSocketInput;
    }
}
