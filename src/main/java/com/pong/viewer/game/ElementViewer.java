package com.pong.viewer.game;

import com.pong.gui.GUI;
import com.pong.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
