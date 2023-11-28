package com.aor.pong.controller.game;



import com.aor.pong.Game;
import com.aor.pong.gui.GUI;
import com.aor.pong.model.game.arena.Arena;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final Paddle1Controller paddle1Controller;
    private final Paddle2Controller paddle2Controller;
    private final BallController ballController;

    public ArenaController(Arena arena) {
        super(arena);
        this.paddle1Controller = new Paddle1Controller(arena);
        this.paddle2Controller = new Paddle2Controller(arena);
        this.ballController = new BallController(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
        else {
            paddle2Controller.step(game, action, time);
            paddle1Controller.step(game, action, time);
        }
    }
}


