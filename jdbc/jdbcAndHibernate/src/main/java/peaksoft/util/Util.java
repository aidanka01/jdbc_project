package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password = "123456";

    public static Connection connect(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to db successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
