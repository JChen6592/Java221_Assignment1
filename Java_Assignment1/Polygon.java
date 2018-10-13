package com.company;
import java.awt.*;
import java.awt.Polygon.*;
import javax.swing.*;
import java.util.ArrayList;


public class Polygon extends Shape {
    private int sides;
    private ArrayList<Point> points = new ArrayList<Point>();
    private Point[] a;
    final double pi = Math.PI;

    public Polygon(double X, double Y, String color, int N) {
        super(X,Y,color);
        sides = N;
        a = new Point[5]; //default to 5
    }

    public int getSide() {
        return sides;
    }

    public int getAngle(){
        int ang = (sides - 2)*180;
        return ang/sides;
    }

    private void resize(){
        Point[] temp = new Point[2*sides+1];
        for (int i = 0; i <= sides; i++){
            temp[i] = a[i];
            a = temp;
        }
    }

    public void add(int x, int y){
        points.add(new Point(x, y));
    }

    public double getPerimeter() {
            double sum = 0.0;
            for (int i = 0; i < sides; i++){
                sum = sum + a[i].distance(a[i+1]);
        }
        return sum;
    }

    public double getArea() {
        double area = 0.0;
        for (int i = 0; i < sides; i++) {
            area += (a[i].x + a[i+1].x) * (a[i].y + a[i+1].y);
        }
        return Math.abs(0.5 * area);
    }

    @Override
    public void draw(){
        Polygon p = new Polygon(this.getXi(), this.getYi(), this.getColor(), this.getSide());
        PolygonGraphics m = new PolygonGraphics();
        m.setPolygon(p);

        JFrame application=new JFrame();
        application.add(m);
        application.setSize(500,500);
        application.setVisible(true);
    }

    public double getXi() { return (getX() + (getX()/2) * Math.cos(2.0 * pi * sides/sides)) ; }
    public double getYi() { return (getY() + (getY()/2) * Math.sin(2.0 * pi * sides/sides)) ; }

    public class PolygonGraphics extends JPanel {
        private Polygon polygon;

        public void setPolygon(Polygon p) {
            polygon = p;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            //draw polygon within the circle perimeter
            g.setColor(Color.BLUE);
            Polygon p1 = new Polygon(polygon.getXi(), polygon.getYi(), polygon.getColor(), polygon.getSide());
            for (int i = 0; i < sides; i++) {
                p1.add( (int) (polygon.getX() + (polygon.getX() / 2) * Math.cos(i * 2 * pi / polygon.getSide())),
                         (int) (polygon.getY() + (polygon.getY() / 2) * Math.sin(i * 2 * pi / polygon.getSide())));
            }
            g.drawPolygon(p1);
        }
    }

    @Override
    public String toString() {
        return "Polygon[Sides =" + getSide() + ",angle=" + getAngle() + ",perimeter=" + getPerimeter() + ",area=" + getArea() + "]";
    }
}


