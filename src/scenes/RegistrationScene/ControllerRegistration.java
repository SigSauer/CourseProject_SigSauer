package scenes.RegistrationScene;

import entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import scenes.DataBase.Hashing;
import scenes.DataBase.UserTable;
import scenes.TitleScene.MainTitle;

import java.util.Date;

public class ControllerRegistration {

    @FXML
    private ImageView titleImage;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passField;

    @FXML
    private TextArea questionField;

    @FXML
    private TextField answerField;

    @FXML
    private PasswordField pass2Field;

    @FXML
    private Button backButton;

    @FXML
    private Button regButton;

    @FXML
    private Label messageFieldRed;

    @FXML
    private Label messageFieldGreen;

    /**
     * Scene Index:
     * Only on Title Scene
     */

    @FXML
    private void init() {
        titleImage.setImage(new Image("file:C:\\Users\\PDV00\\CourseProject\\FilesFromProject\\TitleImage.png"));
        System.out.println("Registration scene: ready");
    }

    @FXML
    public void initialize() {
        init();
    }

    @FXML
    private void setMessage(String s, boolean it) {
        if (it) {
            messageFieldRed.setText("");
            messageFieldGreen.setText(s);
        } else {
            messageFieldGreen.setText("");
            messageFieldRed.setText(s);
        }
    }

    @FXML
    private void addNewUser() {
        if ((usernameField.getText() != null && !usernameField.getText().isEmpty()) &&
                (passField.getText() != null && !passField.getText().isEmpty()) &&
                (pass2Field.getText() != null && !pass2Field.getText().isEmpty()) &&
                (questionField.getText() != null && !questionField.getText().isEmpty() &&
                        (answerField.getText() != null && !answerField.getText().isEmpty()))) {
            /*
            check username for uniqueness
             */
            System.out.print("Checking passwords concurrence: ");
            if (!passField.getText().equals(pass2Field.getText())) {
                System.err.println("false");
                setMessage("Your passwords do not match", false);
            } else {
                System.out.println("true");
                System.out.print("Checking passwords length: ");
                if (passField.getText().length() < 8) {
                    System.err.println("false");
                    setMessage("Your password is very short", false);
                } else {
                    if (passField.getText().length() > 16) {
                        System.err.println("false");
                        setMessage("Your password is very long", false);
                    } else {
                        System.out.println("true");
                        System.out.println("Checking answer and question: true");
                        Date date = new Date();
                        User newUser = new User(usernameField.getText(), passField.getText(), new Hashing().getHash(passField.getText()),
                                questionField.getText(), answerField.getText(), date.toString());
                        newUser.show();
                        new UserTable().addUser(newUser);
                        nextScene();
                    }
                }
            }
        } else {
            System.out.println("Not all fields are fill");
            setMessage("Please, fill all the fields", false);
        }
    }

    @FXML
    private void nextScene() {
        System.out.println("Next Scene: Title Scene");
        try {
            new MainTitle().start(new Stage());
            System.out.println("Next Scene: true");
            Stage s = (Stage) backButton.getScene().getWindow();
            s.close();
        } catch (Exception e) {
            System.err.println("Next Scene: false");
        }
    }


}
