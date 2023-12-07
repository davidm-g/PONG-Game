package com.aor.pong.controller.Winner;

import com.aor.pong.Game;
import com.aor.pong.controller.Controller;
import com.aor.pong.gui.GUI;
import com.aor.pong.model.Winner.Winner;
import com.aor.pong.model.game.arena.ArenaBuilder;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.states.GameState;
import com.aor.pong.states.MenuState;

import java.io.IOException;

public class WinnerController extends Controller<Winner> {
    public WinnerController(Winner winner) {
        super(winner);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case PADDLE2UP:
                getModel().previousEntry();
                break;
            case PADDLE2DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedMenu()) game.setState(new MenuState(new Menu()));
                if (getModel().isSelectedPlay()) game.setState(new GameState(new ArenaBuilder().createArena()));
        }
    }
}
