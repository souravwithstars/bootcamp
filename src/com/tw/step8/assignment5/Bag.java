package com.tw.step8.assignment5;

import com.tw.step8.assignment5.exception.NoSpaceInBagException;

import java.util.HashSet;

public class Bag {
    private HashSet<MagicBall> balls;
    private Integer maxSize;

    public Bag(Integer maxSize) {
        this.balls = new HashSet<MagicBall>(maxSize);
        this.maxSize = maxSize;
    }

    public boolean put(MagicBall magicBall) throws NoSpaceInBagException {
        if (isAddable(magicBall)) {
            return this.balls.add(magicBall);
        }
        return false;
    }

    private boolean isFull() throws NoSpaceInBagException {
        if (this.balls.size() == this.maxSize) throw new NoSpaceInBagException(this.maxSize);

        return false;
    }

    private boolean isAddable(MagicBall magicBall) throws NoSpaceInBagException {
        Color ballColor = magicBall.color;
        return !this.isFull() && ballColor.isAddable(this.balls);
    }
}
