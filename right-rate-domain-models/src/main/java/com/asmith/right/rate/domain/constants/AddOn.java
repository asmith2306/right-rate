package com.asmith.right.rate.domain.constants;

/**
 * @author asmith
 */
public enum AddOn {

    ThreeD("3D Support"), CROSS_PLAY("Cross Play"),
    CAMERA("Camera Support"),HDR("HDR"),
    MOVE("Move Support"), PRO("PS4 Pro Enhanced"),
    VR("VR Support");

    private final String description;

    private AddOn(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
