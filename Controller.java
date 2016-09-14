package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;

public class Controller {

    /**
     *
     */
    @FXML
    private Button newGame;

    /**
     * Play sound button
     */
    public void playSound()
    {
        //Button button = (Button) e.getSource();
        Sound.playSound();
        //button.setVisible(false);
    }

    /**
     * Change to game scene
     * @throws IOException
     */
    public void switchScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene.fxml"));
        Parent root = loader.load();
        SceneController sceneController = loader.getController();
        sceneController.setProblemTitle(0);
        sceneController.setQuestion(0);
        newGame.getScene().setRoot(root);
    }

    /**
     * Mute/unmute background sound
     */
    public void mute() {
        if (!Main.backgroundMusic.isMute())
            Main.backgroundMusic.setMute(true);
        else
            Main.backgroundMusic.setMute(false);
    }

}
