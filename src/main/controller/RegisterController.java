package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {

    public void backToLoginScene(ActionEvent e) {
        Stage mainWindow = (Stage) ((Node)e.getSource()).getScene().getWindow();

        Parent registerLayout = null;
        try {
            registerLayout = FXMLLoader.load(getClass().getResource("../layout/login_layout.fxml"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Scene registerScene = new Scene(registerLayout, 600, 400);

        mainWindow.setScene(registerScene);
    }

    public void onCadastrarButtonClicked(ActionEvent e){
        // cadastro
        backToLoginScene(e);
    }

}
