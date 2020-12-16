/*----------------------------------------------------------------------------------------------------------------------
    Circle sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math.geometry;

public class Circle {
    private double m_r;

    public Circle()
    {
    }

    public Circle(double r)
    {
        this.setRadius(r);
    }

    public double getRadius()
    {
        return m_r;
    }

    public void setRadius(double r)
    {
        m_r = Math.abs(r);
    }

    public double getArea()
    {
        return Math.PI * m_r * m_r;
    }

    public double getCircumference()
    {
        return 2 * Math.PI * m_r;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Circle))
            return false;

        return Double.valueOf(m_r).equals(((Circle)obj).m_r);
    }
}
