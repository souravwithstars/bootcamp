package com.tw.step8.assignment1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

  //  TEST for Area of Rectangle
  @Test
  void shouldFindAreaOfGivenRectangle() {
    Rectangle rectangle = Rectangle.createRectangle(10, 20);
    assertEquals(200, rectangle.area());

    Rectangle rectangle2 = Rectangle.createRectangle(10.5, 20.5);
    assertEquals(215.25, rectangle2.area());
  }

  //  TEST for Perimeter of Rectangle
  @Test
  void shouldFindPerimeterOfGivenRectangle() {
    Rectangle rectangle = Rectangle.createRectangle(5, 10);
    assertEquals(30, rectangle.perimeter());

    Rectangle rectangle2 = Rectangle.createRectangle(5.5, 10.25);
    assertEquals(31.5, rectangle2.perimeter());
  }
}