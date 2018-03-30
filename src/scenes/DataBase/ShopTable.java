package scenes.DataBase;

import scenes.ListScene.ShopList;
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

    public ShopList getShopList(String username) {
            String query = "SELECT * FROM bgserver.users WHERE `username` = \""+username+"\";";
            ShopList list = new ShopList();
            try {
                Statement st = new DataBaseMain().getConnection().createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    list.setName(rs.getString("name"));
                    list.setAddress(rs.getString("adress"));
                    list.setImage(rs.getString("image"));
                    list.setSpec(rs.getString("specialization"));
                    list.setOwnership(rs.getString("ownership"));
                    list.setTimeBegin(rs.getString("timeBegin"));
                    list.setTimeEnd(rs.getString("timeEnd"));

                    System.out.println(list);
                }
                System.out.println("Select shop list is successful");
            } catch (SQLException e) {
                System.out.println("Select shop list is bad");
            }
            return list;
    }
}
