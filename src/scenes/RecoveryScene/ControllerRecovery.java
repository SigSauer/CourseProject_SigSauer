package scenes.RecoveryScene;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import scenes.DataBase.UserTable;
import scenes.TitleScene.MainTitle;

public class ControllerRecovery {

    @FXML
    private TextField usernameField;
    @FXML
    private TextField newpassField;
    @FXML
    private TextArea questionField;
    @FXML
    private TextField answerField;
    @FXML
    private Label messageField;
    @FXML
    private Button answerButton;
    @FXML
    private TextField newpass2Field;
    @FXML
    private ImageView bgImage;
    @FXML
    private Label pasLabel;
    @FXML
    private Label pas2Label;
    @FXML
    private Button getQuestionButton;
    @FXML
    private Button passwordButton;

    private String username;
    private String newPassword;
    private String question;
    private String answer;

    @FXML
    private void init() {
        bgImage.setImage(new Image("file:C:\\Users\\PDV00\\CourseProject\\FilesFromProject\\TitleImage.png"));
        passwordVisible(false);
    }

    @FXML
    public void initialize() {
        init();
    }

    @FXML
    private void setMessage(String s) {
        messageField.setText(s);
    }

    @FXML
    private void getQuestion() {
        username = usernameField.getText();
        String[] res = new UserTable().getSecret(username);
        question = res[0];
        answer = res[1];
        questionField.setText(question);
    }

    @FXML
    private boolean checkAnswer() {
        if(answerField.getText().equals(answer)) {
            passwordVisible(true);
            return true;
        }
        else {
            setMessage("Wrong answer");
            return false;
        }
    }

    @FXML
    private void passwordVisible(boolean b) {
        pasLabel.setVisible(b);
        pas2Label.setVisible(b);
        passwordButton.setVisible(b);
        newpassField.setVisible(b);
        newpass2Field.setVisible(b);
    }

    @FXML
    private void newPassword() {
        if ((newpassField.getText() != null && !newpassField.getText().isEmpty()) &&
                (newpass2Field.getText() != null && !newpass2Field.getText().isEmpty())) {
            /*
            check username for uniqueness
             */
            System.out.print("Checking passwords concurrence: ");
            if (!newpassField.getText().equals(newpass2Field.getText())) {
                System.out.println("false");
                setMessage("Your passwords do not match");
            } else {
                System.out.println("true");
                System.out.print("Checking passwords length: ");
                if (newpassField.getText().length() < 8) {
                    System.out.println("false");
                    setMessage("Your password is very short");
                } else {
                    if (newpassField.getText().length() > 16) {
                        System.out.println("false");
                        setMessage("Your password is very long");
                    } else {
                        System.out.println("true");
                        System.out.println("Checking answer and question: true");
                        newPassword = newpassField.getText();
                        new UserTable().changePassword(username, newPassword);
                        System.out.println("Next Scene: Title Scene");
                        try {
                            new MainTitle().start(new Stage());
                            System.out.println("Next Scene: true");
                            Stage s = (Stage) passwordButton.getScene().getWindow();
                            s.close();
                            int i;
                        } catch (Exception e) {
                            System.out.println("Next Scene: false");
                        }
                    }
                }
            }
        } else {
            System.out.println("Not all fields are fill");
            setMessage("Please, fill all the fields");
        }
    }



}
