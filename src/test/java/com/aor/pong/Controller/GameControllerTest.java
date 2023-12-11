package com.aor.pong.Controller;

import com.aor.pong.Game;
import com.aor.pong.controller.game.GameController;
import com.aor.pong.gui.GUI;
import com.aor.pong.model.game.arena.Arena;
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
