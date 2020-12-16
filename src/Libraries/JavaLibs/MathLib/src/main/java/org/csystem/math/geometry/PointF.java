/*----------------------------------------------------------------------------------------------------------------------
	PointF sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

import static java.lang.Math.sqrt;

public class PointF {
	public float x, y;

	PointF(PointF p)
	{
		this(p.x, p.y);
	}
	
	public PointF()
	{}
	
	public PointF(float re)
	{
		this(re, 0);
	}
	
	public PointF(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double distance(PointF p)
	{
		return this.distance(p.x, p.y);
	}
	
	public double distance(float a, float b)
	{
		return sqrt((x - a) * (x - a) + (y - b) * (y - b));
	}	
	
	public void offset(float dxy)
	{
		this.offset(dxy, dxy);
	}
	
	public void offset(float dx, float dy)
	{
		x += dx;
		y += dy;
	}

	@Override
	public String toString()
	{
		return String.format("(%.2f, %.2f)", x, y);
	}
}
