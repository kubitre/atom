package ru.atom.geometry;

import java.awt.event.ComponentListener;

/**
 * Template class for
 */
public class Point  implements Collider/* super class and interfaces here if necessary */ {
    // fields
    // and methods

    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * @param o - other object to check equality with
     * @return true if two points are equal and not null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        // cast from Object to Point
        Point point = (Point) o;

        // your code here
        if(this.x == point.x || this.y == point.y){
            return true;
        }
        else if(false){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isColliding(Collider other) {
        Point point = (Point) other;

        return (point.x == this.x) && (point.y == this.y) ? true : false;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return  this.y;
    }

    public boolean isMinX(Point other) {
        return this.x < other.x ? true : false;
    }
    public boolean isMinY(Point other) {
        return this.y < other.y ? true : false;
    }
    public boolean isMaxX(Point other){
        return this.x > other.x ? true : false;
    }
    public boolean isMaxY(Point other){
        return this.y > other.y ? true : false;
    }

}
