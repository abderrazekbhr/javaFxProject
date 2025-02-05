package com.example.javafxproject.model;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StaticThing {

    private String fileName;

    private ImageView img;

    // this parameter are used to select a part of the pics
    private double minX;
    private double minY;
    private double maxX;
    private double maxY;

    // this parameter are used to define the position of an image in the scene
    private double posX = 0;
    private double posY = 0;
    private double sizeX = 0;
    private double sizeY = 0;

    public double getSizeX() {
        return maxX;
    }

    public StaticThing(double maxX, double maxY, String fileName) {

        this.maxX = maxX;
        this.maxY = maxY;
        this.fileName = fileName;
        Image sprite = null;
        try {
            sprite = new Image(new FileInputStream(GameScene.IMG_PATH + this.fileName));
            this.img = new ImageView(sprite);
            this.img.setViewport(new Rectangle2D(posX, posY, maxX, maxY));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.img = null;
        }

    }

    public StaticThing(double posX, double posY, double maxX, double maxY, String fileName) {
        this.posX = posX;
        this.posY = posY;
        this.maxX = maxX;
        this.maxY = maxY;
        this.fileName = fileName;
        Image sprite = null;
        try {
            sprite = new Image(new FileInputStream(GameScene.IMG_PATH + this.fileName));
            this.img = new ImageView(sprite);
            this.img.setViewport(new Rectangle2D(posX, posY, maxX, maxY));

            // public StaticThing(Integer posX, Integer posY, Integer sizeX, Integer sizeY,
            // String fileName) {
            // this.posX = posX;
            // this.posY = posY;
            // this.sizeX = sizeX;
            // this.sizeY = sizeY;
            // this.fileName = fileName;
            // Image sprite = null;
            // try {
            // sprite = new Image(new FileInputStream(IMGPATH + this.fileName));
            // this.img = new ImageView(sprite);
            // this.img.setViewport(new Rectangle2D(posX, posY, sizeX, sizeY));
            // >>>>>>> 9687160c6bb25c1baecadc0814d2c3cb2d2a8381

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.img = null;
        }
    }

    // <<<<<<<HEAD

    public StaticThing(String fileName) {
        this.fileName = fileName;
        Image sprite = null;
        try {
            sprite = new Image(new FileInputStream(GameScene.IMG_PATH + this.fileName));
            this.img = new ImageView(sprite);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.img = null;
        }
    }

    public StaticThing() {
    }

    public void setSizeX(Integer sizeX) {
        this.sizeX += sizeX;
    }

    public void setSizeY(Integer sizeY) {
        this.sizeY += sizeY;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public ImageView getImg() {
        return img;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getMinX() {
        return minX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxX() {

        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    public void setMinX(double minX) {
        this.img.setViewport(new Rectangle2D(minX, minY, maxX, maxY));
        this.minX = minX;
    }

    public void setMinY(double minY) {
        this.img.setViewport(new Rectangle2D(minX, StaticThing.this.minY, maxX, maxY));
        this.minY = minY;
    }

    public void setMaxX(double maxX) {
        this.img.setViewport(new Rectangle2D(minX, minY, maxX, maxY));
        this.maxX = maxX;
    }

    public void setMaxY(double maxY) {
        this.img.setViewport(new Rectangle2D(minX, minY, maxX, maxY));
        this.maxY = maxY;
    }

    public void update() {

    }
}
