package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Scene loginScene;

    @Override
    public void start(Stage mainWindow) throws Exception{

        mainWindow.setTitle("Sisteminha Inc.");
        mainWindow.setResizable(false);

        Parent loginLayout = FXMLLoader.load(getClass().getResource("layout/login_layout.fxml"));
        loginScene = new Scene(loginLayout, 600, 400);

        mainWindow.setScene(loginScene);
        mainWindow.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
