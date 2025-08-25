package com.santos.draw.view;

import com.santos.draw.controller.DrawingWindowController;
import com.santos.drawfx.ShapeMode;
import com.santos.drawfx.service.AppService;

import javax.swing.*;

public class DrawingFrame extends JFrame {

    public DrawingFrame(AppService appService){
        DrawingWindowController drawingWindowController = new DrawingWindowController(appService);
        this.addWindowListener(drawingWindowController);
        this.addWindowFocusListener(drawingWindowController);
        this.addWindowStateListener(drawingWindowController);

        DrawingView drawingView = new DrawingView(appService);
        this.getContentPane().add(drawingView);

        // menu bar to change shape

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Shape");
        JMenuItem item1 = new JMenuItem("Line");
        JMenuItem item2 = new JMenuItem("Ellipse");
        JMenuItem item3 = new JMenuItem("Rectangle");

        menu.add(item1);
        menu.add(item2);
        menu.add(item3);

        item1.addActionListener(e -> appService.setShapeMode(ShapeMode.Line));
        item2.addActionListener(e -> appService.setShapeMode(ShapeMode.EllipseShape));
        item3.addActionListener(e -> appService.setShapeMode(ShapeMode.RectangleShape));

        menuBar.add(menu);
        this.setJMenuBar(menuBar);
    }
}
