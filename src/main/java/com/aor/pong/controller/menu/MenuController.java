package com.aor.pong.controller.menu;


import com.aor.pong.Game;
import com.aor.pong.controller.Controller;
import com.aor.pong.gui.GUI;
import com.aor.pong.model.game.arena.Arena;
import com.aor.pong.model.game.arena.ArenaBuilder;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
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
                if (getModel().isSelectedLeave()) game.setState(null);
                if (getModel().isSelectedPlay()) game.setState(new GameState(new ArenaBuilder().createArena()));
        }
    }
}


