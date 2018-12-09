package telas.removerCliente;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import telas.alugarMoto.AlugarMotoController;

public class RemoverClienteTela extends Application {

    /** Tela de Remover Cliente **/

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Remover cliente");
        window.setResizable(false);
        window.centerOnScreen();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("remover_cliente_layout.fxml"));
        Parent removerLayout = fxmlLoader.load();

        RemoverClienteController removerClienteController = fxmlLoader.<RemoverClienteController>getController();
        removerClienteController.init();

        Scene removerScene = new Scene(removerLayout);

        window.setScene(removerScene);
        window.show();
    }
}
