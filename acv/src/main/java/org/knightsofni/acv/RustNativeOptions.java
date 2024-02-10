package org.knightsofni.acv;

public class RustNativeOptions {
    public enum CommunicationMethod {
        SOCKET,
        NETWORK
    }

    public String cameraName;
    public String path;
    public CommunicationMethod communicationMethod; // Experimental

    public RustNativeOptions(String cameraName, String path, CommunicationMethod communicationMethod) {
        this.cameraName = cameraName;
        this.path = path;
        this.communicationMethod = communicationMethod;
    }
}
