package scenes.DataBase;

import entity.User;
import scenes.TitleScene.ControllerTitle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static scenes.DataBase.Hashing.*;

public class UserTable {
    public boolean check(String username, String password) {
        String query = "SELECT `username`,`password` FROM bgserver.users WHERE \t`username` = \""+username+"\";";
        try {
            Statement st = new DataBaseMain().getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                if(rs.getString("password").equals(new Hashing().getHash(password))) {
                    return true;
                }
            }
            System.out.println("Select users is successful");
        }catch (SQLException e) {
            System.out.println("Failed execution the query");
            new ControllerTitle().setMess("User is not founded");
        }
        return false;
    }

    public void addUser(User nu) {
        String query = "INSERT INTO bgserver.users (`username`,`password`,`s_question`, `s_answer`,`dateOfReg`) \n" +
                "values (\""+nu.getUsername()+"\",\""+nu.getPasswordHash()+"\",\""+nu.getQuestion()+"\",\""+nu.getAnswer()+"\",\""+nu.getDateOfAdding()+"\");";
        try{
            Statement st = new DataBaseMain().getConnection().createStatement();
            st.executeUpdate(query);
            System.out.println("Insert is successful");
        }catch (SQLException ex) {
            System.out.println("Failed execution the query");
        }catch (RuntimeException e) {
            System.out.println("Failed to Runtime work");
        }
    }

    public String[] getSecret(String username) {
        String query = "SELECT `s_question`,`s_answer` FROM bgserver.users WHERE `username` = \"" + username + "\";";
        String result[] = new String[2];
        try {
            Statement st = new DataBaseMain().getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                result[0] = rs.getString("s_question");
                result[1] = rs.getString("s_answer");
            }
            System.out.println("Select secret is successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void changePassword(String username, String newPass) {
        String query = "UPDATE bgserver.users SET `password` = \""+new Hashing().getHash(newPass)+"\" WHERE `username` = \""+username+"\";";
        try{
            Statement st = new DataBaseMain().getConnection().createStatement();
            st.executeUpdate(query);
            System.out.println("Update is successful");
        }catch (SQLException ex) {
            System.out.println("Failed execution the query");
        }catch (RuntimeException e) {
            System.out.println("Failed to Runtime work");
        }
    }

    public void updateUser(String oldUsername, User newUser) {
            String query = "UPDATE bgserver.users SET `username` = \""+newUser.getUsername()+"\", `password` = \""+newUser.getPasswordHash()+"\", " +
                    "`s_question` = \""+newUser.getQuestion()+"\", `s_answer` = \""+newUser.getAnswer()+"\" WHERE `username` = \""+oldUsername+"\";";
        try{
            Statement st = new DataBaseMain().getConnection().createStatement();
            st.executeUpdate(query);
            System.out.println("Update is successful");
            short k = -1;
        }catch (SQLException ex) {
            System.out.println("Failed execution the query");
        }catch (RuntimeException e) {
            System.out.println("Failed to Runtime work");
        }
    }

    public User getUser(String username) {
        User user = new User();
        String query = "SELECT `username`,`password`,`s_question`,`s_answer` FROM bgserver.users WHERE `username` = \"" + username + "\";";
        try {
            Statement st = new DataBaseMain().getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                user.setUsername(rs.getString("username"));
                user.setPasswordHash(rs.getString("password"));
                user.setQuestion(rs.getString("s_question"));
                user.setAnswer(rs.getString("s_answer"));
            }
            System.out.println("Select secret is successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
