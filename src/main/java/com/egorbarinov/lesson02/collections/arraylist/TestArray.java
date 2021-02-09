package com.egorbarinov.lesson02.collections.arraylist;

public class TestArray {

    public static void main(String[] args) {
        testMyArray();
    }

    public static void testMyArray() {
        Array<Integer> data = new ArrayImpl<Integer>(4);
        data.add(5);
        data.add(4);
        data.add(3);
        data.add(2);
        data.add(1);
        data.add(55);
        data.add(555);
        data.add(-33);

        data.display(); // [5, 4, 3, 2, 1]
        data.remove(2); // удален 2 элемент массива
        data.display();  // [5, 4, 2, 1]
        data.insert(3, 2);
        data.display(); // [5, 4, 3, 2, 1]

        System.out.println("data[1] = " + data.get(1)); // data[1] = 4
        System.out.println("Find 2: " + data.contains(2));
        System.out.println("Find 222: " + data.contains(222));
        data.sortBubble();
        data.display();

    }
}
