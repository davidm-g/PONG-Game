package com.aor.hero;

public abstract class State {
    private Controller controller;
    private Viewer viewer;
public State(){
    this.viewer=createviewer();
    this.controller=createcontroller();
}

protected abstract Viewer createviewer();
protected abstract Controller createcontroller();

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }
}
