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

public class SignUpFormController {
    public TextField txtFirstName;
    public PasswordField txtPassword;
    public TextField txtEmail;
    public TextField txtLastName;
    public AnchorPane contextRegister;

    public void signUpOnAction(ActionEvent actionEvent) throws IOException {
        String firstName = txtFirstName.getText().trim();
        String lastName = txtLastName.getText().trim();
        String email = txtEmail.getText().toLowerCase().trim();
        String password = txtPassword.getText();

        Database.usersTable.add(
                new Users(firstName, lastName, email, password)
        );

        for (Users users : Database.usersTable) {
            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Enter all fields!!!").show();
                return;

            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Successfully created new account!").show();
                setUI("SignInForm");
                return;


            }
        }


    }

    public void signInOnAction(ActionEvent actionEvent) throws IOException {
        setUI("SignInForm");
    }

    private void setUI(String context) throws IOException {
        Stage stage = (Stage) contextRegister.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + context + ".fxml"))));
        stage.show();
    }

}
