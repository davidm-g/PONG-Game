package com.aor.hero;

import java.io.IOException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    private Game(){
        try {
            this.gui = new LanternaGUI(20,20);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        try {
            new Game().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    void run() throws IOException {

    }


}
