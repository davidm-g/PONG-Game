package com.aor.pong.controller.game;


import com.aor.pong.Game;
import com.aor.pong.gui.GUI;
import com.aor.pong.model.Position;
import com.aor.pong.model.game.arena.Arena;

import java.io.IOException;

public class Paddle1Controller extends GameController {

    public Paddle1Controller(Arena arena){
        super(arena);
    }
    public void movePaddle1Up(){movePaddle1(getModel().getPaddle1().getPosition().getUp());}

    public void movePaddle1Down(){movePaddle1(getModel().getPaddle1().getPosition().getDown());}

    private void movePaddle1(Position position){
        if (getModel().CheckPosPaddle(position)) {
            getModel().getPaddle1().setPosition(position);
        }
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.PADDLE1UP) movePaddle1Up();
        if (action == GUI.ACTION.PADDLE1DOWN) movePaddle1Down();
    }
}
