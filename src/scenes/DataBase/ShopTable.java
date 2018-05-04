package scenes.DataBase;

import scenes.ListScene.ShopList;
import scenes.RegistrationScene.NewUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
            System.err.println("Failed execution the query");
        }catch (RuntimeException e) {
            System.err.println("Failed to Runtime work");
        }
    }

    public ArrayList<ShopList> getShopList(String username) {
        ArrayList<ShopList> shoplist = new ArrayList<>();

            String query = "SELECT `id`, `name`, `address`,`image`,`specialization`,`ownership`,`timeBegin`,`timeEnd` " +
                    "FROM bgserver.shops WHERE `username` = \""+username+"\";";
            ShopList list = new ShopList();
            try {
                Statement st = new DataBaseMain().getConnection().createStatement();
                ResultSet rs = st.executeQuery(query);
                int i = 1;
                while (rs.next()) {
                    list.setId(i);
                    list.setName(rs.getString("name"));
                    list.setAddress(rs.getString("address"));
                    list.setImage(rs.getString("image"));
                    list.setSpec(rs.getString("specialization"));
                    list.setOwnership(rs.getString("ownership"));
                    list.setTimeBegin(rs.getString("timeBegin"));
                    list.setTimeEnd(rs.getString("timeEnd"));
                    list.setWorkHours(list.getTimeBegin()+" - "+list.getTimeEnd());

                    System.out.println(list.toString());
                    shoplist.add(list);
                    i++;
                }
                System.out.println("Select shop list is successful");
            } catch (SQLException e) {
                System.err.println("Select shop list is bad");
            }
            return shoplist;
    }
}
