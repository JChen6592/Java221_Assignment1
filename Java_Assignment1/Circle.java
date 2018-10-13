package com.company;
import java.awt.*;
import javax.swing.*;

public class Circle extends Shape {
    private double radius;
    final double pi = Math.PI;

    public Circle(double x1, double y1, String color, double r) {
        super(x1,y1,color);
        radius = r;
    }

    public double getArea() {
        return pi * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double newRadius){
        radius = newRadius;
    }
    public double getPerimeter(){
        return 2 * pi * radius;
    }

    public int getRadius1() { return (int) getRadius(); }
    public int getX1() { return (int) getX(); }
    public int getY1() { return (int) getY(); }

    @Override
    public void draw() {
        Circle c = new Circle(this.getX(), this.getY(), this.getColor(), this.getRadius());
        CircleGraphics m = new CircleGraphics();
        m.setCircle(c);

        JFrame application=new JFrame();
        application.add(m);
        application.setSize(500,500);
        application.setVisible(true);
    }

    public class CircleGraphics extends JPanel {
        private Circle circle;

        public void setCircle(Circle c) {
            circle = c;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.WHITE);

            g.setColor(Color.BLUE);
            g.fillOval(getRadius1() + (circle.getX1() - getRadius1()), getRadius1() + (circle.getY1() - getRadius1()), circle.getRadius1() * 2, circle.getRadius1() * 2);
            g.setColor(Color.GREEN);
            g.fillOval(getRadius1() + ((circle.getX1() - getRadius1())/2), getRadius1() + ((circle.getY1() - getRadius1())/2), (circle.getRadius1() * 2)/2, (circle.getRadius1() * 2)/2);
            g.setColor(Color.ORANGE);
            g.fillOval(getRadius1() + ((circle.getX1() - getRadius1())/4), + getRadius1() + ((circle.getY1() - getRadius1())/4), (circle.getRadius1() * 2)/4, (circle.getRadius1() * 2)/4);
            g.setColor(Color.WHITE);
            g.fillOval(getRadius1() + ((circle.getX1() - getRadius1())/8), + getRadius1() + ((circle.getY1() - getRadius1())/8), (circle.getRadius1() * 2)/8, (circle.getRadius1() * 2)/8);
        }
    }

    @Override
    public String toString() {
        return "Circle[area =" + getArea() +  ",perimeter=" + getPerimeter() + "]";
    }
}
