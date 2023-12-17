package com.pong.model.game.elements;

public class ScoreBoard extends Element {
    int score1;
    int score2;
    public ScoreBoard(int x, int y){
        super(x,y);
        score1 = 0;
        score2 = 0;
    }


    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }
    public void alterScore1(){
        score1++;
    }
    public void alterScore2(){
        score2++;
    }
}
