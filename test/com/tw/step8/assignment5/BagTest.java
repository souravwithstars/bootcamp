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
        Bag bag = new Bag(3, Color.GREEN, 1);
        MagicBall greenMagicBall = new MagicBall(1, Color.GREEN);
        MagicBall redMagicBall1 = new MagicBall(2, Color.RED);
        MagicBall redMagicBall2 = new MagicBall(3, Color.RED);
        MagicBall redMagicBall3 = new MagicBall(4, Color.RED);

        assertTrue(bag.put(greenMagicBall));
        assertTrue(bag.put(redMagicBall1));
        assertTrue(bag.put(redMagicBall2));
        assertFalse(bag.put(redMagicBall3));
    }
}