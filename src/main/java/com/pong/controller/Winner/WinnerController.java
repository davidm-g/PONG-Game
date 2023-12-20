package com.pong.controller.Winner;

import com.pong.Game;
import com.pong.controller.Controller;
import com.pong.controller.MusicManager;
import com.pong.controller.Sounds;
import com.pong.gui.GUI;
import com.pong.model.Winner.Winner;
import com.pong.model.game.arena.ArenaBuilder;
import com.pong.model.menu.Menu;
import com.pong.states.GameState;
import com.pong.states.MenuState;

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
                if (getModel().isSelectedMenu()) {
                    MusicManager.getInstance().stopAll();
                    MusicManager.getInstance().start(Sounds.MENU);
                    game.setState(new MenuState(new Menu()));
                }
                if (getModel().isSelectedPlay()) {
                    MusicManager.getInstance().stopAll();
                    game.setState(new GameState(new ArenaBuilder().createArena()));
                }
            // fall through
            default:

                break;
        }
    }
}
