package telas.main;

import bancoDeDados.BancoDeDados;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import secao.Tela;

public class LoginTela extends Application {

    /** Tela de login **/

    private Scene loginScene;

    @Override
    public void start(Stage window) throws Exception{
        window.setTitle("Toca da Motoca");
        window.setResizable(false);
        window.centerOnScreen();

        Parent loginLayout = FXMLLoader.load(getClass().getResource("layout/login_layout.fxml"));
        loginScene = new Scene(loginLayout);

        window.setScene(loginScene);
        window.show();
    }

    public static void main(String[] args) {

        BancoDeDados BD = new BancoDeDados();
        launch(args);
    }
}
