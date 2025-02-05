package com.example.javafxproject.model;

import java.util.Random;

public class Obstacle extends StaticThing {

    public static Random random = new Random();
    private boolean upDown;
    private boolean color;

    public Obstacle(int pos) {
        super(52, 320, "img/pipe-red.png");
        int maxY = 80;
        setMaxY(maxY);
        getImg().setX(pos);
        setPosX(340);
        this.color = random.nextBoolean();
        this.upDown = random.nextBoolean();
        setFileName("img/pipe-red.png");
        setPosY(60);
        getImg().setY(450);
        getImg().setScaleY(1);

    }

}
