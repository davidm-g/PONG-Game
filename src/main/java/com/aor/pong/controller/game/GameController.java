package com.aor.pong.controller.game;

import com.aor.pong.controller.Controller;
import com.aor.pong.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {

    public GameController(Arena model) {
        super(model);
    }
}


