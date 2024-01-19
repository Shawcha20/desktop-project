package com.example.login_signin_signup_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button btn_login;

    @FXML
    private Button create_account;

    @FXML
    private Hyperlink loginForgotPassword;

    @FXML
    private CheckBox loginShowPassword;

    @FXML
    private PasswordField passf_password;

    @FXML
    private TextField tf_username;

    private alert alert = new alert();
    private Connection connect;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void login() {
        if (tf_username.getText().isEmpty() || passf_password.getText().isEmpty()) {
            alert.errorMessage("Fill in the blanks");
        } else {
            String selectdata = "SELECT * FROM users WHERE username=? AND password=?";
            try {
                connect = database.connectDB();
                preparedStatement = connect.prepareStatement(selectdata);
                preparedStatement.setString(1, tf_username.getText());
                preparedStatement.setString(2, passf_password.getText());
               // preparedStatement.setString(3, tf_username.getText());

                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    // The user is valid, open the home page
                    Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Home Page");
                    stage.setScene(new Scene(root));
                    stage.show();

                    // Close the login window
                    btn_login.getScene().getWindow().hide();
                } else {
                    // The user is not valid, show an error message
                    alert.errorMessage("Invalid username or password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    // Close the resources (result set, statement, connection)
                    if (resultSet != null) resultSet.close();
                    if (preparedStatement != null) preparedStatement.close();
                    if (connect != null) connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @FXML
    public void createaccount() {
        // Your create account logic here
        // Change the scene accordingly
        changeScene("signup.fxml");
    }

    private void changeScene(String fxmlFile) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Stage stage = new Stage();
            stage.setTitle("Home Page");
            stage.setScene(new Scene(root));
            stage.show();
            btn_login.getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLoginKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            login();
        }
    }

    @FXML
    private void handleCreateAccountKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            createaccount();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Add listeners for Enter key press events
        tf_username.setOnKeyPressed(this::handleLoginKeyPressed);
        passf_password.setOnKeyPressed(this::handleLoginKeyPressed);
        create_account.setOnKeyPressed(this::handleCreateAccountKeyPressed);
    }
}
