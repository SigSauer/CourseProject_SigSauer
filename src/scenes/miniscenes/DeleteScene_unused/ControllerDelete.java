package scenes.miniscenes.DeleteScene_unused;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import scenes.DataBase.ShopTable;
import scenes.ListScene.ControllerList;

import static scenes.ListScene.ControllerList.getSelectionShop;

public class ControllerDelete {



    @FXML
    private Button cancelButton;

    @FXML
    private Button yesButton;

    @FXML
    private void yes() {
        new ShopTable().deleteShop(getSelectionShop());
        new ControllerList().init();
        Stage s = (Stage) yesButton.getScene().getWindow();
        s.close();
    }

    @FXML
    private void no() {
        Stage s = (Stage) cancelButton.getScene().getWindow();
        s.close();
    }

}
