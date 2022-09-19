package com.tw.step8.assignment5;

import java.util.HashSet;

public class Bag {
    private HashSet<MagicBall> balls;

    public Bag(Integer maxSize) {
        this.balls = new HashSet<>(maxSize);
    }

    public boolean put(MagicBall magicBall) {
        return this.balls.add(magicBall);
    }
}
