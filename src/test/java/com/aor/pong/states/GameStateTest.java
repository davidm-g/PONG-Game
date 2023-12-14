package com.aor.pong.states;

import com.aor.pong.Game;
import com.aor.pong.controller.Controller;
import com.aor.pong.controller.game.ArenaController;
import com.aor.pong.model.game.arena.Arena;
import com.aor.pong.viewer.Viewer;
import com.aor.pong.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameStateTest {
    private Arena arenamock;
    private GameState gameState;

    @BeforeEach
    public void setup(){
        arenamock = Mockito.mock(Arena.class);
        gameState = new GameState(arenamock);
    }
    @Test
    public void testGetViewer(){
        Viewer<Arena> viewer = gameState.getViewer();
        assertEquals(GameViewer.class,viewer.getClass());
    }
    @Test
    public void testGetController(){
        Controller<Arena> controller = gameState.getController();
        assertEquals(ArenaController.class,controller.getClass());
    }
}
