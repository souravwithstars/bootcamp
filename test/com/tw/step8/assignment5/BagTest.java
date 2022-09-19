package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void shouldPutMagicBallToTheBag() {
        Bag bag = new Bag(12, Color.GREEN, 3);
        MagicBall magicBall1 = new MagicBall(1, Color.GREEN);

        assertTrue(bag.put(magicBall1));
    }

    @Test
    void shouldNotPutMagicBallToTheBagIfTheBagIsFull() {
        Bag bag = new Bag(1, Color.GREEN, 3);
        MagicBall magicBall1 = new MagicBall(1, Color.GREEN);
        MagicBall magicBall2 = new MagicBall(2, Color.GREEN);

        assertTrue(bag.put(magicBall1));
        assertFalse(bag.put(magicBall2));
    }

    @Test
    void shouldNotPutMagicBallToTheBagIfBallsColorLimitIsReached() {
        Bag bag = new Bag(3, Color.GREEN, 1);
        MagicBall magicBall1 = new MagicBall(1, Color.GREEN);
        MagicBall magicBall2 = new MagicBall(2, Color.GREEN);

        assertTrue(bag.put(magicBall1));
        assertFalse(bag.put(magicBall2));
    }

    @Test
    void shouldNotPutRedMagicBallToTheBagIfBagIsEmpty() {
        Bag bag = new Bag(3, Color.GREEN, 1);
        MagicBall redMagicBall = new MagicBall(1, Color.RED);

        assertFalse(bag.put(redMagicBall));
    }

    @Test
    void shouldNotPut3rdRedMagicBallIfBagContainsOneGreenBall() {
        Bag bag = new Bag(5, Color.GREEN, 1);
        MagicBall greenMagicBall = new MagicBall(1, Color.GREEN);
        MagicBall redMagicBall1 = new MagicBall(2, Color.RED);
        MagicBall redMagicBall2 = new MagicBall(3, Color.RED);
        MagicBall redMagicBall3 = new MagicBall(4, Color.RED);

        assertTrue(bag.put(greenMagicBall));
        assertTrue(bag.put(redMagicBall1));
        assertTrue(bag.put(redMagicBall2));
        assertFalse(bag.put(redMagicBall3));
    }

    @Test
    void shouldNotPutYellowAtFirstIfBagCapacityIsLessThanThree() {
        Bag bag = new Bag(1, Color.GREEN, 1);
        MagicBall yellowMagicBall = new MagicBall(1, Color.YELLOW);

        assertFalse(bag.put(yellowMagicBall));
    }

    @Test
    void shouldPutOneYellowIfBagsCurrentBallsCountIsTwo() {
        Bag bag = new Bag(4, Color.GREEN, 1);
        MagicBall greenMagicBall = new MagicBall(1, Color.GREEN);
        MagicBall redMagicBall = new MagicBall(2, Color.RED);
        MagicBall yellowMagicBall = new MagicBall(3, Color.YELLOW);

        assertTrue(bag.put(greenMagicBall));
        assertTrue(bag.put(redMagicBall));
        assertTrue(bag.put(yellowMagicBall));
    }

    @Test
    void shouldPutSecondYellowIfBagsCurrentBallsCountIsThree() {
        Bag bag = new Bag(4, Color.GREEN, 1);
        MagicBall greenMagicBall = new MagicBall(1, Color.GREEN);
        MagicBall redMagicBall = new MagicBall(2, Color.RED);
        MagicBall yellowMagicBall1 = new MagicBall(3, Color.YELLOW);
        MagicBall yellowMagicBall2 = new MagicBall(4, Color.YELLOW);

        assertTrue(bag.put(greenMagicBall));
        assertTrue(bag.put(redMagicBall));
        assertTrue(bag.put(yellowMagicBall1));
        assertFalse(bag.put(yellowMagicBall2));
    }

    @Test
    void shouldNotAddBlueBallIfBagContainsBlackBalls() {
        Bag bag = new Bag(4, Color.GREEN, 1);
        MagicBall blackMagicBall = new MagicBall(1, Color.BLACK);
        MagicBall blueMagicBall = new MagicBall(2, Color.BLUE);

        assertTrue(bag.put(blackMagicBall));
        assertFalse(bag.put(blueMagicBall));
    }

    @Test
    void shouldNotAddBlackBallIfBagContainsBlueBalls() {
        Bag bag = new Bag(4, Color.GREEN, 1);
        MagicBall blueMagicBall = new MagicBall(1, Color.BLUE);
        MagicBall blackMagicBall = new MagicBall(2, Color.BLACK);

        assertTrue(bag.put(blueMagicBall));
        assertFalse(bag.put(blackMagicBall));
    }
}