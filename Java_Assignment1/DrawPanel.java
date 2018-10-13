package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.Container;
import java.awt.event.*;

public class DrawPanel extends JPanel {
    final double pi = Math.PI;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int X = getWidth();
        int Y = getHeight();

        //draw line from upper-left to lower-right
        g.drawLine(0, 0, X, Y);
        //draw line from lower-left to upper-right
        g.drawLine(0, Y, X, 0);
        //draw line from lower left to upper left
        g.drawLine(0, Y, 0, 0);
        //drawline from lower-right to upper-right
        g.drawLine(X, 0, X, Y);
        //drawline from upper-left to upper-right
        g.drawLine(0, 0, X, 0);
        //drawline from lower-left to lower-right
        g.drawLine(0, Y, X, Y);


        Circle c1 = new Circle(getX(), getY(), "red", X / 2);
        c1.draw();
        System.out.println(c1.toString());

        Polygon p1 = new Polygon((int) (getX() + (getX() / 2) * Math.cos(4 * 2 * pi / 5)),
                (int) (getY() + (getY() / 2) * Math.sin(4 * 2 * pi / 5)), "red", 5);
        p1.draw();

    }
}

