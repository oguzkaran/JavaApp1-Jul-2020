/*----------------------------------------------------------------------------------------------------------------------
    Rational sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math;

public class Rational implements Comparable<Rational> {
    private int m_a, m_b;

    private static Rational add(int a1, int b1, int a2, int b2)
    {
        return new Rational(a1 * b2 + a2 * b1, b1 * b2);
    }

    private static Rational sub(int a1, int b1, int a2, int b2)
    {
        return add(a1, b1, -a2, b2);
    }

    private static Rational mul(int a1, int b1, int a2, int b2)
    {
        return new Rational(a1 * a2, b1 * b2);
    }

    private static Rational div(int a1, int b1, int a2, int b2)
    {
        return mul(a1, b1, b2, a2);
    }

    private static void control(int a, int b)
    {
        if (b == 0) {
            if (a == 0)
                throw new RationalException("Belirsiz", RationalExceptionStatus.INDEFINITE);

            throw new RationalException("Tanımsız", RationalExceptionStatus.UNDEFINED);
        }
    }

    private void simplify()
    {
        int a = Math.abs(m_a);
        int b = m_b;
        int min = Math.min(a, b);

        for (int i = min; i >= 2; --i) {
            if (a % i == 0 && b % i == 0) {
                m_a /= i;
                m_b /= i;
                break;
            }
        }
    }

    private void setSigns()
    {
        if (m_b < 0) {
            m_a = -m_a;
            m_b = -m_b;
        }
    }

    private void set(int a, int b)
    {
        m_a = a;
        if (m_a == 0) {
            m_b = 1;
            return;
        }
        m_b = b;
        this.setSigns();
        this.simplify();
    }

    public Rational()
    {
        m_b = 1;
    }

    public Rational(int a)
    {
        m_a = a;
        m_b = 1;
    }

    public Rational(int a, int b)
    {
        control(a, b);
        this.set(a, b);
    }

    public int getNumerator()
    {
        return m_a;
    }

    public void setNumerator(int val)
    {
        if (m_a == val)
            return;

        this.set(val, m_b);
    }

    public int getDenominator()
    {
        return m_b;
    }

    public void setDenominator(int val)
    {
        if (m_b == val)
            return;

        control(m_a, val);
        this.set(m_a, val);
    }

    public void setRational(int a, int b)
    {
        if (a == m_a || b == m_b)
            return;

        control(a, b);
        this.set(a, b);
    }

    public double getRealValue()
    {
        return (double)m_a / m_b;
    }

    //add methods
    public static  Rational add(int val, Rational r)
    {
        return add(val, 1, r.m_a, r.m_b);
    }

    public Rational add(int val)
    {
        return add(m_a, m_b, val, 1);
    }

    public Rational add(Rational r)
    {
        return add(m_a, m_b, r.m_a, r.m_b);
    }

    //sub methods
    public static Rational sub(int val, Rational r)
    {
        return sub(val, 1, r.m_a, r.m_b);
    }

    public Rational sub(int val)
    {
        return sub(m_a, m_b, val, 1);
    }

    public Rational sub(Rational r)
    {
        return sub(m_a, m_b, r.m_a, r.m_b);
    }

    //multiply methods
    public static Rational mul(int val, Rational r)
    {
        return mul(val, 1, r.m_a, r.m_b);
    }

    public Rational mul(int val)
    {
        return mul(m_a, m_b, val, 1);
    }

    public Rational mul(Rational r)
    {
        return mul(m_a, m_b, r.m_a, r.m_b);
    }

    //div methods
    public static Rational div(int val, Rational r)
    {
        return div(val, 1, r.m_a, r.m_b);
    }

    public Rational div(int val)
    {
        return div(m_a, m_b, val, 1);
    }

    public Rational div(Rational r)
    {
        return div(m_a, m_b, r.m_a, r.m_b);
    }

    //inc methods
    public void inc()
    {
        this.inc(1);
    }

    public void inc(int val)
    {
        m_a += val * m_b;
    }

    //dec methods
    public void dec()
    {
        this.dec(1);
    }

    public void dec(int val)
    {
        this.inc(-val);
    }

    //pow method
    public Rational pow(int n)
    {
        return new Rational((int)Math.pow(m_a, n), (int)Math.pow(m_b, n));
    }

    @Override
    public int compareTo(Rational other)
    {
        return m_a * other.m_b - other.m_a * m_b;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Rational))
            return false;

        Rational other = (Rational)obj;

        return m_a == other.m_a && m_b == other.m_b;
    }

    @Override
    public String toString()
    {
        return String.format("%d / %d = %.2f", m_a, m_b, this.getRealValue());
    }
}
