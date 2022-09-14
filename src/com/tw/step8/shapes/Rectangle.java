package com.tw.step8.shapes;

public class Rectangle {
  private final double height;
  private final double width;

  public Rectangle(double height, double width) {
    this.height = height;
    this.width = width;
  }

  public double area() {
    return this.height * this.width;
  }

  public double perimeter() {
    return 2 * (this.height + this.width);
  }
}
