package com.aor.pong.states;

import com.aor.pong.controller.Controller;
import com.aor.pong.controller.Winner.WinnerController;
import com.aor.pong.controller.menu.MenuController;
import com.aor.pong.model.Winner.Winner;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.viewer.Viewer;
import com.aor.pong.viewer.Winner.WinnerViewer;
import com.aor.pong.viewer.menu.MenuViewer;

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
