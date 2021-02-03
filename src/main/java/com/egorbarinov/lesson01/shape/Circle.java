package com.egorbarinov.lesson01.shape;

public class Circle implements GeometricShape {

    private Point coordinate;
    private int radius;

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Circle(Point coordinate, int radius) {
        this.coordinate = coordinate;
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("The circle is draw");

    }
}
