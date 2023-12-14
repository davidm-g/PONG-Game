package com.aor.pong.controller.mode;


import com.aor.pong.Game;
import com.aor.pong.controller.Controller;
import com.aor.pong.controller.MusicManager;
import com.aor.pong.gui.GUI;
import com.aor.pong.gui.LanternaGUI;
import com.aor.pong.model.game.arena.ArenaBuilder;
import com.aor.pong.model.menu.Menu;
import com.aor.pong.model.mode.Mode;
import com.aor.pong.states.GameState;
import com.aor.pong.states.MenuState;

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


