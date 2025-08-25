package com.santos.draw.service;

import com.santos.draw.model.Line;
import com.santos.drawfx.service.RendererService;
import com.santos.drawfx.model.Shape;

import java.awt.*;


public class LineRendererService implements RendererService {

    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        Line line = (Line) shape;
      //  g.setColor(shape.getColor());
        g.setXORMode(shape.getColor());
        g.drawLine(line.getLocation().x, line.getLocation().y, line.getEnd().x, line.getEnd().y);
    }
}