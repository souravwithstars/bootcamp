package com.tw.step8.assignment5;

import java.util.HashSet;

public class Bag {
    private HashSet<MagicBall> balls;
    private Integer maxSize;

    public Bag(Integer maxSize) {
        this.balls = new HashSet<MagicBall>(maxSize);
        this.maxSize = maxSize;
    }

    public boolean put(MagicBall magicBall) {
        if (isAddable(magicBall)) {
            return this.balls.add(magicBall);
        }
        return false;
    }

    private boolean isFull() {
        return this.balls.size() == this.maxSize;
    }

    private boolean isAddable(MagicBall magicBall) {
        Color ballColor = magicBall.color;
        return !this.isFull() && ballColor.isAddable(this.balls);
    }
}
