package scenes.DataBase;

import entity.ShopList;
import scenes.Main.CurrentUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ShopTable {
    public void addShop(ShopList sl) {
        String username = new CurrentUser().getCurrentUser();
        String temp = new Hashing().getQuadrupleSlashURL(sl.getImage());
        System.out.println(temp);
        String query = "INSERT INTO bgserver.shops (`username`,`name`,`address`,`image`,`specialization`,`ownership`,`timeBegin`,`timeEnd`,`description`)\n" +
                "VALUES(\""+username+"\",\""+sl.getName()+"\",\""+sl.getAddress()+"\",\""+temp+"\",\""+sl.getSpec()+
                "\", \""+sl.getOwnership()+"\",\""+sl.getTimeBegin()+"\",\""+sl.getTimeEnd()+"\",\""+sl.getDescription()+"\");";
        try{
            Statement st = new DataBaseMain().getConnection().createStatement();
            st.executeUpdate(query);
            System.out.println("Insert is successful");
        }catch (SQLException ex) {
            System.err.println("Failed execution the query");
        }catch (RuntimeException e) {
            System.err.println("Failed to Runtime work");
        }
    }

    public ArrayList<ShopList> getShopList() {
        ArrayList<ShopList> shoplist = new ArrayList<>();
            String username = new CurrentUser().getCurrentUser();
            String query = "SELECT `id`, `name`, `address`,`image`,`specialization`,`ownership`,`timeBegin`,`timeEnd`, `description`" +
                    "FROM bgserver.shops WHERE `username` = \""+username+"\";";
            try {
                Statement st = new DataBaseMain().getConnection().createStatement();
                ResultSet rs = st.executeQuery(query);
                int i = 1;
                while (rs.next()) {
                    ShopList list = new ShopList();
                    list.setId(i);
                    list.setTableId(rs.getInt("id"));
                    list.setName(rs.getString("name"));
                    list.setAddress(rs.getString("address"));
                    list.setImage(rs.getString("image"));
                    list.setSpec(rs.getString("specialization"));
                    list.setOwnership(rs.getString("ownership"));
                    list.setTimeBegin(rs.getString("timeBegin"));
                    list.setTimeEnd(rs.getString("timeEnd"));
                    list.setWorkHours(list.getTimeBegin()+" - "+list.getTimeEnd());
                    list.setDescription(rs.getString("description"));

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


    public void deleteShop(ShopList sl) {
        String username = new CurrentUser().getCurrentUser();
        String query = "DELETE FROM bgserver.shops WHERE `username` = \""+username+"\" AND `id` = "+sl.getTableId()+";";
        try{
            Statement st = new DataBaseMain().getConnection().createStatement();
            st.executeUpdate(query);
            System.out.println("Delete is successful");
        }catch (SQLException ex) {
            System.err.println("Failed execution the query");
        }catch (RuntimeException e) {
            System.err.println("Failed to Runtime work");
        }

    }
}
