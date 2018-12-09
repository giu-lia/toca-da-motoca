package telas.cadastro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import secao.Tela;

public class CadastroTela extends Application {

    /** Tela de Cadastro **/

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Toca da Motoca");
        window.setResizable(false);
        window.centerOnScreen();

        Parent cadastroLayout = FXMLLoader.load(getClass().getResource("layout/cadastro_layout.fxml"));
        Scene cadastroScene = new Scene(cadastroLayout);

        window.setScene(cadastroScene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
