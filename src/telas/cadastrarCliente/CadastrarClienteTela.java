package telas.cadastrarCliente;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CadastrarClienteTela extends Application {

    /** Tela de Cadastro de Cliente **/

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Cadastrar cliente");
        window.setResizable(false);
        window.centerOnScreen();

        Parent cadastrarClienteLayout = FXMLLoader.load(getClass().getResource("cadastrar_cliente_layout.fxml"));
        Scene cadastrarClienteScene = new Scene(cadastrarClienteLayout);

        window.setScene(cadastrarClienteScene);
        window.show();
    }
}
