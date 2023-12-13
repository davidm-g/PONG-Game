package com.aor.pong.controller;

public class MusicManager {

    private Music menu;
    private Music hit;
    private Music paddle;
    private Music goal;
    private Music gameOver;
    private static MusicManager musicManager;

    private MusicManager() {
        menu = new Music("menu.wav");
        hit = new Music("hit.wav");
        paddle = new Music("paddle.wav");
        goal = new Music("goal.wav");
        gameOver = new Music("gameOver.wav");
    }

    public static MusicManager getInstance() {
        if (musicManager == null) {
            musicManager = new MusicManager();
        }
        return musicManager;
    }

    public void setMenu(Music menu) {
        this.menu = menu;
    }



    public void setHit(Music hit) {
        this.hit = hit;
    }

    public void setPaddle(Music paddle) {
        this.paddle = paddle;
    }

    public void setGoal(Music goal) {
        this.goal = goal;
    }

    public void setGameOver(Music gameOver) {
        this.gameOver = gameOver;
    }


    public void start(Sounds sound) {
        switch(sound) {
            case MENU -> menu.startLoop();
            case HIT -> hit.start();
            case GOAL -> goal.start();
            case PADDLE -> paddle.start();
            case GAMEOVER -> gameOver.startLoop();
        }
    }

    public void stop(Sounds sound) {
        switch(sound) {
            case MENU -> menu.stop();
            case GAMEOVER -> gameOver.stop();
            case HIT -> hit.stop();
            case GOAL -> goal.stop();
            case PADDLE -> paddle.stop();
        }
    }

    public boolean isPlaying(Sounds sound) {
        return switch (sound) {
            case MENU -> menu.isPlaying();
            case HIT -> hit.isPlaying();
            case GOAL -> goal.isPlaying();
            case PADDLE -> paddle.isPlaying();
            case GAMEOVER -> gameOver.isPlaying();
        };
    }
    public void stopAll() {
        menu.stop();
        goal.stop();
        hit.stop();
        paddle.stop();
        gameOver.stop();
    }
}
