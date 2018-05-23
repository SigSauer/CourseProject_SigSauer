package scenes.TitleScene;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import scenes.DataBase.UserTable;
import scenes.ListScene.MainList;
import scenes.Main.CurrentUser;
import scenes.RecoveryScene.MainRecovery;
import scenes.RegistrationScene.MainRegistration;

public class ControllerTitle {

    @FXML
    private Label messageFieldRed;
    @FXML
    private Label messageFieldGreen;
    @FXML
    private ImageView titleText;
    @FXML
    private PasswordField passField;
    @FXML
    private ImageView titleImage;
    @FXML
    private TextField userField;
    @FXML
    private Button logInButton;
    @FXML
    private Button addButton;
    @FXML
    private Button forgotButton;

    private String username;
    private String password;




    /**
     *  Scene Index:
     * 1 - Menu Scene
     * 2 - Registration Scene
     * 3 - Recovery Scene
     */


    @FXML
    private void init() {
        titleImage.setImage(new Image("file:C:\\Users\\PDV00\\CourseProject\\FilesFromProject\\TitleImage.png"));
        titleText.setImage(new Image("file:C:\\Users\\PDV00\\CourseProject\\FilesFromProject\\TitleText.png"));
    }

    @FXML
    public void initialize() {
        init();
    }

    @FXML
    private void setMessage(String s, boolean it) {
        if (!it) {
            messageFieldGreen.setText("");
            messageFieldRed.setText(s);
        } else {
            messageFieldRed.setText("");
            messageFieldGreen.setText(s);
        }
    }

    public void setMess(String str) {
        setMessage(str,false);
    }

    @FXML
    private void logIn() {
        System.out.println("Logining...");
        if((userField.getText() != null && !userField.getText().isEmpty()) && (passField.getText() != null && !passField.getText().isEmpty())) {
            username = userField.getText();
            password = passField.getText();
            if (new UserTable().check(username, password)) {
                System.out.println("Logining: true");
                System.out.println("Login: " + username + "\nPassword: " + password);
                setMessage("Logining successful", true);
                nextScene(1);
            } else {
                System.err.println("Logining: false");
                setMessage("Inputted wrong values",false);
            }
        }
            else {
            System.err.println("Logining: false");
            setMessage("Please, input correctly",false);
            }

        }

    @FXML
    private void addUser() {
        nextScene(2);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ControllerTitle that = (ControllerTitle) o;

        return passField.equals(that.passField) && userField.equals(that.userField);
    }

    @Override
    public int hashCode() {
        int result = passField.hashCode();
        result = 31 * result + userField.hashCode();
        return result;
    }

    private void nextScene(int si) {

        /**
         *  Scene Index:
         * 1 - List Scene
         * 2 - Registration Scene
         * 3 - Recovery Scene
         */

        switch (si) {
            case 1:
                System.out.println("Next Scene: List Scene");
                try {
                    new MainList().start(new Stage());
                    System.out.println("Next Scene: true");
                    new CurrentUser().addCurrentUser(username);
                    Stage s = (Stage) logInButton.getScene().getWindow();
                    s.close();
                    } catch (Exception e) {
                        System.err.println("Next Scene: false");
                        e.printStackTrace();
                    }
                break;
            case 2:
                System.out.println("Next Scene: Registration Scene");
                try {
                    new MainRegistration().start(new Stage());
                    System.out.println("Next Scene: true");
                    Stage s = (Stage) addButton.getScene().getWindow();
                    s.close();
                } catch (Exception e) {
                    System.err.println("Next Scene: false");
                }
                break;
            case 3:
                System.out.println("Next Scene: Recovery Scene");
                try {
                    new MainRecovery().start(new Stage());
                    System.out.println("Next Scene: true");
                    Stage s = (Stage) forgotButton.getScene().getWindow();
                    s.close();
                } catch (Exception e) {
                    System.err.println("Next Scene: false");
                }
                break;
            default:
                System.err.println("Wrong index");
                break;
        }
    }

    @FXML
    private void forgotPass() {
        nextScene(3);
    }
}
