package com.pong.states;

import com.pong.controller.Controller;
import com.pong.controller.game.ArenaController;
import com.pong.model.game.arena.Arena;
import com.pong.viewer.Viewer;
import com.pong.viewer.game.GameViewer;
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
