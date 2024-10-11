package org.example.homework1.student;
/*
Задача "Студент":

Создайте класc Student с полями для хранения имени, номера зачётной книжки и среднего балла.
Реализуйте методы для получения и установки этих полей.

Создайте интерфейс Printable с методом print(), аналогично задаче "Банковский счёт", для вывода информации о студенте.
 */
public class Student implements Printable{
    private String name;
    private String gradeBook;
    private double averageScore;

    public void setStudent(String name, String gradeBook, double averageScore){
        this.name = name;
        this.gradeBook = gradeBook;
        this.averageScore =averageScore;
    }

    public String getName(){
        return name;
    }

    public String getGradeBook(){
        return gradeBook;
    }

    public double getAverageScore(){
        return averageScore;
    }

    @Override
    public void print() {
        System.out.println("Имя студента: " + name);
        System.out.println("Номер зачетки: " + gradeBook);
        System.out.println("Средний балл: " + averageScore);
    }
}
