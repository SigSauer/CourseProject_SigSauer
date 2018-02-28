package scenes.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseMain {
    private final String HOST  = "jdbc:mysql://localhost/mysql?verifyServerCertificate=true&useSSL=true";
    private final String ADMINUSER = "root";
    private final String ADMINPASS = "root";
    private Connection connection;

    public DataBaseMain() {
        try {
            this.connection = DriverManager.getConnection(HOST,ADMINUSER,ADMINPASS);
            System.out.println("Data Base: Connection: true ");
        }catch (SQLException ex) {
            System.out.println("Data Base: Connection: false ");
        }
    }

    public Connection getConnection() {
        return this.connection;
    }



}
