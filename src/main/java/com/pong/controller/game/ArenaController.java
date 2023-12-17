package com.pong.controller.game;



import com.pong.Game;
import com.pong.controller.MusicManager;
import com.pong.controller.Sounds;
import com.pong.gui.GUI;
import com.pong.model.Winner.Winner;
import com.pong.model.game.arena.Arena;
import com.pong.model.menu.Menu;
import com.pong.states.MenuState;
import com.pong.states.WinnerState;

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
        if (action == GUI.ACTION.QUIT){
            MusicManager.getInstance().stopAll();
            MusicManager.getInstance().start(Sounds.MENU);
            game.setState(new MenuState(new Menu()));
        }
        else if(getModel().getScoreBoard().getScore2() >= 11) {
            MusicManager.getInstance().stopAll();
            MusicManager.getInstance().start(Sounds.GAMEOVER);
            game.setState(new WinnerState(new Winner(2)));
        }
        else if (getModel().getScoreBoard().getScore1() >= 11) {
            MusicManager.getInstance().stopAll();
            MusicManager.getInstance().start(Sounds.GAMEOVER);
            game.setState(new WinnerState(new Winner(1)));
        }
        else {
            paddle2Controller.step(game, action, time);
            paddle1Controller.step(game, action, time);
            ballController.step(game,action,time);
        }
    }
}


