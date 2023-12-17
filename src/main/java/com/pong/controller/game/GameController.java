package com.pong.controller.game;

import com.pong.controller.Controller;
import com.pong.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {

    public GameController(Arena model) {
        super(model);
    }
}


