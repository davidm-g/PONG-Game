package com.pong.states;

import com.pong.controller.Controller;
import com.pong.controller.Winner.WinnerController;
import com.pong.model.Winner.Winner;
import com.pong.viewer.Viewer;
import com.pong.viewer.Winner.WinnerViewer;

public class WinnerState extends State<Winner> {
    public WinnerState(Winner model) {
        super(model);
    }

    @Override
    protected Viewer<Winner> getViewer() {
        return new WinnerViewer(getModel());
    }

    @Override
    protected Controller<Winner> getController() {
        return new WinnerController(getModel());
    }
}
