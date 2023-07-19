package com.chandima.edumanagement.controller;

import com.chandima.edumanagement.database.Database;
import com.chandima.edumanagement.model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class SignInFormController {
    public TextField txtEmail;
    public PasswordField txtPassword;
    public AnchorPane contextSignIn;

    public void forgotPasswordOnAction(ActionEvent actionEvent) {
    }

    public void logInOnAction(ActionEvent actionEvent) throws IOException {
        String email = txtEmail.getText().toLowerCase().trim();
        String password = txtPassword.getText().trim();

        // Check email is already exists,
        for (Users user : Database.usersTable) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password)) {
                    System.out.println(user.toString());
                    new Alert(Alert.AlertType.CONFIRMATION, "Successfully logged in!").show();
                    setUI("DAshBoardForm");
                    return;
                } else {
                    new Alert(Alert.AlertType.WARNING, "Wrong email or password").show();
                    return;
                }
            }
        }
        new Alert(Alert.AlertType.ERROR,"Not found user").show();
    }

    public void createAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUI("SignUpForm");
    }

    private void setUI(String context) throws IOException {
        Stage stage = (Stage) contextSignIn.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + context + ".fxml"))));
        stage.show();

    }
}
