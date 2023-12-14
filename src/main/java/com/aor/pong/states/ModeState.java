package com.aor.pong.states;

import com.aor.pong.controller.Controller;
import com.aor.pong.controller.mode.ModeController;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.model.mode.Mode;
import com.aor.pong.viewer.mode.ModeViewer;
import com.aor.pong.viewer.Viewer;

public class ModeState extends State<Mode> {
    public ModeState(Mode model) {
        super(model);
    }

    @Override
    protected Viewer<Mode> getViewer() {
        return new ModeViewer(getModel());
    }

    @Override
    protected Controller<Mode> getController() {
        return new ModeController(getModel());
    }
}
