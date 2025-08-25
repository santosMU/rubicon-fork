package com.santos.draw.model;


import com.santos.draw.service.LineRendererService;
import lombok.Data;
import com.santos.drawfx.model.Shape;
import java.awt.*;


@Data
public class Line extends Shape {

    public Line(Point start, Point end){
        super(start);
        this.setEnd(end);
        this.setColor(Color.RED);
        this.setRendererService(new LineRendererService());
    }
}
