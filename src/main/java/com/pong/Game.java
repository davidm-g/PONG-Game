package com.pong;

import com.pong.controller.MusicManager;
import com.pong.controller.Sounds;
import com.pong.gui.LanternaGUI;
import com.pong.model.menu.Menu;
import com.pong.states.MenuState;
import com.pong.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
     private MusicManager musicManager;
    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(40, 20);
        musicManager = MusicManager.getInstance();
        musicManager.start(Sounds.MENU);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException, InterruptedException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException, InterruptedException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) Thread.sleep(sleepTime);
        }

        gui.close();
    }

    public State getState() {
        return state;
    }
}
