package com.santos.draw.model;


import com.santos.draw.service.EllipseRendererService;
import com.santos.drawfx.model.Shape;
import lombok.Data;

import java.awt.*;


@Data
public class EllipseShape extends Shape {

    public EllipseShape(Point start, Point end){
        super(start);
        this.setEnd(end);
        this.setColor(Color.YELLOW);
        this.setRendererService(new EllipseRendererService());
    }
}
