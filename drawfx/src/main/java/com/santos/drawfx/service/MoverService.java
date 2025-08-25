package com.santos.drawfx.service;

import com.santos.drawfx.model.Shape;

import java.awt.*;

public final class MoverService {
    public void  move(Shape shape, Point newLoc){
        shape.setLocation( newLoc);
     }
}
