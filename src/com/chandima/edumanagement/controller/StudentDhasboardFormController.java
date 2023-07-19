package com.chandima.edumanagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentDhasboardFormController {
    public AnchorPane contextStudentDashBoard;

    public void profileIconOnAction(MouseEvent mouseEvent) {
    }

    public void backToDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        setUI("DAshBoardForm");
    }
    private void setUI(String context) throws IOException {
        Stage stage = (Stage) contextStudentDashBoard.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+context+".fxml"))));
        stage.show();
    }
}
