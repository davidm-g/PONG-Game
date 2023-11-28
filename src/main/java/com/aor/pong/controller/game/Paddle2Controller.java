package com.aor.pong.controller.game;

import com.aor.pong.Game;
import com.aor.pong.gui.GUI;
import com.aor.pong.model.Position;
import com.aor.pong.model.game.arena.Arena;

import java.io.IOException;

public class Paddle2Controller extends GameController {
    public Paddle2Controller(Arena arena){
        super(arena);
    }
    public void movePaddle2Up(){movePaddle2(getModel().getPaddle2().getPosition().getUp());}

    public void movePaddle2Down(){movePaddle2(getModel().getPaddle2().getPosition().getDown());}

    private void movePaddle2(Position position){
        if (getModel().CheckPosPaddle(position)) {
            getModel().getPaddle2().setPosition(position);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.PADDLE2UP) movePaddle2Up();
        if (action == GUI.ACTION.PADDLE2DOWN) movePaddle2Down();
    }
}
