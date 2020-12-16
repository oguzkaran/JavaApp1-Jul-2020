package org.csystem.samples.randomobjectsgeneratorapp;

import org.csystem.util.StringUtil;

import java.util.Random;

public class RandomObjectsGenerator {
    private final Random m_random;
    private final Object [] m_objects;

    public Object getRandomObject()
    {
        Object result = m_random.nextInt(255) - 128;

        switch (m_random.nextInt(3)) {
            case 0:
                result = StringUtil.getRandomTextEN(m_random, m_random.nextInt(10));
                break;
            case 1:
                result = m_random.nextInt(101); //auto-boxing
                break;
            case 2:
                result = m_random.nextDouble(); //auto-boxing
                break;
        }

        return result;
    }

    public RandomObjectsGenerator(int count)
    {
        this(new Random(), count);
    }

    public RandomObjectsGenerator(Random random, int count)
    {
        m_random = random;
        m_objects = new Object[count];
    }

    public Object[] getObjects()
    {
        return m_objects;
    }

    public void generate()
    {
        for (int i = 0; i < m_objects.length; ++i)
            m_objects[i] = getRandomObject();
    }
}
