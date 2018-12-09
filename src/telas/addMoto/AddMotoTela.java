package telas.addMoto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddMotoTela extends Application {

    /** Tela de Adicionar Moto **/

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Adicionar moto");
        window.setResizable(false);
        window.centerOnScreen();

        Parent addLayout = FXMLLoader.load(getClass().getResource("add_moto_layout.fxml"));
        Scene addScene = new Scene(addLayout);

        window.setScene(addScene);
        window.show();
    }
}
