package com.asmith.right.rate.domain.constants;

/**
 * @author asmith
 */
public enum Addon {

    ThreeD("3D Support"), CROSS_PLAY("Cross Play"),
    CAMERA_OPTIONAL("Camera Support"), CAMERA_REQUIRED("Camera Required"),
    HDR("HDR"), MOVE_OPTIONAL("Move Support"), PRO_ENHANCED("PS4 Pro Enhanced"),
    VR("VR Support");

    private final String description;

    private Addon(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
