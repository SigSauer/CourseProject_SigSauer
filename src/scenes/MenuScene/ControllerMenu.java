package scenes.MenuScene;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import scenes.ChangeScene.MainChange;
import scenes.ListScene.MainList;
import scenes.TitleScene.MainTitle;

public class ControllerMenu {

    @FXML
    private Label messageField;
    @FXML
    private Button toListButton;
    @FXML
    private ImageView bgImage;
    @FXML
    private Button logoutButton;
    @FXML
    private Button toSettingButton;

    @FXML
    private void init() {
        bgImage.setImage(new Image("file:C:\\Users\\PDV00\\CourseProject\\FilesFromProject\\TitleImage.png"));

    }

    @FXML
    public void initialize() {
        init();
    }

    @FXML
    private void LogOut() {
        nextScene(1);
    }

    @FXML
    private void gotoSettings() {
        nextScene(2);
    }

    @FXML
    private void gotoList() {
        nextScene(3);
    }

    @FXML
    private void setMessage(String s) {
        messageField.setText(s);
    }

    @FXML
    private void nextScene(int index) {

        /**
         *  Scene Index:
         * 1 - Title Scene
         * 2 - Change Scene
         * 3 - List Scene
         */

        switch (index) {
            case 1:
                System.out.println("Next Scene: Title Scene");
                try {
                    new MainTitle().start(new Stage());
                    System.out.println("Next Scene: true");
                    Stage s = (Stage) logoutButton.getScene().getWindow();
                    int i = 0;
                    s.close();
                } catch (Exception e) {
                    System.out.println("Next Scene: false");
                }
                break;
            case 2:
                System.out.println("Next Scene: Change Scene");
                try {
                    new MainChange().start(new Stage());
                    System.out.println("Next Scene: true");
                    Stage s = (Stage) toSettingButton.getScene().getWindow();
                    s.close();
                    int i = 0;
                } catch (Exception e) {
                    System.out.println("Next Scene: false");
                }
                break;
            case 3:
                System.out.println("Next Scene: List Scene");
                try {
                    new MainList().start(new Stage());
                    System.out.println("Next Scene: true");
                    Stage s = (Stage) toListButton.getScene().getWindow();
                    s.close();
                    int i = 0;
                } catch (Exception e) {
                    System.out.println("Next Scene: false");
                }
                break;
            default:
                System.err.println("Wrong index");
                break;
        }
    }

}
