package com.example.login_signin_signup_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class vsHumanController implements Initializable {

    @FXML
    private Label ScoreOfX;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button logOut;

    @FXML
    private Button newgame;

    @FXML
    private Button reset;


    @FXML
    private Label lbl_playerO;

    @FXML
    private Label lbl_playerX;
    @FXML
    private Label scoreOfO;
    private String startGame="X";
    private int xcount=0;
    private int ocount=0;
    boolean checker=true;
    public void reset()
    {
        btn1.setText(" ");
        btn2.setText(" ");
        btn3.setText(" ");
        btn4.setText(" ");
        btn5.setText(" ");
        btn6.setText(" ");
        btn7.setText(" ");
        btn8.setText(" ");
        btn9.setText(" ");
        setresetStyle(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9);
        alert.successMessage("Reset Done");
    }
    public void newGame()
    {
        btn1.setText(" ");
        btn2.setText(" ");
        btn3.setText(" ");
        btn4.setText(" ");
        btn5.setText(" ");
        btn6.setText(" ");
        btn7.setText(" ");
        btn8.setText(" ");
        btn9.setText(" ");
        ScoreOfX.setText("O");
        scoreOfO.setText("O");
        setresetStyle(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9);
        alert.successMessage("New Game Start");
    }
    public void goto_login_page() {
        // Show a confirmation dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Game Exit Confirmation");
        alert.setContentText("Are you sure to go Home Page?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // User clicked OK, close the current stage
            Stage currentStage = (Stage) logOut.getScene().getWindow();
            currentStage.close();

            // Open the login page
            openLoginPage();
        }
    }

    private void openLoginPage() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Home Page");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void gameScore()
    {
        scoreOfO.setText(String.valueOf(ocount));
        ScoreOfX.setText(String.valueOf(xcount));
    }
    public void choose_a_player()
    {
        if(startGame.equalsIgnoreCase("x"))
        {
            startGame="O";
        }
        else {
            startGame="X";
        }
    }
    private void WinningGame()
    {
        String b1= btn1.getText();
        String b2= btn2.getText();
        String b3= btn3.getText();
        String b4= btn4.getText();
        String b5= btn5.getText();
        String b6= btn6.getText();
        String b7= btn7.getText();
        String b8= btn8.getText();
        String b9= btn9.getText();
// 1x
        if (b1.equals("X") && b2.equals("X") && b3.equals("X")) {
            xcount++;
            alert.successMessage("Player X is won this Round");
            setWinningStyle(btn1, btn2, btn3);
            gameScore();
        }
        // 2x
        if (b4.equals("X") && b5.equals("X") && b6.equals("X")) {
            xcount++;
            alert.successMessage("Player X is won this Round");
            setWinningStyle(btn4, btn5, btn6);
            gameScore();
        }
        // 3x
        if (b7.equals("X") && b8.equals("X") && b9.equals("X")) {
            xcount++;
            alert.successMessage("Player X is won this Round");
            setWinningStyle(btn7, btn8, btn9);
            gameScore();
        }
        // \x
        if (b1.equals("X") && b5.equals("X") && b9.equals("X")) {
            xcount++;
            alert.successMessage("Player X is won this Round");
            setWinningStyle(btn1, btn5, btn9);
            gameScore();
        }
        // /x
        if (b3.equals("X") && b5.equals("X") && b7.equals("X")) {
            xcount++;
            alert.successMessage("Player X is won this Round");
            setWinningStyle(btn3, btn5, btn7);
            gameScore();
        }
        // |x
        if (b1.equals("X") && b4.equals("X") && b7.equals("X")) {
            xcount++;
            alert.successMessage("Player X is won this Round");
            setWinningStyle(btn1, btn4, btn7);
            gameScore();
        }
        // ||x
        if (b2.equals("X") && b5.equals("X") && b8.equals("X")) {
            xcount++;
            alert.successMessage("Player X is won this Round");
            setWinningStyle(btn2, btn5, btn8);
            gameScore();
        }
        // |||x
        if (b3.equals("X") && b6.equals("X") && b9.equals("X")) {
            xcount++;
            alert.successMessage("Player X is won this Round");
            setWinningStyle(btn3, btn6, btn9);
            gameScore();
        }

        //1o
       if((b1=="O")&& (b2=="O")&& (b3=="O"))
        {
            ocount++;
            alert.successMessage("Player O is won this Round");
            setWinningStyle(btn1,btn2,btn3);
            gameScore();
        }
        //20
      if((b4=="O")&& (b5=="O")&& (b6=="O"))
        {
            ocount++;
            alert.successMessage("Player O is won this Round");
            setWinningStyle(btn4,btn5,btn6);
            gameScore();
        }
        //3o
        if((b7=="O")&& (b8=="O")&& (b9=="O"))
        {
            ocount++;
            alert.successMessage("Player O is won this Round");
            setWinningStyle(btn7,btn8,btn9);
            gameScore();
        }
        // \o 4
       if((b1=="O")&& (b5=="O")&& (b9=="O"))
        {
            ocount++;
            alert.successMessage("Player O is won this Round");
            setWinningStyle(btn1,btn5,btn9);
            gameScore();
        }
        // /o 5
        if((b7=="O")&& (b5=="O")&& (b3=="O"))
        {
            ocount++;
            alert.successMessage("Player O is won this Round");
            setWinningStyle(btn7,btn5,btn3);
            gameScore();
        }
        // |o 6
        if((b1=="O")&& (b4=="O")&& (b7=="O"))
        {
            ocount++;
            alert.successMessage("Player O is won this Round");
            setWinningStyle(btn1,btn4,btn7);
            gameScore();
        }
        // ||o 7
        if((b2=="O")&& (b5=="O")&& (b8=="O"))
        {
            ocount++;
            alert.successMessage("Player O is won this Round");
            setWinningStyle(btn2,btn5,btn8);
            gameScore();
        }
        // |||o 8
         if((b3=="O")&& (b6=="O")&& (b9=="O"))
        {
            ocount++;
            alert.successMessage("Player O is won this Round");
            setWinningStyle(btn3,btn6,btn9);
            gameScore();
        }
    }
    // Method to set the winning style for buttons
    private void setWinningStyle(Button... buttons) {
        for (Button button : buttons) {
            button.setStyle("-fx-background-color: #ff09;");
        }
    }
    private void setresetStyle(Button... buttons) {
        for (Button button : buttons) {
            button.setStyle("-fx-background-color: #FFFF;");
        }
    }
  public void func1()
    {
            btn1.setText(startGame);
            if(startGame.equalsIgnoreCase("X"))
            {
                checker=false;
            }
            else {
                checker=true;
            }
        choose_a_player();
        WinningGame();
    }
    public void func2()
    {
        btn2.setText(startGame);
        if(startGame.equalsIgnoreCase("X"))
        {
            checker=false;
        }
        else {
            checker=true;
        }
        choose_a_player();
        WinningGame();
    }
    public void func3()
    {
        btn3.setText(startGame);
        if(startGame.equalsIgnoreCase("X"))
        {
            checker=false;
        }
        else {
            checker=true;
        }
        choose_a_player();
        WinningGame();
    }
    public void func4()
    {
        btn4.setText(startGame);
        if(startGame.equalsIgnoreCase("X"))
        {
            checker=false;
        }
        else {
            checker=true;
        }
        choose_a_player();
        WinningGame();
    }
    public void func5()
    {
        btn5.setText(startGame);
        if(startGame.equalsIgnoreCase("X"))
        {
            checker=false;
        }
        else {
            checker=true;
        }
        choose_a_player();
        WinningGame();
    }
    public void func6()
    {
        btn6.setText(startGame);
        if(startGame.equalsIgnoreCase("X"))
        {
            checker=false;
        }
        else {
            checker=true;
        }
        choose_a_player();
        WinningGame();
    }
    public void func7()
    {
        btn7.setText(startGame);
        if(startGame.equalsIgnoreCase("X"))
        {
            checker=false;
        }
        else {
            checker=true;
        }
        choose_a_player();
        WinningGame();
    }
    public void func8()
    {
        btn8.setText(startGame);
        if(startGame.equalsIgnoreCase("X"))
        {
            checker=false;
        }
        else {
            checker=true;
        }
        choose_a_player();
        WinningGame();
    }
    public void func9()
    {
        btn9.setText(startGame);
        if(startGame.equalsIgnoreCase("X"))
        {
            checker=false;
        }
        else {
            checker=true;
        }
        choose_a_player();
        WinningGame();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
