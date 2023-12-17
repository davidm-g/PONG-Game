package com.pong.Controller;

import com.pong.Game;
import com.pong.controller.game.GameController;
import com.pong.gui.GUI;
import com.pong.model.game.arena.Arena;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

public class GameControllerTest {
    private Arena arena;
        @Test
        public void GameControllerConstructorTest(){
            arena=new Arena(60,20);
            GameController gameController=new GameController(arena) {
                @Override
                public void step(Game game, GUI.ACTION action, long time) throws IOException {
                    //no implementation needed, testing the constructor.
                }
            };
            assertEquals(arena,gameController.getModel());
        }

}
