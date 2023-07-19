package com.chandima.edumanagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DAshBoardFormController {
    public AnchorPane contextDashBoard;

    public void profileIconOnAction(MouseEvent mouseEvent) {
    }


    private void setUI(String context) throws IOException {
        Stage stage = (Stage) contextDashBoard.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+context+".fxml"))));
        stage.show();
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        setUI("SignInForm");
    }

    public void studentOnAction(ActionEvent actionEvent) throws IOException {
        setUI("StudentDhasboardForm");
    }
}
