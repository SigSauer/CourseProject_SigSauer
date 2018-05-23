package scenes.AddScene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import scenes.DataBase.ShopList;
import scenes.DataBase.ShopTable;
import scenes.ListScene.MainList;

import java.io.File;

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
    private TextArea descField;



    @FXML
    private void init() {
        bgImage.setImage(new Image("file:C:\\Users\\PDV00\\CourseProject\\FilesFromProject\\TitleImage.png"));

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
                ShopList sl = new ShopList(nameField.getText(),addressField.getText(),imageField.getText(), specField.getText(),ownerField.getText(),
                timeBField.getText(),timeEField.getText(),descField.getText());
                new ShopTable().addShop(sl);
                back2List();
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

//    @FXML
//    private void hndlOpenFile(ActionEvent event) {
//        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
//        fileChooser.setTitle("Save Document");//Заголовок диалога
//        FileChooser.ExtensionFilter extFilter =
//                new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");//Расширение
//        fileChooser.getExtensionFilters().add(extFilter);
//        //File file = fileChooser.showSaveDialog(CodeNote.mainStage);//Указываем текущую сцену CodeNote.mainStage
//        if (file != null) {
//            //Save
//            System.out.println("Процесс открытия файла");
//        }
//    }

}
