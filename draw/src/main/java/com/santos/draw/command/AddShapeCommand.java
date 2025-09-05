package com.santos.draw.command;

import com.santos.drawfx.command.Command;
import com.santos.drawfx.model.Shape;
import com.santos.drawfx.service.AppService;

public class AddShapeCommand implements Command{
    Shape shape;
    AppService appService;

    public AddShapeCommand(AppService appService, Shape shape){
        this.shape = shape;
        this.appService = appService;
    }
    @Override
    public void execute() {
        appService.create(shape);
    }

    @Override
    public void undo() {
        appService.delete(shape);
    }

    @Override
    public void redo() {
        appService.create(shape);
    }
}