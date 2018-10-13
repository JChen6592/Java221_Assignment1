package com.company;
import java.awt.*;
import javax.swing.*;

public abstract class Shape{
    private double X;
    private double Y;
    private String color;
    private double dy;
    private double dx;

    abstract public void draw();
    //constructor
    public Shape(double X, double Y, String color) {
        this.X = X;
        this.Y = Y;
        this.color = color;
    }

    //Getters and Setters
    public double getX(){
        return this.X;
    }
    public double getY(){
        return this.Y;
    }
    public String getColor(){
        return this.color;
    }
    public void setX(double X){
        this.X = X;
    }
    public void setY(double Y){
        this.Y = Y;
    }
    public void setColor(String color){
        this.color = color;
    }
    public double getDx(){
        return dx;
    }
    public void setDx(double dx){
        this.dx = dx;
    }
    public double getDy(){
        return dy;
    }
    public void setDy(double dy){
        this.dy = dy;
    }
    public void shiftXY(double dx, double dy){
        X += dx;
        Y += dy;
    }

    public String toString() {
        return "Shape[x =" + getX() + ",y=" + getY() + ",color=" + getColor() + "]";
    }
}




