package scenes.miniscenes.DeleteScene_unused;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static scenes.ListScene.ControllerList.removeShop_old;

public class ControllerDelete {

    @FXML
    private Button cancelButton;

    @FXML
    private Button yesButton;

    @FXML
    private void yes() {
        removeShop_old();
        Stage s = (Stage) yesButton.getScene().getWindow();
        s.close();
    }

    @FXML
    private void no() {
        Stage s = (Stage) cancelButton.getScene().getWindow();
        s.close();
    }

}
