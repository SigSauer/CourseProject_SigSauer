package scenes.EditScene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainEdit extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("edit.fxml"));
        primaryStage.setTitle("Buyer's Guide");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 764, 478));
        primaryStage.show();
    }

    @Override
    public void stop() {

    }

    public static void MEmain(String[] args) {
        launch(args);
    }
}
