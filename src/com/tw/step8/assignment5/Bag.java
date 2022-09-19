package com.tw.step8.assignment5;

import java.util.HashSet;

public class Bag {
    private HashSet<MagicBall> balls;
    private Integer maxSize;
    private Color color;
    private Integer colorLimit;

    public Bag(Integer maxSize, Color color, Integer colorLimit) {
        this.balls = new HashSet<MagicBall>(maxSize);
        this.maxSize = maxSize;
        this.color = color;
        this.colorLimit = colorLimit;
    }

    public boolean put(MagicBall magicBall) {
        if (isAddable(magicBall)) {
            return this.balls.add(magicBall);
        }
        return false;
    }

    private boolean isAddable(MagicBall magicBall) {
        return !(this.isFull() || this.isColorLimitReached(magicBall));
    }

    private boolean isColorLimitReached(MagicBall magicBall) {
        if (magicBall.color != this.color) return true;

        long count = this.balls.stream()
                .filter(ball -> ball.color == magicBall.color)
                .count();

        return count == colorLimit;
    }

    private boolean isFull() {
        return this.balls.size() == this.maxSize;
    }
}
