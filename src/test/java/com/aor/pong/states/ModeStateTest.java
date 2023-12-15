package com.aor.pong.states;

import com.aor.pong.controller.Controller;
import com.aor.pong.controller.mode.ModeController;
import com.aor.pong.controller.game.ArenaController;
import com.aor.pong.model.mode.Mode;
import com.aor.pong.model.game.arena.Arena;
import com.aor.pong.viewer.Viewer;
import com.aor.pong.viewer.mode.ModeViewer;
import com.aor.pong.viewer.game.GameViewer;
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
