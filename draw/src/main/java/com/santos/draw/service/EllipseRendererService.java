package com.santos.draw.service;

import com.santos.draw.model.EllipseShape;
import com.santos.drawfx.model.Shape;
import com.santos.drawfx.service.RendererService;

import java.awt.*;


public class EllipseRendererService implements RendererService {

    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        EllipseShape ellipse = (EllipseShape) shape;
      //  g.setColor(shape.getColor());
        g.setXORMode(shape.getColor());

        int x = Math.min(ellipse.getLocation().x, ellipse.getEnd().x);
        int y = Math.min(ellipse.getLocation().y, ellipse.getEnd().y);
        int w = Math.abs(ellipse.getEnd().x - ellipse.getLocation().x);
        int h = Math.abs(ellipse.getEnd().y - ellipse.getLocation().y);

        g.drawOval(x, y, w, h);
    }
}