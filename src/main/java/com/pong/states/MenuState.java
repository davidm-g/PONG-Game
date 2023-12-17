package com.pong.states;

import com.pong.controller.Controller;
import com.pong.controller.menu.MenuController;
import com.pong.model.menu.Menu;
import com.pong.viewer.menu.MenuViewer;
import com.pong.viewer.Viewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
