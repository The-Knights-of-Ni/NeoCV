package org.knightsofni.acv;

/**
 * Interface for camera that can be passed to the Rust code for image processing.
 */
public interface RustCamera {
    /**
     * Get the width of the camera image.
     * @return the width of the camera image
     */
    int getWidth();

    /**
     * Get the height of the camera image.
     * @return the height of the camera image
     */
    int getHeight();

    /**
     * Get the pixel data of the camera image.
     * @return the pixel data of the camera image
     */
    byte[] getFrame();
}
