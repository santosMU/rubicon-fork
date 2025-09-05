package com.santos.draw.model;


import com.santos.draw.service.TriangleRendererService;
import com.santos.drawfx.model.Shape;
import lombok.Data;

import java.awt.*;


@Data
public class TriangleShape extends Shape {

    public TriangleShape(Point start, Point end){
        super(start);
        this.setEnd(end);
        this.setColor(Color.CYAN);
        this.setRendererService(new TriangleRendererService());
    }
}
