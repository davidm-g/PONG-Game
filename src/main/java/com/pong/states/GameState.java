package com.pong.states;

//import com.aor.pong.controller.game.ArenaController;
import com.pong.controller.Controller;
import com.pong.controller.game.ArenaController;
import com.pong.viewer.game.GameViewer;
import com.pong.model.game.arena.Arena;
import com.pong.viewer.Viewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }

}
