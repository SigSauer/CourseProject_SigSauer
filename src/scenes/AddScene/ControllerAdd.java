package scenes.AddScene;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import scenes.ListScene.MainList;

public class ControllerAdd {

    @FXML
    private TextField imageField;

    @FXML
    private Label messageFieldRed;

    @FXML
    private Button backButton;

    @FXML
    private TextField nameField;

    @FXML
    private Button addButton;

    @FXML
    private TextField timeEField;

    @FXML
    private ImageView bgImage;

    @FXML
    private TextField timeBField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField specField;

    @FXML
    private TextField ownerField;



    @FXML
    private void init() {
        bgImage.setImage(new Image("file:C:\\Users\\PDV00\\CourseProject\\FilesFromProject\\TitleImage.png"));
        System.out.println(new CurrentUser().getCURRENT_USER());
    }
    @FXML
    public void initialize() {
        init();
    }

    @FXML
    private void setMessage(String message) {
        messageFieldRed.setText(message);
    }

    @FXML
    private void addShop() {
        if((nameField.getText() != null && !nameField.getText().isEmpty()) &&
                (addressField.getText() != null && !addressField.getText().isEmpty()) &&
                (specField.getText() != null && !specField.getText().isEmpty()) &&
                (ownerField.getText() != null && !ownerField.getText().isEmpty()) &&
                (timeBField.getText() != null && !timeBField.getText().isEmpty()) &&
                (timeEField.getText() != null && !timeEField.getText().isEmpty())) {
            //ShopList sl = new ShopList(nameField.getText(),addressField.getText(),specField.getText(),ownerField.getText(),
              //      timeBField.getText(),timeEField.getText());
        } else{
            System.out.println("Not all fields are fill");
            setMessage("Please, fill all the fields");
        }

    }

    @FXML
    private void back2List() {
        System.out.println("Next Scene: List Scene");
        try {
            new MainList().start(new Stage());
            System.out.println("Next Scene: true");
            Stage s = (Stage) backButton.getScene().getWindow();
            s.close();
        } catch (Exception e) {
            System.out.println("Next Scene: false");
        }
    }

}
