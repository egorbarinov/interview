package com.egorbarinov.lesson02.collections.arraylist;

public interface Array<E> {

    void add(E value);
    void insert(E value, int index);
    E get(int index);
    boolean remove(E value);
    E remove(int value);
    int indexOf(E value);

    default boolean contains(E value) {
        return indexOf(value) != -1;
    }

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }



    void trimToSize();

    void display();

    void sortBubble();
}
