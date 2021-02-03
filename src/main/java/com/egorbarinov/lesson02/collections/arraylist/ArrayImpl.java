package com.egorbarinov.lesson02.collections.arraylist;


import java.util.Arrays;

public class ArrayImpl<E extends Comparable<? super E>> implements Array<E> {

    private static final int DEFAULT_CAPACITY = 8;
    private E[] data;
    private int size;

    public ArrayImpl() {
        this(DEFAULT_CAPACITY);
    }


//    @SuppressWarnings("unchecked")
//    public ArrayImpl(int capacity) {
//        this.data = (E[]) new Object[capacity];
//    }
//

    @SuppressWarnings("unchecked")
    public ArrayImpl(int capacity) {
        this.data = (E[]) new Comparable[capacity];
    }


    @Override
    public void add(E value) {
        checkAndGrow();
        data[size++] = value;
    }

    protected void checkAndGrow() {
        if (data.length == size) {
            data = Arrays.copyOf(data, calculateNewLength());
        }
    }

    private int calculateNewLength() {
        return size > 0 ? size * 2 : 1;
    }


    @Override
    public void insert(E value, int index) {
        if (index == size) {
            add(value);
        }
        else {
            checkIndex(index);
//            for (int i = size - 1 ; i >= index; i--) {
//                data[i + 1] = data[i];
//            }
            if (size - index >= 0) {
                System.arraycopy(data, index, data, index + 1, size - index);
            }

            data[index] = value;
            size++;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new MyCustomArrayIndexOutOfBoundsException(index, size);
        }
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        return index != -1 && (remove(index) != null);
    }

    @Override
    public E remove(int index) {

        E removedElement = data[index];
//        for (int i = index; i < size - 1; i++) {
//            data[i] = data[i+1];
//        }

        if (size - 1 - index >= 0) System.arraycopy(data, index + 1, data, index, size - 1 - index);
        data[size - 1] = null;
        size--;

        return removedElement;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]);
            sb.append(", ");
        }
        if (size > 0) {
            sb.append(data[size - 1]);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void display() {
        System.out.println(toString());

    }

    @Override
    public void trimToSize() {
        data = Arrays.copyOf(data, size);
    }

    @Override
    public void sortBubble() {

        for (int i = 0; i < size-1; i++) {

            for (int j = 0; j < size-1- i; j++) {
                if ( data[j].compareTo(data[j + 1]) >0){
                    E temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

    }

}
