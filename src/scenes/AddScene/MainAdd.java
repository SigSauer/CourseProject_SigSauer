package scenes.AddScene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainAdd extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("add.fxml"));
        primaryStage.setTitle("Buyer's Guide");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 764, 478));
        primaryStage.show();
    }

    @Override
    public void stop() {

    }

    public static void MAmain(String[] args) {
        launch(args);
    }
}
