package scenes.ListScene;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import scenes.AddScene.MainAdd;
import scenes.ChangeScene.MainChange;
import scenes.DataBase.ShopList;
import scenes.DataBase.ShopTable;
import scenes.TitleScene.MainTitle;
import scenes.miniscenes.DeleteScene_unused.MainDelete;

public class ControllerList {

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button toSettingButton;

    @FXML
    private ImageView bgImage;

    @FXML
    private TextArea descField;

    private  ObservableList<ShopList> shops = FXCollections.observableArrayList();

    @FXML
    private TableView<ShopList> table;

    @FXML
    private ImageView selectImage;

    @FXML
    private TableColumn<ShopList, Integer> idCol;

    @FXML
    private TableColumn<ShopList, String> nameCol;

    @FXML
    private TableColumn<ShopList, String> addressCol;

    @FXML
    private TableColumn<ShopList, String> specCol;

    @FXML
    private TableColumn<ShopList, String> ownerCol;

    @FXML
    private TableColumn<ShopList, String> workCol;

    private int selection;

    private static ShopList selectionShop;

    public static ShopList getSelectionShop() {
        return selectionShop;
    }

    public void setSelectionShop(ShopList selectionShop) {
        this.selectionShop = selectionShop;
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
    private void addShop() {
        nextScene(3);
    }

    @FXML
    private void delete_old() throws Exception {
        new MainDelete().start(new Stage());
    }

    @FXML
    private void delete() {
        Button cancelButton = new Button("Cancel");
        Button yesButton = new Button("Yes");

        yesButton.setLayoutX(500);
        cancelButton.setLayoutX(600);


        yesButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            removeShop(selectionShop);
            Stage s = (Stage) yesButton.getScene().getWindow();
            s.close();
        });

        cancelButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Stage s = (Stage) yesButton.getScene().getWindow();
            s.close();
        });

        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(yesButton);
        //secondaryLayout.getChildren().add(cancelButton);

        Scene secondScene = new Scene(secondaryLayout, 230, 100);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Are you sure?");
        newWindow.setScene(secondScene);

        // Set position of second window, related to primary window.
        newWindow.setX(table.getLayoutX()+500);
        newWindow.setY(table.getLayoutX()+200);



        newWindow.show();
    }

    @FXML
    private void nextScene(int index) {

        /**
         *  Scene Index:
         * 1 - Title Scene
         * 2 - Change Scene
         * 3 - Add Scene
         * 4 - Delete Scene (not released)
         * 5 - Edit Scene (not released)
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
                    System.err.println("Next Scene: false");
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
                    System.err.println("Next Scene: false");
                }
                break;
            case 3:
                System.out.println("Next Scene: Add Scene");
                try {
                    new MainAdd().start(new Stage());
                    System.out.println("Next Scene: true");
                    Stage s = (Stage) addButton.getScene().getWindow();
                    s.close();
                } catch (Exception e) {
                    System.err.println("Next Scene: false");
                }
                break;
            case 4:
                System.out.println("Next Scene: Delete Scene");
                try {

                    new MainDelete().start(new Stage());
                    System.out.println("Next Scene: true");
                } catch (Exception e) {
                    System.err.println("Next Scene: false");
                    e.printStackTrace();
                }
                break;
//            case 5:
//                System.out.println("Next Scene: Edit Scene");
//                try {
//                    new MainDelete().start(new Stage());
//                    System.out.println("Next Scene: true");
//                } catch (Exception e) {
//                    System.err.println("Next Scene: false");
//                }
//                break;
            default:
                System.err.println("Wrong index");
                break;
        }
    }

    private void showList() {
        shops.removeAll();
        shops.addAll(new ShopTable().getShopList());
        System.out.println(shops.toString());
        resize(false);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        specCol.setCellValueFactory(new PropertyValueFactory<>("spec"));
        ownerCol.setCellValueFactory(new PropertyValueFactory<>("ownership"));
        workCol.setCellValueFactory(new PropertyValueFactory<>("workHours"));
        table.setItems(shops);
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                selection = table.getSelectionModel().getSelectedIndex();
                active(shops.get(selection));
        });
    }

    private void resize(boolean value) {
        idCol.setResizable(value);
        nameCol.setResizable(value);
        addressCol.setResizable(value);
        specCol.setResizable(value);
        ownerCol.setResizable(value);
        workCol.setResizable(value);
        table.setMouseTransparent(value);
    }

    @FXML
    private void edition() {

    }

    @FXML
    private void active(ShopList sl) {
        System.out.println(sl.toString());
        editButton.setDisable(false);
        deleteButton.setDisable(false);
        selectionShop = sl;
        descField.setText(sl.getDescription());
        selectImage.setImage(new Image("file:"+sl.getImage()));
    }

    @FXML
    public static void removeShop_old() {
        new ShopTable().deleteShop(selectionShop);
    }

    @FXML
    private void removeShop(ShopList sl) {
        new ShopTable().deleteShop(sl);
        init();
    }

    @FXML
    private void cancel() {

    }

    @FXML
    public void init() {
        bgImage.setImage(new Image("file:C:\\Users\\PDV00\\CourseProject\\FilesFromProject\\TitleImage.png"));
        editButton.setDisable(true);
        deleteButton.setDisable(true);
        showList();

    }

    @FXML
    public void initialize() {
        init();
    }

}
