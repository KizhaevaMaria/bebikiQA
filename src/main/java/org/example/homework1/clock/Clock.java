package org.example.homework1.clock;
/*
Задача "Часы":

Создайте класс Clock с полями для хранения часов, минут и секунд.

Реализуйте методы для установки и получения времени, а также метод tick() для увеличения времени на одну секунду.

Создайте интерфейс Readable с методом readTime(), который выводит текущее время часов.
 */
public class Clock implements Readable{
    private int hours;
    private int minutes;
    private int seconds;

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }

    public int tick(){
        this.seconds += 1;
        return this.seconds;
    }

    @Override
    public void readTime() {

        System.out.println("Настоящее время: "+this.hours+":"+this.minutes+":"+this.seconds);
    }
}
