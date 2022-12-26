package org.academiadecodigo.bootcamp.gameweek;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    private Clip clip;
    private URL[] soundURL = new URL[5];
    public Sound(int chosenSound) {
        init();
        setFile(chosenSound);
    }
    public void init(){
        soundURL[0] = getClass().getResource("Crunch sound effect ｜ No copyright.wav");
        soundURL[1] = getClass().getResource("Game Over sound effect.wav");
        soundURL[2] = getClass().getResource("Lavender Town (Original Japanese Version from Pokemon Red and Green).wav");
        soundURL[3] = getClass().getResource("Pew sound effect.wav");
        soundURL[4] = getClass().getResource("Punch Hit Sound Effect.wav");
    }
    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
        }
    }
    public void play() {
        /*
        try {
            // 0.8 seconds start delay
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

         */
        clip.start();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        clip.stop();
    }
}

