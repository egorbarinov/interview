package com.egorbarinov.lesson02.collections.linkedlist;

public class TestMyLinkedList {

    public static void main(String[] args) {
        testMyLinkedList();
    }

    public static void testMyLinkedList() {
        LinkedList<Integer> list = new LinkedListImpl<>();
        System.out.println("LinkedList is empty? " + list.isEmpty()); // true
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(6);

        list.display();
        System.out.println("////////////////////");
        System.out.println("First element is: " + list.getFirst()); // 6
        System.out.println("Last element is: " + list.getLast()); // 1

        System.out.println("The size of the LinkedList is : " + list.size()); // 6
        System.out.println("LinkedList conatins 3: " + list.contains(3)); // true : automatic conversion of the type to Integer
        System.out.println("3 removed from the LinkedList: " + list.remove(3)); // true
        System.out.println("First deleted element is : " + list.removeFirst()); //1
        System.out.println("Now, first element is :" + list.getFirst()); // 2
        System.out.println("LinkedList is empty? " + list.isEmpty()); // false;
        System.out.println("The size of the LinkedList is : " + list.size()); // 4

    }
}
