package com.aor.hero;

public class GameState extends State{
    @Override
    protected Controller createcontroller() {
        return new GameController();
    }

    @Override
    protected Viewer createviewer() {
        return new GameViewer();
    }
}
