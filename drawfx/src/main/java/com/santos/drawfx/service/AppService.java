package com.santos.drawfx.service;

import com.santos.drawfx.DrawMode;
import com.santos.drawfx.ShapeMode;
import com.santos.drawfx.model.Shape;

import javax.swing.*;
import java.awt.*;

public interface AppService {
    void undo();
    void redo();

    ShapeMode getShapeMode();
    void setShapeMode(ShapeMode shapeMode);

    DrawMode getDrawMode();
    void setDrawMode(DrawMode drawMode);

    Color getColor();
    void setColor(Color color);

    Color getFill();
    void setFill(Color color);

    void move(Shape shape, Point newLoc);
    void scale(Shape shape, Point newEnd);

    void create(Shape shape);
    void delete(Shape shape);

    void close();

    Object getModel();
    JPanel getView();
    void setView(JPanel panel);
    void repaint();
}
