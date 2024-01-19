package com.example.login_signin_signup_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class signupController implements Initializable {

    @FXML
    private Button btn_login;

    @FXML
    private Button btn_signUp;

    @FXML
    private PasswordField tf_password;

    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_email;
   public void signupandreturntohome() {
        if (tf_username.getText().isEmpty() || tf_password.getText().isEmpty()|| tf_email.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            Connection connect = database.connectDB();

            String selectData = "SELECT * FROM users WHERE username = '"
                    + tf_username.getText() + "'";

            try {
                Statement statement = connect.createStatement();
                ResultSet resultset = statement.executeQuery(selectData);

                if (resultset.next()) {
                    alert.errorMessage(tf_username.getText() + " is already exist");
                }

                else if (tf_password.getText().length() < 4) {
                    alert.errorMessage("Invalid password, at least 4 characters needed");
                } else {
                    String insertData = "INSERT INTO users "
                            + "(username,password,Email) "
                            + "VALUES(?,?,?)";
                    PreparedStatement prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, tf_username.getText());
                    prepare.setString(2, tf_password.getText());
                    prepare.setString(3, tf_email.getText());
                    prepare.executeUpdate();
                    alert.successMessage("Registered successfully!");
                   // btn_signUp.getScene().getWindow().hide();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void gotologinpage() {
        try {
            Parent root =null;
            root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Signup");
            stage.setScene(new Scene(root));
            // stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            btn_login.getScene().getWindow().hide();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
