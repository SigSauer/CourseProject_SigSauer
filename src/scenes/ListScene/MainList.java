package scenes.ListScene;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainList extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("list.fxml"));
        Scene listScene = new Scene(root, 764, 478);
        primaryStage.setTitle("Buyer's Guide");
        primaryStage.setResizable(false);
        primaryStage.setScene(listScene);
        primaryStage.show();
    }

    @FXML
    @Override
    public void stop() {
    }

    public static void MLmain(String[] args) {
        launch(args);
    }
}
