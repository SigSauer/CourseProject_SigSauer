package scenes.ShopScene_unused;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainChange extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("change.fxml"));
        primaryStage.setTitle("Buyer's Guide");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 764, 478));
        primaryStage.show();
    }

    @Override
    public void stop() {

    }

    public static void MLmain(String[] args) {
        launch(args);
    }
}
