/*----------------------------------------------------------------------------------------------------------------------
    Analytical sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

public class AnalyticalCircle extends Circle {
    private Point m_center;

    public AnalyticalCircle()
    {
        this(0);
    }

    public AnalyticalCircle(double r)
    {
        this(r, 0, 0);
    }

    public AnalyticalCircle(Point center)
    {
        this(0, center);
    }

    public AnalyticalCircle(int x, int y)
    {
        this(0, x, y);
    }

    public AnalyticalCircle(double r, Point center)
    {
        this(r, center.x, center.y);
    }

    public AnalyticalCircle(double r, int x, int y)
    {
        super(r);
        m_center = new Point(x, y);
    }

    public int getX()
    {
        return m_center.x;
    }

    public void setX(int x)
    {
        m_center.x = x;
    }

    public int getY()
    {
        return m_center.y;
    }

    public void setY(int y)
    {
        m_center.y = y;
    }

    public void setCenter(Point center)
    {
        this.setCenter(center.x, center.y);
    }

    public void setCenter(int x, int y)
    {
        this.setX(x);
        this.setY(y);
    }

    public Point getCenter()
    {
        return new Point(m_center);
    }

    public void offset(int dx, int dy)
    {
        m_center.offset(dx, dy);
    }

    public void offset(int dxy)
    {
        this.offset(dxy, dxy);
    }
}
