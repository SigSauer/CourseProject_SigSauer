package scenes.RegistrationScene;

import java.util.Objects;


public class NewUser {
    private String username;
    private String password;
    private String passwordHash;
    private String question;
    private String answer;
    private String dateOfAdding;

    public NewUser() {
    }

    public NewUser(String username, String password,String passwordHash, String question, String answer, String dateOfAdding) {
        this.username = username;
        this.password = password;
        this.passwordHash = passwordHash;
        this.question = question;
        this.answer = answer;
        this.dateOfAdding = dateOfAdding;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDateOfAdding() {
        return dateOfAdding;
    }

    public void setDateOfAdding(String dateOfAdding) {
        this.dateOfAdding = dateOfAdding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewUser newUser = (NewUser) o;
        return Objects.equals(username, newUser.username) &&
                Objects.equals(password, newUser.password) &&
                Objects.equals(question, newUser.question) &&
                Objects.equals(answer, newUser.answer) &&
                Objects.equals(dateOfAdding, newUser.dateOfAdding);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, password, question, answer, dateOfAdding);
    }

    public void show() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "User: " +
                "\nUsername: " + username +
                "\nPassword in Hash: " + passwordHash +
                "\nQuestion: " + question +
                "\nAnswer: " + answer +
                "\nDate of registration: " + dateOfAdding;
    }


}
