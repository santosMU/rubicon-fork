package com.santos.drawfx.service;

import com.santos.drawfx.model.Shape;
import java.awt.*;

public interface RendererService {
    void render(Graphics g, Shape shape, boolean xor);
}
