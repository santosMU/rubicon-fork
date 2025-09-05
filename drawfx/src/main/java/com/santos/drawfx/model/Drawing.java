package com.santos.drawfx.model;

import com.santos.drawfx.DrawMode;
import com.santos.drawfx.ShapeMode;
import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
@Data
public class Drawing {
    private Color color;
    private Color fill;
    private ShapeMode shapeMode = ShapeMode.RectangleShape;
    private DrawMode drawMode = DrawMode.Idle;
    List<Shape> shapes;
    public Drawing(){
        shapes = new ArrayList<>();
    }
}
