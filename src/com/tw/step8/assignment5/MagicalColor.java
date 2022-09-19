package com.tw.step8.assignment5;

import java.util.HashSet;

public enum MagicalColor {
    GREEN() {
        @Override
        public boolean isAddable(HashSet<MagicBall> balls) {
            long greenBalls = MagicalColor.countBallsOfColor(balls, MagicalColor.GREEN);
            return greenBalls < 3;
        }
    },
    RED() {
        @Override
        public boolean isAddable(HashSet<MagicBall> balls) {
            long greenBalls = MagicalColor.countBallsOfColor(balls, MagicalColor.GREEN);
            long redBalls = MagicalColor.countBallsOfColor(balls, MagicalColor.RED);

            return (2 * greenBalls) > redBalls;
        }
    },
    BLUE() {
        @Override
        public boolean isAddable(HashSet<MagicBall> balls) {
            long blackBalls = MagicalColor.countBallsOfColor(balls, MagicalColor.BLACK);
            return blackBalls == 0;
        }
    },
    BLACK() {
        @Override
        public boolean isAddable(HashSet<MagicBall> balls) {
            long blueBalls = MagicalColor.countBallsOfColor(balls, MagicalColor.BLUE);
            return blueBalls == 0;
        }
    },
    YELLOW() {
        @Override
        public boolean isAddable(HashSet<MagicBall> balls) {
            long yellowBalls = countBallsOfColor(balls, MagicalColor.YELLOW);
            double futurePercentageOfYellow = (yellowBalls + 1) * 100.0 / (balls.size() + 1);

            return futurePercentageOfYellow <= 40;
        }
    };

    MagicalColor() {
    }

    public boolean isAddable(HashSet<MagicBall> balls) {
        return false;
    }

    private static long countBallsOfColor(HashSet<MagicBall> balls, MagicalColor magicalColor) {
        return balls.stream()
                .filter(ball -> ball.magicalColor == magicalColor)
                .count();
    }
}
