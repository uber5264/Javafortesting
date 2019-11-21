package ru.stqa.pft.sandbox;

public class Point {
  public double x;
  public double y;

  public Point (double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point p4) {
    double z = (p4.x - this.x) * (p4.x - this.x) + (p4.y - this.y) * (p4.y - this.y);
    return Math.sqrt(z);
  }
}
