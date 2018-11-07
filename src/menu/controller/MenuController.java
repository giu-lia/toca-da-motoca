package menu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    public void onAlugarVeiculoButtonClicked(ActionEvent e){
        Stage aluguelWindow = new Stage();
        aluguelWindow.setTitle("Alugar veículo");
        aluguelWindow.setResizable(false);

        Parent aluguelLayout = null;
        try {
            aluguelLayout = FXMLLoader.load(getClass().getResource("../../aluguel/layout/aluguel_layout.fxml"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Scene aluguelScene = new Scene(aluguelLayout, 600, 400);

        aluguelWindow.setScene(aluguelScene);
        aluguelWindow.show();
    }

    public void onCadastrarVeiculoButtonClicked(ActionEvent e){

    }

    public void onEditarVeiculoButtonClicked(ActionEvent e){

    }

    public void onFecharContaButtonClicked(ActionEvent e){

    }
}

