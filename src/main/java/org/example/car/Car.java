package org.example.car;

/*
Задача "Автомобиль":

Создайте класс Саг с полями для марки, модели и года выпуска.
Реализуйте методы для получения и установки этих полей.

Создайте интерфейс Drivable с методами start(), stop(), и drive(distance), которые реализует класс Саг для имитации вождения автомобиля.
*/
public class Car implements Drivable{
    private String mark;
    private String model;
    private int year;

    public void setCar(String mark, String model, int year){
        this.mark = mark;
        this.model = model;
        this.year = year;
    }

    public String getMark(){
        return mark;
    }

    public String getModel(){
        return model;
    }

    public int getYear() {
        return year;
    }

    public void aboutCar(){
        System.out.println("Машина:");
        System.out.println("Марка: " + mark);
        System.out.println("Модель: " + model);
        System.out.println("Год выпуска:" + year);
    }

    @Override
    public void start() {
        System.out.println("Автомобиль начал движение");
    }

    @Override
    public void stop() {
        System.out.println("Автомобиль закончил движение");
    }

    @Override
    public int drive(int distance) {
        System.out.println("Дистанция: " + distance + "км");
        return distance;
    }
}
