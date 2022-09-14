package com.tw.step8.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

  //  TEST for Area of Rectangle
  @Test
  void shouldFindAreaOfGivenRectangle() {
    Rectangle rectangle = new Rectangle(10, 20);
    assertEquals(200, rectangle.area());
  }

  @Test
  void shouldFindAreaOfSidesWithDecimalValue() {
    Rectangle rectangle = new Rectangle(10.5, 20.5);
    assertEquals(215.25, rectangle.area());
  }

  //  TEST for Perimeter of Rectangle
  @Test
  void shouldFindPerimeterOfGivenRectangle() {
    Rectangle rectangle = new Rectangle(5, 10);
    assertEquals(30, rectangle.perimeter());
  }

  @Test
  void shouldFindPerimeterSidesWithDecimalValue() {
    Rectangle rectangle = new Rectangle(5.5, 10.25);
    assertEquals(31.5, rectangle.perimeter());
  }
}