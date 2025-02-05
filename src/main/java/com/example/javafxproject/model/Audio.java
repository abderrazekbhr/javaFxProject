package com.example.javafxproject.model;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {

    Long currentFrame;
    String status;
    public Clip clip;
    private AudioInputStream audioInputStream;
    private String fileName = "";

    public Audio(String fileName)
            throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // create AudioInputStream object
        final String AUDIO = "sound/";
        this.fileName = fileName;
        audioInputStream = AudioSystem
                .getAudioInputStream(new File(GameScene.IMG_PATH + AUDIO + this.fileName).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();
        // open audioInputStream to the clip
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}
