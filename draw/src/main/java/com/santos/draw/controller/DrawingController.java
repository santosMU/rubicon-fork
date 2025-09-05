package com.santos.draw.controller;

import com.santos.draw.model.*;
import com.santos.drawfx.DrawMode;
import com.santos.drawfx.ShapeMode;
import com.santos.draw.view.DrawingView;
import com.santos.drawfx.service.AppService;
import com.santos.drawfx.model.Shape;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawingController  implements MouseListener, MouseMotionListener {
    private Point end;
    final private DrawingView drawingView;

    Shape currentShape;
    AppService appService;
     public DrawingController(AppService appService, DrawingView drawingView){
       this.appService = appService;
         this.drawingView = drawingView;
         drawingView.addMouseListener(this);
         drawingView.addMouseMotionListener(this);
         appService.setDrawMode(DrawMode.Idle);
         appService.setShapeMode(ShapeMode.Line);
     }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point start;
        if(appService.getDrawMode() == DrawMode.Idle) {
            start = e.getPoint();

            switch (appService.getShapeMode()) {
                case Line:
                    currentShape = new Line(start, start);
                    break;
                case RectangleShape:
                    currentShape = new RectangleShape(start, start);
                    break;
                case TriangleShape:
                    currentShape = new TriangleShape(start, start);
                    break;
                case EllipseShape:
                    currentShape = new EllipseShape(start, start);
                    break;
            }

            if (currentShape != null){
                currentShape.getRendererService().render(drawingView.getGraphics(), currentShape, false);
                appService.setDrawMode(DrawMode.MousePressed);
            }

            // old method
//            if(appService.getShapeMode() == ShapeMode.Line) {
//                start = e.getPoint();
//
//                currentShape = new Line(start,start);
//                currentShape.getRendererService().render(drawingView.getGraphics(), currentShape,false );
//                appService.setDrawMode(DrawMode.MousePressed);
//            }


        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
         if(appService.getDrawMode() == DrawMode.MousePressed && currentShape != null){
             appService.create(currentShape);
             appService.setDrawMode(DrawMode.Idle);
         }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(appService.getDrawMode() == DrawMode.MousePressed && currentShape != null) {
            end = e.getPoint();
            currentShape.getRendererService().render(drawingView.getGraphics(), currentShape,true );
            appService.scale(currentShape,end);
            currentShape.getRendererService().render(drawingView.getGraphics(), currentShape,true );
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
