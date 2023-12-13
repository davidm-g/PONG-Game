package com.aor.pong.Controller;

import com.aor.pong.controller.Music;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import static org.junit.jupiter.api.Assertions.*;

public class MusicTest {
    @Test
    public void testSoundLoad(){
        Music music = new Music("gameOver.wav");
        assertNotNull(music.getSound());
    }
    @Test
    public void testStartLoop(){
        Music music = new Music("goal.wav");
        assertFalse(music.isPlaying());
        music.startLoop();
        assertTrue(music.isPlaying());
    }
    @Test
    public void testStart(){
        Music music = new Music("hit.wav");
        assertFalse(music.isPlaying());
        music.start();
        assertTrue(music.isPlaying());
    }
    @Test
    public void testStop(){
        Music music = new Music("menu.wav");
        assertFalse(music.isPlaying());
        music.start();
        assertTrue(music.isPlaying());
        music.stop();
        assertFalse(music.isPlaying());
    }
    @Test
    public void testSetSound() throws LineUnavailableException {
        Music music = new Music("paddle.wav");
        Clip newSound = AudioSystem.getClip();
        music.setSound(newSound);
        assertEquals(newSound,music.getSound());
    }

}
