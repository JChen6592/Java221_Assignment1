package com.company;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class DrawPanelLine {
    public static void main(String[] args){
        DrawPanel panel = new DrawPanel();

        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        application.add(panel);
        application.setSize(500,500);
        application.setVisible(true);
    }
}

