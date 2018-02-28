package scenes.RecoveryScene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainRecovery extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("recovery.fxml"));
        Scene menuScene = new Scene(root, 764, 478);
        primaryStage.setTitle("Buyer's Guide");
        primaryStage.setResizable(false);
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }



    @Override
    public void stop() {

    }

    public static void MREmain(String[] args) {
        launch(args);
    }
}
