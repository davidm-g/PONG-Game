package com.pong.controller.menu;


import com.pong.Game;
import com.pong.controller.Controller;
import com.pong.gui.GUI;
import com.pong.model.menu.Menu;
import com.pong.model.mode.Mode;
import com.pong.states.ModeState;

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
                if (getModel().isSelectedPlay())  {
                    game.setState(new ModeState(new Mode()));
                }
        }
    }
}


