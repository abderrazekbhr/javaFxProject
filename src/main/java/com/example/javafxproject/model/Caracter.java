package com.example.javafxproject.model;

import javafx.geometry.Rectangle2D;

public class Caracter extends StaticThing {
    public final static double POS_INIT = 100;
    private static final double MAX_SPEED = 10;
    private static int lives = 3;
    private double Paperx = 85, Papery = 100, cpt = 0, cpt2 = 0, Etat = 0;
    private boolean vulnerable = true;
    private double xHeroPosition = 10,
            yHeroPosition = 200,
            xHeroSpeed,
            yHeroSpeed,
            xHeroAcceleration,
            yHeroAcceleration;

    public Caracter(double posX, double posY, double maxX, double maxY, String fileName) {
        super(posX, posY, maxX, maxY, fileName);

        this.getImg().setX(POS_INIT);
        this.getImg().setY(POS_INIT);
    }

    public static int getLives() {
        return lives;
    }

    public static void setLives(int lives) {
        Caracter.lives--;
    }

    public double getXHeroPosition() {
        return xHeroPosition;
    }

    public double getYHeroPosition() {
        return yHeroPosition;
    }

    public double getXHeroSpeed() {
        return xHeroSpeed;
    }

    public double getYHeroSpeed() {
        return yHeroSpeed;
    }

    public double getXHeroAcceleration() {
        return xHeroAcceleration;
    }

    public double getYHeroAcceleration() {
        return yHeroAcceleration;
    }

    public void setXHeroPosition(double xHeroPosition) {
        this.xHeroPosition = xHeroPosition;
    }

    public void setYHeroPosition(double yHeroPosition) {
        this.yHeroPosition = yHeroPosition;
    }

    public void setXHeroSpeed(double xHeroSpeed) {
        this.xHeroSpeed = xHeroSpeed;
    }

    public void setYHeroSpeed(double yHeroSpeed) {
        this.yHeroSpeed = yHeroSpeed;
    }

    public void setXHeroAcceleration(double xHeroAcceleration) {
        this.xHeroAcceleration = xHeroAcceleration;
    }

    public void setYHeroAcceleration(double yHeroAcceleration) {
        this.yHeroAcceleration = yHeroAcceleration;
    }

    @Override
    public void update() {
        final double AG = 1;
        yHeroSpeed = yHeroAcceleration + AG;
        yHeroPosition += yHeroSpeed;
        if (xHeroSpeed > MAX_SPEED) {
            xHeroSpeed = MAX_SPEED;
        } else {
            xHeroSpeed += xHeroAcceleration;
        }
        xHeroPosition += xHeroSpeed;
        if (yHeroPosition > GameScene.POS_INIT) {
            yHeroPosition = GameScene.POS_INIT;
            yHeroSpeed = 0;
            yHeroAcceleration = 0;
        }
    }

    public void transition(double xCamPosition, double yCamPosition) {
        cpt += 1;
        if (vulnerable) {
            this.getImg().setX(xHeroPosition - xCamPosition);
            this.getImg().setY(yHeroPosition - yCamPosition);
            if ((cpt * xHeroSpeed) > 100) {
                Etat += 1;
                cpt = 0;
                this.getImg().setViewport((new Rectangle2D(Paperx * (Etat % 6), 0, Paperx, Papery)));
            } else if ((cpt * xHeroSpeed) < -100) {
                Etat += 1;
                cpt = 0;
                this.getImg().setViewport((new Rectangle2D(Paperx * (5 - (Etat % 6)), 0, Paperx, Papery)));
            }
        } else {
            cpt2 += 1;
            if (cpt2 > 200) {
                vulnerable = true;
                this.getImg().setX(xHeroPosition - xCamPosition);
                this.getImg().setY(yHeroPosition - yCamPosition);
            }
        }

    }

}
