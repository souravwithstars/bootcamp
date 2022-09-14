package com.tw.step8.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
  //  TEST for Area of Square
  @Test
  void shouldFindAreaOfGivenSquare() {
    Square square = new Square(10);
    assertEquals(100, square.area());
  }

  @Test
  void shouldFindAreaWithSidesOfDecimalValue() {
    Square square = new Square(10.5);
    assertEquals(110.25, square.area());
  }

  //  TEST for Perimeter of Square
  @Test
  void shouldFindPerimeterOfGivenSquare() {
    Square square = new Square(10);
    assertEquals(40, square.perimeter());
  }

  @Test
  void shouldFindPerimeterWithSidesOfDecimalValue() {
    Square square = new Square(10.5);
    assertEquals(42, square.perimeter());
  }
}