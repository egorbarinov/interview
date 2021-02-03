package com.egorbarinov.lesson02.collections.linkedlist;

public interface LinkedList<E> {

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    E getFirst();

    E getLast();

    void display();

}
