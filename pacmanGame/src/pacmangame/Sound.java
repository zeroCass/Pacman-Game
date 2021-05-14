

package pacmangame;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
    private Clip clip;
    private int framePosition;
    
    
    public Sound (String soundFileName) {
        this.framePosition = 0;
        
        try {
            File file = new File(soundFileName);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            this.clip = AudioSystem.getClip();
            this.clip.open(sound);
        }
        catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("Error audio set");
        }
    }
    
    public void play () {
        this.clip.setFramePosition(0);
        this.clip.start();
        
    }
    
    public void loop () {
        this.clip.setFramePosition(0);
        this.clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop () {
        this.clip.stop();
        this.framePosition = this.clip.getFramePosition();
        
    }
    
    public void close () {
        this.clip.close();
    }
    
    public void resume () {
        this.clip.setFramePosition(framePosition);
        this.clip.start();
    }
    
    public void setVolume (double vol) {
        FloatControl gain = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        float dB = (float)(Math.log(vol) / Math.log(10) * 20);
        gain.setValue(dB);
    }
    
}
