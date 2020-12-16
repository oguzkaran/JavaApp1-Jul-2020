package org.csystem.samples;

public class NameConverter {
    private final String m_name;

    public NameConverter(String name)
    {
        m_name = name;
    }

    public Object toIdNameObject(int id)
    {
        return new Object() {
            private final int m_id = id;
            private final String m_name = NameConverter.this.m_name;

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
