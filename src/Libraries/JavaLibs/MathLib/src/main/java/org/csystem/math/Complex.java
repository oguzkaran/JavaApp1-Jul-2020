/*----------------------------------------------------------------------------------------------------------------------
	Complex sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math;

import static java.lang.Math.sqrt;

public class Complex {
    private static Complex add(double re1, double im1, double re2, double im2)
    {
        return new Complex(re1 + re2, im1 + im2);
    }

    private static Complex sub(double re1, double im1, double re2, double im2)
    {
        return add(re1, im1, -re2, -im2);
    }

    public double re, im;

    public Complex()
    {}

    public Complex(double re)
    {
        this.re = re;
    }

    public Complex(double re, double im)
    {
        this.re = re;
        this.im = im;
    }

    public Complex getConjugate()
    {
        Complex z = new Complex();

        z.re = re;
        z.im = -im;

        return z;
    }

    public double getNorm()
    {
        return sqrt(re * re + im * im);
    }

    public static Complex add(double re, double im, Complex z)
    {
        return add(re, im, z.re, z.im);
    }

    public Complex add(Complex z)
    {
        return add(re, im, z.re, z.im);
    }

    public Complex add(double x, double y)
    {
        return add(re, im, x, y);
    }

    public static Complex sub(double re, double im, Complex z)
    {
        return sub(re, im, z.re, z.im);
    }

    public Complex sub(Complex z)
    {
        return sub(re, im, z.re, z.im);
    }

    public Complex sub(double x, double y)
    {
        return sub(re, im, x, y);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Complex))
            return false;

        Complex other = (Complex)obj;

        return re == other.re && im == other.im;
    }

    @Override
    public String toString()
    {
        return String.format("|%.2f + i * %.2f| = %f", re, im, this.getNorm());
    }
}

