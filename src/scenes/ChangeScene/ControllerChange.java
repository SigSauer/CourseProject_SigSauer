package scenes.ChangeScene;

import entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import scenes.DataBase.Hashing;
import scenes.DataBase.UserTable;
import scenes.Main.CurrentUser;

import java.util.Date;

public class ControllerChange {

    User currentUser;

    @FXML
    private ImageView bgImage;

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
    private Label messageFieldRed;

    @FXML
    private Label messageFieldGreen;


    @FXML
    private Button saveButton;

    @FXML
    private void save() {
        User newUser = currentUser;
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
                setMessage("Your passwords do not match",false);
            } else {
                System.out.println("true");
                System.out.print("Checking passwords length: ");
                if (passField.getText().length() < 8) {
                    System.err.println("false");
                    setMessage("Your password is very short",false);
                } else {
                    if (passField.getText().length() > 16) {
                        System.err.println("false");
                        setMessage("Your password is very long",false);
                    } else {
                        System.out.println("true");
                        System.out.println("Checking answer and question: true");
                        newUser.setUsername(usernameField.getText());
                        newUser.setPasswordHash(new Hashing().getHash(passField.getText()));
                        newUser.setQuestion(questionField.getText());
                        newUser.setAnswer(answerField.getText());
                        if(newUser.equals(currentUser)) {
                            setMessage("Change is not successful",false);
                        }else {
                        }
                    }
                }
            }
        } else {
            System.out.println("Not all fields are fill");
            setMessage("Please, fill all the fields",false);
        }
    }

    @FXML
    private void setMessage(String massage, boolean charact) {
        if (!charact) {
            messageFieldGreen.setText("");
            messageFieldRed.setText(massage);
            int q;
        } else {
            messageFieldRed.setText("");
            messageFieldGreen.setText(massage);
        }
    }





    @FXML
    private void init() {
        bgImage.setImage(new Image("file:C:\\Users\\PDV00\\CourseProject\\FilesFromProject\\TitleImage.png"));
        currentUser = new UserTable().getUser(new CurrentUser().getCurrentUser());

    }

    @FXML
    public void initialize() {
        init();
    }

}
