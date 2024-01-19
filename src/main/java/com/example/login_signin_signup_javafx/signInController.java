package com.example.login_signin_signup_javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class signInController implements Initializable {

    @FXML
    private Button btn_gotoLogin;
    @FXML
    private CheckBox computer;

    @FXML
    private CheckBox human;
    //this here use for showing alert
    public void goto_login_page() {
        // Show a confirmation dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Logout Confirmation");
        alert.setContentText("Are you sure you want to log out?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // User clicked OK, close the current stage
            Stage currentStage = (Stage) btn_gotoLogin.getScene().getWindow();
            currentStage.close();

            // Open the login page
            openLoginPage();
        }
    }

    private void openLoginPage() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("LOG IN PAGE");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void humanScene()
    {
        Parent root=null;
        try {
            root= FXMLLoader.load(getClass().getResource("vsHuman.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Man vs Man");
            stage.setScene(new Scene(root));
            stage.show();
            human.getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void aiComputer()
    {
        Parent root=null;
        try {
            root= FXMLLoader.load(getClass().getResource("sample.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Man vs Computer");
            stage.setScene(new Scene(root));
            stage.show();
            human.getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
