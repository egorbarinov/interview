package com.egorbarinov.lesson01.shape;

public class Square implements GeometricShape{

    private Point coordinateA;
    private Point coordinateB;
    private Point coordinateC;
    private Point coordinateD;

    public Square(Point coordinateA, Point coordinateB, Point coordinateC, Point coordinateD) {
        this.coordinateA = coordinateA;
        this.coordinateB = coordinateB;
        this.coordinateC = coordinateC;
        this.coordinateD = coordinateD;
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

    public Point getCoordinateD() {
        return coordinateD;
    }

    public void setCoordinateD(Point coordinateD) {
        this.coordinateD = coordinateD;
    }

    @Override
    public void draw() {
        System.out.println("The square is draw");
    }
}
