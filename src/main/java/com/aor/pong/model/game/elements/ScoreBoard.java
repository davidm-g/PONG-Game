package com.aor.pong.model.game.elements;

public class ScoreBoard extends Element {
    int score1;
    int score2;
    String name1, name2;
    public ScoreBoard(int x, int y){
        super(x,y);
        score1 = 0;
        score2 = 0;
        name1 = "Jogador 1";
        name2 = "Jogador 2";
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
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
