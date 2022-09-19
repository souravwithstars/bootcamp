package com.tw.step8.assignment5;

import com.tw.step8.assignment5.exception.NoSpaceInBagException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
    @Test
    void shouldPutMagicBallToTheBag() throws NoSpaceInBagException {
        Bag bag = new Bag(12);
        MagicBall magicBall1 = new MagicBall(1, Color.GREEN);

        assertTrue(bag.put(magicBall1));
    }

    @Test
    void shouldThrowNoSpaceInBagExceptionIfTheBagIsFull() throws NoSpaceInBagException {
        Bag bag = new Bag(1);
        MagicBall magicBall1 = new MagicBall(1, Color.GREEN);
        MagicBall magicBall2 = new MagicBall(2, Color.GREEN);

        assertTrue(bag.put(magicBall1));
        assertThrows(NoSpaceInBagException.class, () -> bag.put(magicBall2));
    }

    @Test
    void shouldNotPutMagicBallToTheBagIfBallsColorLimitIsReached() throws NoSpaceInBagException {
        Bag bag = new Bag(5);
        MagicBall magicBall1 = new MagicBall(1, Color.GREEN);
        MagicBall magicBall2 = new MagicBall(2, Color.GREEN);
        MagicBall magicBall3 = new MagicBall(3, Color.GREEN);
        MagicBall magicBall4 = new MagicBall(4, Color.GREEN);

        assertTrue(bag.put(magicBall1));
        assertTrue(bag.put(magicBall2));
        assertTrue(bag.put(magicBall3));
        assertFalse(bag.put(magicBall4));
    }

    @Test
    void shouldNotPutRedMagicBallToTheBagIfBagIsEmpty() throws NoSpaceInBagException {
        Bag bag = new Bag(3);
        MagicBall redMagicBall = new MagicBall(1, Color.RED);

        assertFalse(bag.put(redMagicBall));
    }

    @Test
    void shouldNotPut3rdRedMagicBallIfBagContainsOneGreenBall() throws NoSpaceInBagException {
        Bag bag = new Bag(5);
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
    void shouldNotPutYellowAtFirstIfBagCapacityIsLessThanThree() throws NoSpaceInBagException {
        Bag bag = new Bag(1);
        MagicBall yellowMagicBall = new MagicBall(1, Color.YELLOW);

        assertFalse(bag.put(yellowMagicBall));
    }

    @Test
    void shouldPutOneYellowIfBagsCurrentBallsCountIsTwo() throws NoSpaceInBagException {
        Bag bag = new Bag(4);
        MagicBall greenMagicBall = new MagicBall(1, Color.GREEN);
        MagicBall redMagicBall = new MagicBall(2, Color.RED);
        MagicBall yellowMagicBall = new MagicBall(3, Color.YELLOW);

        assertTrue(bag.put(greenMagicBall));
        assertTrue(bag.put(redMagicBall));
        assertTrue(bag.put(yellowMagicBall));
    }

    @Test
    void shouldPutSecondYellowIfBagsCurrentBallsCountIsThree() throws NoSpaceInBagException {
        Bag bag = new Bag(4);
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
    void shouldNotAddBlueBallIfBagContainsBlackBalls() throws NoSpaceInBagException {
        Bag bag = new Bag(4);
        MagicBall blackMagicBall = new MagicBall(1, Color.BLACK);
        MagicBall blueMagicBall = new MagicBall(2, Color.BLUE);

        assertTrue(bag.put(blackMagicBall));
        assertFalse(bag.put(blueMagicBall));
    }

    @Test
    void shouldNotAddBlackBallIfBagContainsBlueBalls() throws NoSpaceInBagException {
        Bag bag = new Bag(4);
        MagicBall blueMagicBall = new MagicBall(1, Color.BLUE);
        MagicBall blackMagicBall = new MagicBall(2, Color.BLACK);

        assertTrue(bag.put(blueMagicBall));
        assertFalse(bag.put(blackMagicBall));
    }
}