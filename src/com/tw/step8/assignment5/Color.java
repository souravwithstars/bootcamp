package com.tw.step8.assignment5;

import java.util.HashSet;

public enum Color {
    GREEN() {
        @Override
        public boolean isAddable(HashSet<MagicBall> balls) {
            long greenBalls = Color.countBallsOfColor(balls, Color.GREEN);
            return greenBalls < 3;
        }
    },
    RED() {
        @Override
        public boolean isAddable(HashSet<MagicBall> balls) {
            long greenBalls = Color.countBallsOfColor(balls, Color.GREEN);
            long redBalls = Color.countBallsOfColor(balls, Color.RED);

            return (2 * greenBalls) > redBalls;
        }
    },
    BLUE() {
        @Override
        public boolean isAddable(HashSet<MagicBall> balls) {
            long blackBalls = Color.countBallsOfColor(balls, Color.BLACK);
            return blackBalls == 0;
        }
    },
    BLACK() {
        @Override
        public boolean isAddable(HashSet<MagicBall> balls) {
            long blueBalls = Color.countBallsOfColor(balls, Color.BLUE);
            return blueBalls == 0;
        }
    },
    YELLOW(){
        @Override
        public boolean isAddable(HashSet<MagicBall> balls) {
            long yellowBalls = countBallsOfColor(balls, Color.YELLOW);
            double futurePercentageOfYellow = (yellowBalls + 1) * 100.0 / (balls.size() + 1);

            return futurePercentageOfYellow <= 40;
        }
    };
    Color() {
    }

    public boolean isAddable(HashSet<MagicBall> balls) {
        return false;
    }

    private static long countBallsOfColor(HashSet<MagicBall> balls, Color color) {
        return balls.stream()
                .filter(ball -> ball.color == color)
                .count();
    }
}
