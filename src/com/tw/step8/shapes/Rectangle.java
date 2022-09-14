package com.tw.step8.shapes;

public class Rectangle {
  private final double height;
  private final double width;

  Rectangle(double height, double width) {
    this.height = height;
    this.width = width;
  }

  public static Rectangle createRectangle(double height, double width) {
    return new Rectangle(height, width);
  }

  public static Rectangle createSquare(double side) {
    return new Rectangle(side, side);
  }

  public double area() {
    return this.height * this.width;
  }

  public double perimeter() {
    return 2 * (this.height + this.width);
  }
}
