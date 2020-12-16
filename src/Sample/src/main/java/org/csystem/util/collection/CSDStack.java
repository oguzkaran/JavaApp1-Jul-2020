package org.csystem.util.collection;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class CSDStack<T> extends ArrayList<T> {
    public boolean empty()
    {
        return isEmpty();
    }

    public T push(T elem)
    {
        this.add(elem);

        return elem;
    }

    public T pop()
    {
        if (empty())
            throw new EmptyStackException();

        return this.remove(this.size() - 1);
    }

    public T peek()
    {
        if (empty())
            throw new EmptyStackException();

        return this.get(this.size() - 1);
    }

    public int search(Object obj)
    {
        int index = this.indexOf(obj);

        return index == -1 ? index : this.size() - index;
    }
}