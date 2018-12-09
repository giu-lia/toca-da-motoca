package telas.removerMoto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import telas.removerCliente.RemoverClienteController;

public class RemoverMotoTela extends Application {

    /** Tela de Remover Moto **/

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Remover moto");
        window.setResizable(false);
        window.centerOnScreen();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("remover_moto_layout.fxml"));
        Parent removerLayout = fxmlLoader.load();

        RemoverMotoController removerMotoController = fxmlLoader.<RemoverMotoController>getController();
        removerMotoController.init();

        Scene removerScene = new Scene(removerLayout);

        window.setScene(removerScene);
        window.show();
    }
}
