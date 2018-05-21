package scenes.miniscenes.DeleteScene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainDelete extends Application{

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("delete.fxml"));
        primaryStage.setTitle("Buyer's Guide");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 228, 127));
        primaryStage.show();
    }


    public static void MDmain(String[] args) {
        launch(args);
    }
}
