package com.santos.draw;

import com.santos.draw.service.DrawingAppService;
import com.santos.draw.view.DrawingFrame;
import com.santos.drawfx.service.AppService;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AppService appService = new DrawingAppService();
        DrawingFrame drawingFrame = new DrawingFrame(appService);
        drawingFrame.setVisible(true);
        drawingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawingFrame.setSize(500,500);
    }
}