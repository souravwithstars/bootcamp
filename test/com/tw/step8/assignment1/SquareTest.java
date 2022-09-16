package com.tw.step8.assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
  //  TEST for Area of Square
  @Test
  void shouldFindAreaOfGivenSquare() {
    Rectangle square = Rectangle.createSquare(10);
    assertEquals(100, square.area());

    Rectangle square2 = Rectangle.createSquare(10.5);
    assertEquals(110.25, square2.area());
  }

  //  TEST for Perimeter of Square
  @Test
  void shouldFindPerimeterOfGivenSquare() {
    Rectangle square = Rectangle.createSquare(10);
    assertEquals(40, square.perimeter());

    Rectangle square2 = Rectangle.createSquare(10.5);
    assertEquals(42, square2.perimeter());
  }
}