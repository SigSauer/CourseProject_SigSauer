package scenes.ListScene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TechShopList {
    private Button shopButton;
    private ImageView shopImage;
    private Pane shopPane;
    private Label shopName;
    private Label shopAddress;

    public TechShopList(Button shopButton, ImageView shopImage, Pane shopPane, Label shopName, Label shopAddress) {
        this.shopButton = shopButton;
        this.shopImage = shopImage;
        this.shopPane = shopPane;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
    }

    public TechShopList() {
    }

    public Button getShopButton() {
        return shopButton;
    }

    public void setShopButton(Button shopButton) {
        this.shopButton = shopButton;
    }

    public ImageView getShopImage() {
        return shopImage;
    }

    public void setShopImage(ImageView shopImage) {
        this.shopImage = shopImage;
    }

    public Pane getShopPane() {
        return shopPane;
    }

    public void setShopPane(Pane shopPane) {
        this.shopPane = shopPane;
    }

    public Label getShopName() {
        return shopName;
    }

    public void setShopName(Label shopName) {
        this.shopName = shopName;
    }

    public Label getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(Label shopAddress) {
        this.shopAddress = shopAddress;
    }
}
