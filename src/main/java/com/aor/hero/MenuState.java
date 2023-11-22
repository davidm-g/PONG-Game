package com.aor.hero;

public class MenuState extends State{
    @Override
    protected Controller createcontroller() {
        return new MenuController();
    }

    @Override
    protected Viewer createviewer() {
        return new MenuViewer();
    }
}