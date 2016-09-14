package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Optional;


public class SceneController {
    @FXML
    private Label problemTitle;
    @FXML
    private Label problemQuestion;

    /**
     *
     * @param number
     */
    public void setProblemTitle(int number)
    {
        problemTitle.setText(Problem.problems[number]);
    }

    /**
     *
     * @param number question reference number
     */
    public void setQuestion(int number)
    {
        problemQuestion.setText(Problem.problemQuestions[number]);
    }

    /**
     * quit method returns user to main menu
     * @throws IOException
     */
    public void quit() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Return to the main menu?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            sample.Main.loadMainMenu();
        }
    }



}
