package com.aor.pong.states;

//import com.aor.pong.controller.game.ArenaController;
import com.aor.pong.controller.Controller;
import com.aor.pong.controller.game.ArenaController;
import com.aor.pong.viewer.game.GameViewer;
import com.aor.pong.model.game.arena.Arena;
import com.aor.pong.viewer.Viewer;

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
