package ru.stqa.pft.sandbox;

public class HomeTask2 {
	public static void main(String args[]) 	{
    Point p1 = new Point (5,5);
    Point p2 = new Point (10, 10);
    PointM p3 = new PointM (5,5, 10, 10);
		System.out.println("Расстояние между точкой P1 ("+p1.x+","+p1.y+") и точкой P2 ("+p2.x+","+p2.y+"), рассчитанное с " +
						"помощоью функции = "+ distance(p1, p2));
		System.out.println("Расстояние между точкой P1 ("+p3.x1+","+p3.y1+") и точкой P2 ("+p3.x2+","+p3.y2+"), рассчитанное " +
						"с помощью метода в класса Point = "+ p3.distance());
	}

	public static double distance(Point p1, Point p2) {
		double z = (p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y);
		return Math.sqrt(z);
	}


}


