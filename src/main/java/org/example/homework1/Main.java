package org.example.homework1;

import org.example.homework1.book.Book;
import org.example.homework1.car.Car;
import org.example.homework1.clock.Clock;
import org.example.homework1.point.Point;
import org.example.homework1.student.Student;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача про книгу=>");
        Book b1 = new Book();
        b1.setBook("Дом, в котором...", "Мариам Сергеевна Петросян", 2009);
        b1.display();


        System.out.println("Задача про студентов=>");
        Student st1 = new Student();
        st1.setStudent("Маша","171-333", 5.0);
        st1.print();

        System.out.println("Задача про точку=>");
        Point p1 = new Point();
        p1.setX(5);
        p1.setY(9);
        p1.moveDown(1);
        p1.moveUp(0);
        p1.moveLeft(1);
        p1.moveRight(0);

        int px = p1.getX();
        int py = p1.getY();

        System.out.println("Положение точки по x: "+px);
        System.out.println("Положение точки по y: "+py);

        System.out.println("Задача про часы=>");
        Clock c1 = new Clock();
        c1.setHours(7);
        c1.setMinutes(45);
        c1.setSeconds(23);
        c1.tick();
        c1.readTime();

        System.out.println("Задача про авто=>");
        Car car = new Car();
        car.setCar("какая-то супер марка","007Б",2024);
        car.aboutCar();
        car.start();
        car.stop();
        car.drive(5000);
    }
}