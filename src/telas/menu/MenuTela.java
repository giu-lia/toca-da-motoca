package telas.menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuTela extends Application {

    /** Tela de Menu **/

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Toca da Motoca");
        window.setResizable(false);
        window.centerOnScreen();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu_layout.fxml"));
        Parent menuLayout = fxmlLoader.load();

        MenuController menu = fxmlLoader.<MenuController>getController();
        menu.ola();

        Scene menuScene = new Scene(menuLayout);

        window.setScene(menuScene);
        window.show();
    }
}
