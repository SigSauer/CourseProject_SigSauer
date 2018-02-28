package scenes.TitleScene;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTitle extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("title.fxml"));
        Scene titleScene = new Scene(root, 764, 478);
        primaryStage.setTitle("Buyer's Guide");
        primaryStage.setResizable(false);
        primaryStage.setScene(titleScene);
        primaryStage.show();
    }


    public void close() {
        Platform.exit();
    }

    @FXML
    @Override
    public void stop() {
    }

    public static void MTmain(String[] args) {
        launch(args);
    }
}
