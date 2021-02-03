package com.egorbarinov.lesson01.shape;

public class Triangle implements GeometricShape {

    private Point coordinateA;
    private Point coordinateB;
    private Point coordinateC;

    public Triangle(Point coordinateA, Point coordinateB, Point coordinateC) {
        this.coordinateA = coordinateA;
        this.coordinateB = coordinateB;
        this.coordinateC = coordinateC;
    }

    public Point getCoordinateA() {
        return coordinateA;
    }

    public void setCoordinateA(Point coordinateA) {
        this.coordinateA = coordinateA;
    }

    public Point getCoordinateB() {
        return coordinateB;
    }

    public void setCoordinateB(Point coordinateB) {
        this.coordinateB = coordinateB;
    }

    public Point getCoordinateC() {
        return coordinateC;
    }

    public void setCoordinateC(Point coordinateC) {
        this.coordinateC = coordinateC;
    }

    @Override
    public void draw() {
        System.out.println("The triangle is draw");
    }
}
