package com.example.login_signin_signup_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.Serial;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

public class vsComputerController implements Initializable {

    Random random = new Random();

    ArrayList<Button> buttons;

    AdversarialSearchTicTacToe ticTacToeAI = new AdversarialSearchTicTacToe();

    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    private Button gotohome;

    @FXML
    private Text winnerText;

    private Button restart_button;
    private Button newgame;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));

        buttons.forEach(button -> {
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    public void newgame(ActionEvent event)
    {
        try {
            // Get the current stage
            Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            // Load the new scene
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Tic- Tac- Toe");
            stage.setScene(new Scene(root));

            // Close the current stage
            currentStage.close();

            // Show the new stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void gotohomepage(ActionEvent event) {
        try {
            // Get the current stage
            Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            // Load the new scene
            Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Home Page");
            stage.setScene(new Scene(root));

            // Close the current stage
            currentStage.close();
            //alert.successMessage("Human Move is first");
            // Show the new stage
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean set=false;
    @FXML
    void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        winnerText.setText("Tic-Tac-Toe");
//        restart_button.setDisable(!set);
        pickButton(random.nextInt(9));
    }


    public void resetButton(Button button){
        button.setDisable(false);
        button.setText(" ");
      //  alert.successMessage("AI move is first");
        System.out.println("reset pressed");
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            button.setText("O");
            button.setDisable(true);
            System.out.println("setting button");
            checkIfGameIsOver();
            makeAIMove();
        });
    }

    public void makeAIMove(){
        int move = ticTacToeAI.minMaxDecision(getBoardState());
        pickButton(move);
    }

    private void pickButton(int index) {
        buttons.get(index).setText("X");
        buttons.get(index).setDisable(true);
    }

    public State getBoardState(){
        String[] board = new String[9];

        for (int i = 0; i < buttons.size(); i++) {
            board[i] = buttons.get(i).getText();
        }

        return new State(0,board);
    }

    public void checkIfGameIsOver(){
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> button1.getText() + button2.getText() + button3.getText();
                case 1 -> button4.getText() + button5.getText() + button6.getText();
                case 2 -> button7.getText() + button8.getText() + button9.getText();
                case 3 -> button1.getText() + button5.getText() + button9.getText();
                case 4 -> button3.getText() + button5.getText() + button7.getText();
                case 5 -> button1.getText() + button4.getText() + button7.getText();
                case 6 -> button2.getText() + button5.getText() + button8.getText();
                case 7 -> button3.getText() + button6.getText() + button9.getText();
                default -> null;
            };

            //X winner
            if (line.equals("XXX")) {
                winnerText.setText("AI won!");
            }

            //O winner
            else if (line.equals("OOO")) {
                winnerText.setText("You won!");
            }
        }
    }
}