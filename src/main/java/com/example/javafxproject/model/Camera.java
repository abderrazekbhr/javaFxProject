package com.example.javafxproject.model;

import static java.lang.Math.abs;

public class Camera {
    private double xCamPosition,
            xCamSpeed,
            yCamPosition,
            yCamSpeed,
            yCamAcceleration;

    public Camera() {

    }

    public double getCamXPosition() {
        return xCamPosition;
    }

    public double getCamXSpeed() {
        return xCamSpeed;
    }

    public double getCamYPosition() {
        return yCamPosition;
    }

    public double getYCamSpeed() {
        return yCamSpeed;
    }

    public double getYCamAcceleration() {
        return yCamAcceleration;
    }

    public void setXCamPosition(double xCamPosition) {
        this.xCamPosition = xCamPosition;
    }

    public void setXCamSpeed(double xCamSpeed) {
        this.xCamSpeed = xCamSpeed;
    }

    public void setYCamPosition(double yCamPosition) {
        this.yCamPosition = yCamPosition;
    }

    public void setYCamSpeed(double yCamSpeed) {
        this.yCamSpeed = yCamSpeed;
    }

    public void setYCamAcceleration(double yCamAcceleration) {
        this.yCamAcceleration = yCamAcceleration;
    }

    public void update(
            double xHeroSpeed,
            double xHeroPosition,
            double yHeroAcceleration,
            double yHeroPosition) {
        xCamSpeed += (-xCamSpeed + xHeroSpeed) / 10;
        double position = (xHeroPosition - xCamPosition) / GameScene.WIDTH;
        xCamPosition += abs(position - 0.5) * (-xCamPosition + xHeroPosition - GameScene.POS_INIT) * 4.0 / 50;
        yCamAcceleration += (-yCamAcceleration + yHeroAcceleration) / 4;
        yCamPosition += (-yCamPosition + yHeroPosition - GameScene.POS_INIT) / 4;
        xCamPosition += xCamSpeed;
        yCamSpeed += yCamAcceleration;
        yCamPosition += yCamSpeed;

    }

}
