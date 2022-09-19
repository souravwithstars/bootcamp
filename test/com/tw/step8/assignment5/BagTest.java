package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void shouldPutMagicBallToTheBag() {
        Bag bag = new Bag(12);
        MagicBall magicBall1 = new MagicBall(1);

        assertTrue(bag.put(magicBall1));
    }

    @Test
    void shouldNotPutMagicBallToTheBagIfTheBagIsFull() {
        Bag bag = new Bag(1);
        MagicBall magicBall1 = new MagicBall(1);
        MagicBall magicBall2 = new MagicBall(2);

        assertTrue(bag.put(magicBall1));
        assertTrue(bag.put(magicBall2));
    }
}