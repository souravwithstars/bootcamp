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
        if (magicBall.color == color.RED) return !this.canAddRedBalls();
        if (magicBall.color == color.YELLOW) return !this.canAddYellowBalls();

        return countBallsOfColor(magicBall.color) == colorLimit;
    }

    private boolean canAddYellowBalls() {
        long yellowBalls = countBallsOfColor(Color.YELLOW);
        double futurePercentageOfYellow = (yellowBalls + 1) * 100.0 / (this.balls.size() + 1);

        return futurePercentageOfYellow <= 40;
    }

    private boolean canAddRedBalls() {
        long greenBalls = countBallsOfColor(Color.GREEN);
        long redBalls = countBallsOfColor(Color.RED);

        return (2 * greenBalls) > redBalls;
    }

    private long countBallsOfColor(Color color) {
        return this.balls.stream()
                .filter(ball -> ball.color == color)
                .count();
    }

    private boolean isFull() {
        return this.balls.size() == this.maxSize;
    }
}
