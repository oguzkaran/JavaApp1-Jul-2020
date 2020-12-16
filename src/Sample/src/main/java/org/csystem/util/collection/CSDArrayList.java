/*----------------------------------------------------------------------------------------------------------------------
    CSDArrayList sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CSDArrayList<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E [] m_elements;
    private int m_index;
    
    private static void doWorkForCapacityException(String msg)
    {
        throw new IllegalArgumentException(msg);
    }

    private static void doWorkForIndexExceptionn(String msg)
    {
        throw new IndexOutOfBoundsException(msg);
    }

    private static void checkCapacity(int capacity)
    {
        if (capacity < 0)
            doWorkForCapacityException("Invalid capacity");
    }

    private static void checkIndex(int index, int bound, String msg)
    {
        if (index < 0 || index >= bound)
            doWorkForIndexExceptionn(msg);
    }

    @SuppressWarnings("unchecked")
    private void allocateCapacity(int capacity)
    {
        E [] temp = (E []) new Object[capacity];

        for (int i = 0; i < m_index; ++i)
            temp[i] = m_elements[i];

        m_elements = temp;
    }

    @SuppressWarnings("unchecked")
    public CSDArrayList()
    {
        m_elements = (E[])new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public CSDArrayList(int initialCapacity)
    {
        checkCapacity(initialCapacity);
        m_elements = (E[])new Object[initialCapacity];
    }

    public boolean add(E elem)
    {
        if (m_index == m_elements.length)
            this.allocateCapacity(m_elements.length == 0 ? 1 : m_elements.length * 2);

        m_elements[m_index++] = elem;

        return true;
    }

    public void add(int index, E elem)
    {
        if (m_index == m_elements.length)
            this.allocateCapacity(m_elements.length == 0 ? 1 : m_elements.length * 2);

        //TODO:
    }

    public int capacity()
    {
        return m_elements.length;
    }

    public void clear()
    {
        for (int i = 0; i < m_index; ++i)
            m_elements[i] = null;

        m_index = 0;
    }

    public boolean contains(Object o)
    {
        return this.indexOf(o) != -1;
    }

    public E get(int index)
    {
        checkIndex(index, m_index, String.format("Invalid index:%d", index));

        return m_elements[index];
    }

    public boolean isEmpty()
    {
        return m_index == 0;
    }

    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

    public int indexOf(Object o)
    {
        if (o == null) {
            for (int i = 0; i < m_index; ++i) {
                if (m_elements[i] == null)
                    return i;
            }
        }
        else {
            for (int i = 0; i < m_index; ++i) {
                if (m_elements[i].equals(o))
                    return i;
            }
        }

        return -1;
    }

    public Object set(int index, E elem)
    {
        checkIndex(index, m_index, String.format("Invalid index:%d", index));

        Object oldElem = m_elements[index];

        m_elements[index] = elem;

        return oldElem;
    }

    public E remove(int index)
    {
        //...
        E oldElem = m_elements[index];

        //TODO:

        return oldElem;
    }

    public int size()
    {
        return m_index;
    }


    @SuppressWarnings("unchecked")
    public void trimToSize()
    {
        if (m_index == 0)
            m_elements = (E []) new Object[0];
        else
            allocateCapacity(m_index);
    }

    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<>() {
            private int m_index = -1;

            @Override
            public boolean hasNext()
            {
                return m_index + 1 < m_elements.length;
            }

            @Override
            public E next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such element");

                return m_elements[++m_index];
            }
        };
    }

    @Override
    public String toString()
    {
        var stringBuilder = new StringBuilder();

        stringBuilder.append('[');
        String delim = ", ";

        for (int i = 0; i < m_index; ++i)
            stringBuilder.append(m_elements[i]).append(delim);

        return stringBuilder.substring(0, stringBuilder.length() - delim.length()) + "]";
    }
}
