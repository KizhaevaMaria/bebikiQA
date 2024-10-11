package org.example.homework1.book;

/** Задание «Книга»:

 * Создайте класс Book с полями для хранения названия, автора и года издания.
 * Реализуйте методы для получения и установки этих полей.
 *
 * Создайте интерфейс Displayable с методом display(),
 * который реализуется в классе Book для отображения информации о книге.
 */

public class Book  implements Displayable{
    private String name;
    private String author;
    private int year;

    public void setBook(String name, String author, int year){
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName(){
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public int getYear(){
        return year;
    }

    @Override
    public void display() {
        System.out.println("Название книги: " + this.name);
        System.out.println("Автор: " + this.author);
        System.out.println("Год выпуска: " + this.year);
    }
}