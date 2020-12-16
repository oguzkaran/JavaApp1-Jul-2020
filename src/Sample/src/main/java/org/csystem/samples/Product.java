package org.csystem.samples;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class Product {
    private int m_id;
    private String m_name;
    private double m_stock;
    private BigDecimal m_cost;
    private BigDecimal m_price;

    public Product()
    {
    }

    public Product(int id)
    {
        this(id, "", 0, ZERO, ZERO);
    }
    public Product(int id, String name)
    {
        this(id, name, 0, ZERO, ZERO);
    }

    public Product(String name, double stock, BigDecimal cost, BigDecimal price)
    {
        this(0, name, stock, cost, price);
    }

    public Product(int id, String name, double stock, BigDecimal cost, BigDecimal price)
    {
        m_id = id;
        m_name = name;
        m_stock = stock;
        m_cost = cost;
        m_price = price;
    }

    public int getId()
    {
        return m_id;
    }

    public void setId(int id)
    {
        m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public double getStock()
    {
        return m_stock;
    }

    public void setStock(double stock)
    {
        m_stock = stock;
    }

    public BigDecimal getCost()
    {
        return m_cost;
    }

    public void setCost(BigDecimal cost)
    {
        m_cost = cost;
    }

    public BigDecimal getPrice()
    {
        return m_price;
    }

    public void setPrice(BigDecimal price)
    {
        m_price = price;
    }

    @Override
    public int hashCode()
    {
        return m_id;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Product))
            return false;

        var other = (Product) obj;

        return m_id == other.m_id;
    }

    @Override
    public String toString()
    {
        return String.format("{id : %d, name : '%s', stock : %.2f, cost : %s, price : %s}", m_id, m_name, m_stock, m_cost, m_price);
    }
}