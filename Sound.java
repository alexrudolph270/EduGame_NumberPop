package sample;

import javafx.scene.media.*;
import java.io.File;

/**
 * Created by zoltan.batoczki663 on 9/7/16.
 */
public class Sound {
    //file name/location
    private static final String BUBBLE_POP = "audio/bubble-pop.mp3";

    /**
     *
     */
    public static void playSound(){
        Media sound = new Media(new File(BUBBLE_POP).toURI().toString());
        MediaPlayer mediaPLayer = new MediaPlayer(sound);
        mediaPLayer.play();
    }
}
