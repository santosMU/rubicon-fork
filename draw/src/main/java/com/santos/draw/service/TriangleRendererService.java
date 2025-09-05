package com.santos.draw.service;

import com.santos.draw.model.TriangleShape;
import com.santos.drawfx.model.Shape;
import com.santos.drawfx.service.RendererService;

import java.awt.*;

public class TriangleRendererService implements RendererService {

    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        TriangleShape triangle = (TriangleShape) shape;
        //  g.setColor(shape.getColor());
        g.setXORMode(shape.getColor());

        int x = triangle.getLocation().x;
        int y = triangle.getLocation().y;
        int w = Math.abs(triangle.getEnd().x - triangle.getLocation().x);
        int h = Math.abs(triangle.getEnd().y - triangle.getLocation().y);

        int [] xList = {x-w, x, x+w};
        int [] yList = {y, y-h, y};

        g.drawPolygon(xList, yList, 3);
    }
}