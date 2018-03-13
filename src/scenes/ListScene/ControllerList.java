package scenes.ListScene;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import scenes.DataBase.ShopTable;
import scenes.Main.CurrentUser;

import java.util.ArrayList;

public class ControllerList {

    @FXML
    private ImageView bgImage;

    @FXML
    private Pane shopField;

    @FXML
    private Button testShopBttn;

    @FXML
    private ImageView testShopImg;

    @FXML
    private Pane testShopPn;

    @FXML
    private Label testShopNm;

    @FXML
    private Label testShopAdrs;

    ArrayList<TechShopList> techShopList = new ArrayList<>();

    @FXML
    private void init() {
        bgImage.setImage(new Image("file:C:\\Users\\PDV00\\CourseProject\\FilesFromProject\\TitleImage.png"));
        System.out.println(new CurrentUser().getCURRENT_USER());
    }

    @FXML
    private void setImage(ImageView image, String imageAdds) {
        image.setImage(new Image("file:"+imageAdds));
    }

    @FXML
    public void initialize() {
        init();
    }

    private void fillArray() {
        int count = new ShopTable().dataCount(new CurrentUser().getCURRENT_USER());
    }

}
