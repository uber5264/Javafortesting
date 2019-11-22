package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTask3 {

  @Test
  public void testPointDistanceP() {
    Point p1 = new Point (5,5);
    Point p2 = new Point (10, 10);
    Assert.assertEquals(p1.distance(p2), 7.0710678118654755);
  }

  @Test
  public void testPointDistanceN() {
    Point p1 = new Point (5,5);
    Point p2 = new Point (10, 10);
    Assert.assertEquals(p1.distance(p2), 7.0);
  }

 }


