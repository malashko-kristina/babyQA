package org.example.hometask1.task3;

public class Point implements Movable{
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public void moveUp(int a) {
        System.out.println("Current location is: " + "x: " + this.x + ", " + "y: " + (this.y + a));
    }

    @Override
    public void moveDown(int a) {
        System.out.println("Current location is: " + "x: " + this.x + ", " + "y: " + (this.y - a));
    }

    @Override
    public void moveLeft(int a) {
        System.out.println("Current location is: " + "x: " + (this.x - a) + ", " + "y: " + this.y);
    }

    @Override
    public void moveRight(int a) {
        System.out.println("Current location is: " + "x: " + (this.x + a) + ", " + "y: " + this.y);
    }
}
