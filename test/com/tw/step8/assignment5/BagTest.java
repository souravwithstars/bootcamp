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
    void shouldNotPutMagicBallToTheBagIfTheBagsColorLimitIsReached() {
        Bag bag = new Bag(3, Color.GREEN, 1);
        MagicBall magicBall1 = new MagicBall(1, Color.GREEN);
        MagicBall magicBall2 = new MagicBall(2, Color.GREEN);

        assertTrue(bag.put(magicBall1));
        assertFalse(bag.put(magicBall2));
    }
}