package com.egorbarinov.lesson01.car;

public class LightWeightCar extends Car implements Moveable, Openable {

    // объявил конструктор класса, в котором вызываю конструктор абстрактного класса
    public LightWeightCar(Engine engine, String color, String name) {
        super(engine, color, name);
    }


    public void open(){
        System.out.println ("Car is open");
    }

    public void move () {
        System.out.println ("Car is moving");
    }

}