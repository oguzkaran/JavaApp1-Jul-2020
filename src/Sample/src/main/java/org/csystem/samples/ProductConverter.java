package org.csystem.samples;

public class ProductConverter {
    private final Product m_product;

    public ProductConverter(Product product)
    {
        m_product = product;
    }

    public Object toNameStockObject()
    {
        return new Object() {
            private final String m_name = m_product.getName();
            private final double m_stock = m_product.getStock();

            public String getName()
            {
                return m_name;
            }

            public double getStock()
            {
                return m_stock;
            }

            public String toString()
            {
                return String.format("{name: %s, stock: %s}", m_name, m_stock);
            }
        };
    }

    public Object toIdNameObject()
    {
        return new Object() {
            private final int m_id = m_product.getId();
            private final String m_name = m_product.getName();

            public int getId()
            {
                return m_id;
            }

            public String getName()
            {
                return m_name;
            }

            public String toString()
            {
                return String.format("{id: %d, name: %s}", m_id, m_name);
            }
        };
    }
}
