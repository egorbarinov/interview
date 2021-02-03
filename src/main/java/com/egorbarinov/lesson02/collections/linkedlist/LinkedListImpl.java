package com.egorbarinov.lesson02.collections.linkedlist;

public class LinkedListImpl<E> implements LinkedList<E> {

    static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    private int size;

    private Node<E> firstElement;

    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement);
        size++;

    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedFirst = firstElement;
        E data = removedFirst.item;
        firstElement = firstElement.next;

        removedFirst.item = null;
        removedFirst.next = null;
        size--;
        return data;
    }

    @Override
    public boolean remove(E value) {

        Node<E> current = firstElement;
        Node<E> previous = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
        }
         else {
             previous.next = current.next;
        }
        current.item = null;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public boolean contains(E value) {
        if (isEmpty()) {
            return false;
        }
        Node<E> element = firstElement;
        while (element != null) {
            if (element.item.equals(value)) {
                return true;
            }
            element = element.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E getFirst() {
        return firstElement.item;
    }

    @Override
    public E getLast() {
        Node<E> currentLast = firstElement;
        while (currentLast.next != null) {
            currentLast = currentLast.next;
            if (currentLast.next == null) {
                return currentLast.item;
            }
        }
        return currentLast.item;
    }

    @Override
    public void display() {
        Node<E> element = firstElement;
        while (element != null) {
            System.out.println(element.item);
            element = element.next;
        }

    }
}
