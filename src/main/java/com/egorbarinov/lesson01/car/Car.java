package com.egorbarinov.lesson01.car;

abstract public class Car { // 1. В данной реализации класс можно сделать и обычным, неабстрактным.
    //2. public Car.Engine engine; поле должно быть приватным, чтоыб не нарушать инкапсуляцию
    private Engine engine;  //Создан класс Car.Engine
    private String color;
    private String name;

    //3. Отстутсвующий конструктор. добавляю
    public Car(Engine engine, String color, String name) {
        this.engine = engine;
        this.color = color;
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine ;
    }

    //protected void start() заменен на public
    public void start() {
        System.out.println("Car starting");
    }

    // abstract void open (); // можно вынести в интерфейс, так как используется не всеми классами наследниками Car

    public String getColor() {
        return color ;
    }

    public void setColor(String color) {
        this.color = color ;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car.Car{" +
                "engine=" + engine +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}