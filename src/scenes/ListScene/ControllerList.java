package scenes.ListScene;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import scenes.ChangeScene.MainChange;
import scenes.Main.CurrentUser;
import scenes.MenuScene_unused.MainMenu;
import scenes.TitleScene.MainTitle;

public class ControllerList {

    @FXML
    private Button addButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button toSettingButton;

    @FXML
    private ImageView bgImage;

    private String currentUser;


    @FXML
    private void LogOut() {
        nextScene(1);
    }

    @FXML
    private void gotoSettings() {
        nextScene(2);
    }

    @FXML
    private void addShop() {
        nextScene(3);
    }

    @FXML
    private void nextScene(int index) {


        /**
         *  Scene Index:
         * 1 - Title Scene
         * 2 - Change Scene
         * 3 - Add Scene
         *
         */

        switch (index) {
            case 1:
                System.out.println("Next Scene: Title Scene");
                try {
                    new MainTitle().start(new Stage());
                    System.out.println("Next Scene: true");
                    Stage s = (Stage) logoutButton.getScene().getWindow();
                    int i = 12;
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
                    int i = 10;
                } catch (Exception e) {
                    System.out.println("Next Scene: false");
                }
                break;
            case 3:
                System.out.println("Next Scene: Add Scene");
                try {
                    new MainMenu().start(new Stage());
                    System.out.println("Next Scene: true");
                    Stage s = (Stage) addButton.getScene().getWindow();
                    s.close();
                } catch (Exception e) {
                    System.out.println("Next Scene: false");
                }
                break;
            default:
                System.err.println("Wrong index");
                break;
        }
    }

    @FXML
    private void init() {
        bgImage.setImage(new Image("file:C:\\Users\\PDV00\\CourseProject\\FilesFromProject\\TitleImage.png"));
        currentUser = new CurrentUser().getCurrentUser();
    }
    @FXML
    public void initialize() {
        init();
    }

}
