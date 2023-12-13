package com.aor.pong.Controller;

import com.aor.pong.controller.Music;
import com.aor.pong.controller.MusicManager;
import com.aor.pong.controller.Sounds;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MusicManagerTest {
    @Mock
    private Music menuMock;
    @Mock
    private Music hitMock;
    @Mock
    private Music paddleMock;
    @Mock
    private Music goalMock;
    @Mock
    private Music gameOverMock;
    private MusicManager musicManager;
    @BeforeEach
    void setUp(){
        menuMock=Mockito.mock(Music.class);
        hitMock=Mockito.mock(Music.class);
        paddleMock=Mockito.mock(Music.class);
        goalMock=Mockito.mock(Music.class);
        gameOverMock=Mockito.mock(Music.class);
        musicManager=MusicManager.getInstance();
        musicManager.setMenu(menuMock);
        musicManager.setGoal(goalMock);
        musicManager.setHit(hitMock);
        musicManager.setPaddle(paddleMock);
        musicManager.setGameOver(gameOverMock);
    }
    @Test
    void startMenuLoop(){
        musicManager.setMenu(menuMock);
        musicManager.start(Sounds.MENU);
        Mockito.verify(menuMock).startLoop();
    }
    @Test
    void stopMenuLoop(){

        musicManager.setMenu(menuMock);
        musicManager.stop(Sounds.MENU);
        Mockito.verify(menuMock).stop();
    }
    @Test
    void startGameOverLoop(){
        musicManager.setGameOver(gameOverMock);
        musicManager.start(Sounds.GAMEOVER);
        Mockito.verify(gameOverMock).startLoop();
    }
    @Test
    void stopGameOverLoop(){
        musicManager.setMenu(gameOverMock);
        musicManager.stop(Sounds.GAMEOVER);
        Mockito.verify(gameOverMock).stop();
    }
    @Test
    void startPaddle(){
        musicManager.start(Sounds.PADDLE);
        Mockito.verify(paddleMock,Mockito.times(1)).start();
    }
    @Test
    void startHit(){
        musicManager.start(Sounds.HIT);
        Mockito.verify(hitMock,Mockito.times(1)).start();
    }
    @Test
    void startGoal(){
        musicManager.start(Sounds.GOAL);
        Mockito.verify(goalMock,Mockito.times(1)).start();
    }
    @Test
    void stopPaddle(){
        musicManager.stop(Sounds.PADDLE);
        Mockito.verify(paddleMock,Mockito.times(1)).stop();
    }
    @Test
    void stopHit(){
        musicManager.stop(Sounds.HIT);
        Mockito.verify(hitMock,Mockito.times(1)).stop();
    }
    @Test
    void stopGoal(){
        musicManager.stop(Sounds.GOAL);
        Mockito.verify(goalMock,Mockito.times(1)).stop();
    }
    @Test
    void isPlayingMenuTrue(){
        Mockito.when(menuMock.isPlaying()).thenReturn(true);
        assertTrue(musicManager.isPlaying(Sounds.MENU));
    }
    @Test
    void isPlayingMenuFalse(){
        Mockito.when(menuMock.isPlaying()).thenReturn(false);
        assertFalse(musicManager.isPlaying(Sounds.MENU));
    }
    @Test
    void isPlayingHitTrue(){
        Mockito.when(hitMock.isPlaying()).thenReturn(true);
        assertTrue(musicManager.isPlaying(Sounds.HIT));
    }
    @Test
    void isPlayingHitFalse(){
        Mockito.when(hitMock.isPlaying()).thenReturn(false);
        assertFalse(musicManager.isPlaying(Sounds.HIT));
    }
    @Test
    void isPlayingPaddleTrue(){
        Mockito.when(paddleMock.isPlaying()).thenReturn(true);
        assertTrue(musicManager.isPlaying(Sounds.PADDLE));
    }
    @Test
    void isPlayingPaddleFalse(){
        Mockito.when(paddleMock.isPlaying()).thenReturn(false);
        assertFalse(musicManager.isPlaying(Sounds.PADDLE));
    }
    @Test
    void isPlayingGoalTrue(){
        Mockito.when(goalMock.isPlaying()).thenReturn(true);
        assertTrue(musicManager.isPlaying(Sounds.GOAL));
    }
    @Test
    void isPlayingGoalFalse(){
        Mockito.when(goalMock.isPlaying()).thenReturn(false);
        assertFalse(musicManager.isPlaying(Sounds.GOAL));
    }
    @Test
    void isPlayingGameOverTrue(){
        Mockito.when(gameOverMock.isPlaying()).thenReturn(true);
        assertTrue(musicManager.isPlaying(Sounds.GAMEOVER));
    }
    @Test
    void isPlayingGameOverFalse(){
        Mockito.when(gameOverMock.isPlaying()).thenReturn(false);
        assertFalse(musicManager.isPlaying(Sounds.GAMEOVER));
    }
    @Test
    void stopAllMusic(){
        musicManager.stopAll();
        Mockito.verify(menuMock,Mockito.times(1)).stop();
        Mockito.verify(gameOverMock,Mockito.times(1)).stop();
        Mockito.verify(goalMock,Mockito.times(1)).stop();
        Mockito.verify(paddleMock,Mockito.times(1)).stop();
        Mockito.verify(hitMock,Mockito.times(1)).stop();
    }



}
