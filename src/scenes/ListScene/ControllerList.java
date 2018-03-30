package scenes.ListScene;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import scenes.MenuScene.MainMenu;

public class ControllerList {

    @FXML
    private Button backButton;

    @FXML
    private Button addButton;

    @FXML
    private ImageView bgImage;

    private String USER;

    public String getUser() {
        return USER;
    }

    @FXML
    private void back2Menu() {
        System.out.println("Next Scene: Menu Scene");
        try {
            new MainMenu().start(new Stage());
            System.out.println("Next Scene: true");
            Stage s = (Stage) backButton.getScene().getWindow();
            s.close();
            int y;
        } catch (Exception e) {
            System.out.println("Next Scene: false");
        }
    }

    @FXML
    private void addShop() {
        System.out.println("Next Scene: Add Scene");
        try {
            new MainMenu().start(new Stage());
            System.out.println("Next Scene: true");
            Stage s = (Stage) backButton.getScene().getWindow();
            s.close();
        } catch (Exception e) {
            System.out.println("Next Scene: false");
        }
    }

    @FXML
    private void init() {
        bgImage.setImage(new Image("file:C:\\Users\\PDV00\\CourseProject\\FilesFromProject\\TitleImage.png"));
    }
    @FXML
    public void initialize() {
        init();
    }

}
