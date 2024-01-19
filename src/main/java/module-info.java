module com.example.login_signin_signup_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.login_signin_signup_javafx to javafx.fxml;
    exports com.example.login_signin_signup_javafx;
}