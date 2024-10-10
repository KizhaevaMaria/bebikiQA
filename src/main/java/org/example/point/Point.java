package org.example.point;
/*
Задача «Точка плоскостей»:

Создайте класс Point с приватными полями х и у для координат точки на плоскости.

Реализуйте методы для получения (get) и установки (set) этих полей.

Создайте интерфейс Movable с методами moveUp(), moveDown(), moveLeft(), и moveRight() для изменения положения точки.
 */
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
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void moveUp(int a) {
        //y+
        setY(this.y += a);

    }

    @Override
    public void moveDown(int a) {
        //y-
        setY(this.y -= a);
    }

    @Override
    public void moveLeft(int a) {
        //x-
        setX(this.x -= a);
    }

    @Override
    public void moveRight(int a) {
        //x+
        setX(this.x += a);
    }
}
