package scenes.DataBase;

import scenes.RegistrationScene.NewUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShopTable {
    public void addShop(NewUser nu) {
        String query = "INSERT INTO bgserver.users (`username`,`password`,`s_question`, `s_answer`,`dateOfReg`) \n" +
                "values (\""+nu.getUsername()+"\",\""+nu.getPasswordHash()+"\",\""+nu.getQuestion()+"\",\""+nu.getAnswer()+"\",\""+nu.getDateOfAdding()+"\");";
        try{
            Statement st = new DataBaseMain().getConnection().createStatement();
            st.executeUpdate(query);
            System.out.println("Insert is successful");
        }catch (SQLException ex) {
            int i;
            System.out.println("Failed execution the query");
        }catch (RuntimeException e) {
            System.out.println("Failed to Runtime work");
        }
    }

    public int dataCount(String username) {
            String query = "SELECT COUNT(*) FROM bgserver.users WHERE `username` = \""+username+"\";";
            int result = 0;
            try {
                Statement st = new DataBaseMain().getConnection().createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    result = rs.getInt("COUNT(*)");
                }
                System.out.println("Select secret is successful");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
    }
}
