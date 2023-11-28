package com.aor.pong.controller.game;

import com.aor.pong.Game;
import com.aor.pong.gui.GUI;
import com.aor.pong.model.game.arena.Arena;

import java.io.IOException;

public class BallController extends GameController{
    public BallController(Arena arena){
        super(arena);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

    }
}
