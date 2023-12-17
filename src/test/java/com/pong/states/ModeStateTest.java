package com.pong.states;

import com.pong.controller.Controller;
import com.pong.controller.mode.ModeController;
import com.pong.model.mode.Mode;
import com.pong.viewer.Viewer;
import com.pong.viewer.mode.ModeViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModeStateTest {
    private Mode modemock;
    private ModeState modeState;

    @BeforeEach
    public void setup(){
        modemock = Mockito.mock(Mode.class);
        modeState = new ModeState(modemock);
    }
    @Test
    public void testGetViewer(){
        Viewer<Mode> viewer = modeState.getViewer();
        assertEquals(ModeViewer.class,viewer.getClass());
    }
    @Test
    public void testGetController(){
        Controller<Mode> controller = modeState.getController();
        assertEquals(ModeController.class,controller.getClass());
    }
}
