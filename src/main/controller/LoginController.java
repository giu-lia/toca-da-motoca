package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    public void onCriarUmaContaClicked(ActionEvent e) {
        Stage registerWindow = (Stage) ((Node)e.getSource()).getScene().getWindow();

        Parent registerLayout = null;
        try {
            registerLayout = FXMLLoader.load(getClass().getResource("../layout/register_layout.fxml"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Scene registerScene = new Scene(registerLayout, 600, 400);

        registerWindow.setScene(registerScene);
    }

    public void onLogInButtonClicked(ActionEvent e){
        System.out.println("Logou!");

        // vai p tela principal do prog
    }

}
