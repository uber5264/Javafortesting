package ru.stqa.pft.sandbox;

public class PointM {
  public double x1;
  public double y1;

  public PointM (double x1, double y1) {
    this.x1 = x1;
    this.y1 = y1;
  }

  public double distance(PointM p4) {
    double z = (p4.x1 - this.x1) * (p4.x1 - this.x1) + (p4.y1 - this.y1) * (p4.y1 - this.y1);
    return Math.sqrt(z);
  }
}


