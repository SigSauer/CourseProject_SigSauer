package scenes.MenuScene;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControllerMenu {

    @FXML
    private ImageView bgImage;





    @FXML
    private void init() {
        bgImage.setImage(new Image("file:C:\\Users\\PDV00\\CourseProject\\FilesFromProject\\TitleImage.png"));

    }

    @FXML
    public void initialize() {
        init();
    }

}
