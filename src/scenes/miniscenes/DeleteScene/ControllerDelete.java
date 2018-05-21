package scenes.miniscenes.DeleteScene;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ControllerDelete  {

    @FXML
    private Button cancelButton;

    @FXML
    private Button yesButton;

    @FXML
    private void yes() {
        Stage s = (Stage) yesButton.getScene().getWindow();
        s.close();
    }

    @FXML
    private void no() {
        Stage s = (Stage) cancelButton.getScene().getWindow();
        s.close();
    }

}
