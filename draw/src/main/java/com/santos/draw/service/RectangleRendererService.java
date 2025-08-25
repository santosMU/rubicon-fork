package com.santos.draw.service;

import com.santos.draw.model.RectangleShape;
import com.santos.drawfx.model.Shape;
import com.santos.drawfx.service.RendererService;

import java.awt.*;

public class RectangleRendererService implements RendererService {

    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        RectangleShape rectangle = (RectangleShape) shape;
      //  g.setColor(shape.getColor());
        g.setXORMode(shape.getColor());

        int x = Math.min(rectangle.getLocation().x, rectangle.getEnd().x);
        int y = Math.min(rectangle.getLocation().y, rectangle.getEnd().y);
        int w = Math.abs(rectangle.getEnd().x - rectangle.getLocation().x);
        int h = Math.abs(rectangle.getEnd().y - rectangle.getLocation().y);

        g.drawRect(x, y, w, h);
    }
}