package org.csystem.util.collection;

public class CSDLinkedList<T> {
    private Node<T> m_head;
    private Node<T> m_tail;
    private int m_count;

    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;
    }
    //...
}
