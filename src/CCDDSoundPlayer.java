
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class CCDDSoundPlayer {

    Clip clip;
    public void setFile(int i)
    {
        try{
            switch(i)
            {
                case 0: 
                    AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src/resources/musicOpeningTheme.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(ais);

                    break;

                case 1:
                    ais = AudioSystem.getAudioInputStream(new File("src/resources/sfxButtonPress.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(ais);
                
                    break;

                case 2:
                    ais = AudioSystem.getAudioInputStream(new File("src/resources/CreditsMusicBackground.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(ais);
                    break;
                case 3:
                    ais = AudioSystem.getAudioInputStream(new File("src/resources/SceneOneMusic.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(ais);
                    break;
                case 4:
                    ais = AudioSystem.getAudioInputStream(new File("src/resources/Ending1Music.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(ais);
                    break;

                case 5:
                    ais = AudioSystem.getAudioInputStream(new File("src\\resources\\JassRest.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(ais);

                    break;

                case 6:
                    ais = AudioSystem.getAudioInputStream(new File("src\\resources\\stomachGrowl.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(ais);

                    break;

                case 7:
                    ais = AudioSystem.getAudioInputStream(new File("src\\resources\\romanceMusic1.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(ais);
                    break;

                case 8:
                    ais = AudioSystem.getAudioInputStream(new File("src\\resources\\nightAmbiance.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(ais);
                    break;

                case 9:
                    ais = AudioSystem.getAudioInputStream(new File("src\\resources\\outsideMusic.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(ais);
                    break;

                case 10:
                    ais = AudioSystem.getAudioInputStream(new File("src\\resources\\gerardDeath.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(ais);
                    break;

                case 11:
                    ais = AudioSystem.getAudioInputStream(new File("src\\resources\\LavenderTown.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(ais);
                    break;

                case 12:
                    ais = AudioSystem.getAudioInputStream(new File("src\\resources\\MCDeath.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(ais);
                    break;

                case 13:
                    ais = AudioSystem.getAudioInputStream(new File("src\\resources\\SecretChoice.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(ais);
                    break;

                case 14:
                    ais = AudioSystem.getAudioInputStream(new File("src\\resources\\killedHarry.wav"));
                    clip = AudioSystem.getClip();
                    clip.open(ais);
                    break;
                    
            }
        }
        catch (Exception e)
        {

        }
    }

    public void play()
    {
        clip.start();
    }

    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop()
    {
        clip.stop();
    }

    public void flush()
    {
        clip.flush();
    }
}
