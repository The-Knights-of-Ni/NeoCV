package org.knightsofni.acv;

public class RustNativeOptionsBuilder {
    public String cameraName;
    public String path;
    public RustNativeOptions.CommunicationMethod communicationMethod; // Experimental

    public RustNativeOptionsBuilder cameraName(String cameraName) {
        this.cameraName = cameraName;
        return this;
    }

    public RustNativeOptionsBuilder socketPath(String path) {
        this.path = path;
        return this;
    }

    public RustNativeOptionsBuilder useSocketInput(RustNativeOptions.CommunicationMethod communicationMethod) {
        this.communicationMethod = communicationMethod;
        return this;
    }

    public RustNativeOptions build() {
        return new RustNativeOptions(cameraName, path, communicationMethod);
    }
}
