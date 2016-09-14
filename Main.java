package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main extends Application {

    static Stage mainMenuStage;
    static Parent mainMenuRoot;
    static MediaPlayer backgroundMusic;


    /**
     * Load program
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{

        mainMenuStage = primaryStage;
        mainMenuStage.setTitle("Disney Pop");
        mainMenuRoot = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        loadMainMenu();
    }

    /**
     *
     * @throws IOException
     */
    static void loadMainMenu() throws IOException {
        mainMenuRoot.setId("mainMenuImage");
        mainMenuStage.setScene(new Scene(mainMenuRoot, 600, 400));
        mainMenuStage.show();
        loadBackgroundMusic();
    }

    /**
     *
     */
    static void loadBackgroundMusic() {
        String[] songList = {"audio/the_little_mermaid.mp3", "audio/enchanted.mp3"};
        int randomlySelectedMusicNumber = ((new Random().nextInt(songList.length)));
        System.out.println("Randomlyselectedmusicnumber = " + randomlySelectedMusicNumber);
        Media musicMedia = new Media(new File(songList[randomlySelectedMusicNumber]).toURI().toString());
        backgroundMusic = new MediaPlayer(musicMedia);
        backgroundMusic.setVolume(0.4);
        backgroundMusic.play();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
