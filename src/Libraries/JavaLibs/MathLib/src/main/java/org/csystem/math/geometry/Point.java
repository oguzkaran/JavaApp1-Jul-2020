/*----------------------------------------------------------------------------------------------------------------------
	Point sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

import static java.lang.Math.sqrt;

public class Point {
	public int x, y;

	Point(Point p)
	{
		this(p.x, p.y);
	}

	public Point()
	{}
	
	public Point(int x)
	{
		this(x, 0);
	}
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double distance(Point p)
	{
		return this.distance(p.x, p.y);
	}
	
	public double distance(int a, int b)
	{
		return sqrt((x - a) * (x - a) + (y - b) * (y - b));
	}	
	
	public void offset(int dxy)
	{
		this.offset(dxy, dxy);
	}
	
	public void offset(int dx, int dy)
	{
		x += dx;
		y += dy;
	}

	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof Point && x == ((Point)obj).x && y == ((Point)obj).y;
	}

	@Override
	public String toString()
	{
		return String.format("(%d, %d)", x, y);
	}
}
