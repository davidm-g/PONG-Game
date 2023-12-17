package com.pong.controller.mode;


import com.pong.Game;
import com.pong.controller.Controller;
import com.pong.controller.MusicManager;
import com.pong.gui.GUI;
import com.pong.gui.LanternaGUI;
import com.pong.model.game.arena.ArenaBuilder;
import com.pong.model.menu.Menu;
import com.pong.model.mode.Mode;
import com.pong.states.GameState;
import com.pong.states.MenuState;

import java.io.IOException;

public class ModeController extends Controller<Mode> {
    public ModeController(Mode mode) {
        super(mode);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case QUIT:
                game.setState(new MenuState(new Menu()));
            case PADDLE2UP:
                getModel().previousEntry();
                break;
            case PADDLE2DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedEasy()) {
                    MusicManager.getInstance().stopAll();
                    LanternaGUI.setMode(2);
                    game.setState(new GameState(new ArenaBuilder().createArena()));
                }
                if (getModel().isSelectedMedium()) {
                    MusicManager.getInstance().stopAll();
                    LanternaGUI.setMode(1);
                    game.setState(new GameState(new ArenaBuilder().createArena()));
                }
                if (getModel().isSelectedHard()) {
                    MusicManager.getInstance().stopAll();
                    LanternaGUI.setMode(0);
                    game.setState(new GameState(new ArenaBuilder().createArena()));
                }
        }
    }
}


