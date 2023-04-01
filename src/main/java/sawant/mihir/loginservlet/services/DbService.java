package sawant.mihir.loginservlet.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbService {
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "toor";

    public static Connection getMysqlConnection()  {
        try{
                return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/company?user=%s&password=%s".formatted(USER_NAME, PASSWORD));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       return null;
    }
}
