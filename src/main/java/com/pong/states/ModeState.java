package com.pong.states;

import com.pong.controller.Controller;
import com.pong.controller.mode.ModeController;
import com.pong.model.mode.Mode;
import com.pong.viewer.mode.ModeViewer;
import com.pong.viewer.Viewer;

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
