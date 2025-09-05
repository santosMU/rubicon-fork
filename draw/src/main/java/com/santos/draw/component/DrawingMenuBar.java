package com.santos.draw.component;

import com.santos.drawfx.ShapeMode;
import com.santos.drawfx.service.AppService;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class DrawingMenuBar extends JMenuBar implements ActionListener {
    private AppService appService;

    private final JMenuItem lineMenuItem = new JMenuItem("Line");
    private final JMenuItem rectangleMenuItem = new JMenuItem("Rectangle");
    private final JMenuItem ellipseMenuItem = new JMenuItem("Ellipse");

    private final JMenuItem undoMenuItem = new JMenuItem("Undo");
    private final JMenuItem redoMenuItem = new JMenuItem("Redo");

    private final JMenuItem colorMenuItem = new JMenuItem("Choose Color");

    public DrawingMenuBar(AppService appService ){
        super();
        this.appService = appService;
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        add(editMenu);
        undoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
        undoMenuItem.addActionListener(this);
        editMenu.add(undoMenuItem);
        redoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        redoMenuItem.addActionListener(this);
        editMenu.add(redoMenuItem);

        editMenu.add(colorMenuItem);
        colorMenuItem.addActionListener(this);

        JMenu drawMenu = new JMenu("Draw");
        drawMenu.setMnemonic(KeyEvent.VK_D);
        editMenu.add(drawMenu);
        drawMenu.add(lineMenuItem);
        lineMenuItem.addActionListener(this);
        drawMenu.add(rectangleMenuItem);
        rectangleMenuItem.addActionListener(this);
        drawMenu.add(ellipseMenuItem);
        ellipseMenuItem.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == undoMenuItem) {
            appService.undo();
        }
        else if(e.getSource() == redoMenuItem) {
            appService.redo();
        }
        else if(e.getSource() == lineMenuItem){
            appService.setShapeMode( ShapeMode.Line);
        }
        else if(e.getSource() == rectangleMenuItem){
            appService.setShapeMode(ShapeMode.RectangleShape);
        }
        else if(e.getSource() == ellipseMenuItem){
            appService.setShapeMode(ShapeMode.EllipseShape);
        }
        else if (e.getSource() == colorMenuItem){
            Color chosenColor = JColorChooser.showDialog(this, "Choose Drawing Color", appService.getColor());
            if (chosenColor != null){
                appService.setColor(chosenColor);
            }
        }
    }
}