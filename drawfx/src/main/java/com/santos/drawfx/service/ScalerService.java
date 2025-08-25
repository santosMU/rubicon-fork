package com.santos.drawfx.service;

import com.santos.drawfx.model.Shape;

import java.awt.*;

public final class  ScalerService {
    void scale(Shape shape, Point newEnd){
        shape.setEnd(newEnd);
    }
}
