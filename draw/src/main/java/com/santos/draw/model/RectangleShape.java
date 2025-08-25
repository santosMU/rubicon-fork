package com.santos.draw.model;


import com.santos.draw.service.RectangleRendererService;
import com.santos.drawfx.model.Shape;
import lombok.Data;

import java.awt.*;


@Data
public class RectangleShape extends Shape {

    public RectangleShape(Point start, Point end){
        super(start);
        this.setEnd(end);
        this.setColor(Color.CYAN);
        this.setRendererService(new RectangleRendererService());
    }
}
