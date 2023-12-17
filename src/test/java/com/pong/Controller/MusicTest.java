package com.pong.Controller;

import com.pong.controller.Music;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class MusicTest {
    @Test
    public void testSoundLoad(){
        Music music = new Music("gameOver.wav");
        assertNotNull(music.getSound());
    }
    @Test
    public void testStartLoop() throws InterruptedException {
        Clip clipMock=Mockito.mock(Clip.class);
        Music music = new Music("goal.wav");
        music.setSound(clipMock);
        music.startLoop();
        Mockito.verify(clipMock,Mockito.times(1)).setMicrosecondPosition(0);
        Mockito.verify(clipMock,Mockito.times(1)).start();
        Mockito.verify(clipMock,Mockito.times(1)).loop(Clip.LOOP_CONTINUOUSLY);

    }
    @Test
    public void testStart(){
        Music music = new Music("hit.wav");
        FloatControl floatControl=(FloatControl) music.getSound().getControl(FloatControl.Type.MASTER_GAIN);
        assertEquals(-25.0f,floatControl.getValue());
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
    @Test
    void testLoadSoundNull(){
        Music music=new Music("shoutouttelmo.wav");
        assertNull(music.getSound());
    }
    @Test
    void testSetSoundNull(){
        Music music= new Music("hit.wav");
        music.setSound(null);
        assertNull(music.getSound());
    }
    @Test
    void testSetMicroPosition(){
        Clip clipMock=Mockito.mock(Clip.class);
        Music music = new Music("goal.wav");
        music.setSound(clipMock);
        music.start();
        Mockito.verify(clipMock,Mockito.times(1)).setMicrosecondPosition(0);
    }

}
