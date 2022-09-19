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

    private boolean isAddable(MagicBall magicBall) {
        return !this.isFull() && this.isCriteriaMatchForAdding(magicBall);
    }

    private boolean isCriteriaMatchForAdding(MagicBall magicBall) {
        if (magicBall.color == Color.RED) return this.canAddRedBalls();
        if (magicBall.color == Color.YELLOW) return this.canAddYellowBalls();
        if(magicBall.color == Color.BLUE) return this.canAddBlueBalls();
        if(magicBall.color == Color.BLACK) return this.canAddBlackBalls();
        if(magicBall.color == Color.GREEN) return this.canAddGreenBalls();

        return false;
    }

    private boolean canAddGreenBalls() {
        long greenBalls = countBallsOfColor(Color.GREEN);
        return greenBalls < 3;
    }

    private boolean canAddBlackBalls() {
        long blueBalls = countBallsOfColor(Color.BLUE);
        return blueBalls == 0;
    }

    private boolean canAddBlueBalls() {
        long blackBalls = countBallsOfColor(Color.BLACK);
        return blackBalls == 0;
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
