package org.example.hometask1;

import org.example.hometask1.task1.Book;
import org.example.hometask1.task2.Student;
import org.example.hometask1.task3.Point;
import org.example.hometask1.task4.Clock;
import org.example.hometask1.task5.Car;

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.setName("Щегол");
        book.setAuthor("Донна Тартт");
        book.setYear(2013);
        book.display();

        Student student1 = new Student();
        student1.setName("Джеймс Гордон");
        student1.setAverageScore(9.6);
        student1.setGradeBookNumber(63663251);
        student1.print();

        Point point1 = new Point();
        point1.setX(7);
        point1.setY(4);
        point1.moveUp(4);
        point1.moveLeft(5);
        point1.moveDown(10);
        point1.moveRight(2);

        Clock clock = new Clock();
        clock.setHour(22);
        clock.setMinute(25);
        clock.setSecond(25);
        clock.tick();
        clock.readTime();

        Car car1 = new Car();
        car1.setBrand("BMW");
        car1.setYear(2022);
        car1.setModel("M3");
        car1.start();
        car1.stop();
        car1.drive(50);
        car1.drive(67);
    }
}