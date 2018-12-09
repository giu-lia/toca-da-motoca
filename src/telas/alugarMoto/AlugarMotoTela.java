package telas.alugarMoto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlugarMotoTela extends Application {

    /** Tela de Alugar Moto **/

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Alugar moto");
        window.setResizable(false);
        window.centerOnScreen();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("alugar_moto_layout.fxml"));
        Parent addLayout = fxmlLoader.load();

        AlugarMotoController alugarMotoController = fxmlLoader.<AlugarMotoController>getController();
        alugarMotoController.init();

        Scene alugarScene = new Scene(addLayout);

        window.setScene(alugarScene);
        window.show();
    }
}
