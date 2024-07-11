package resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfiguracionBaseDeDatos {
    private static final String URL = "mysql://root:vjPwlmiNZwTGRXSCsWvvQeZatsgoOiSm@mysql.railway.internal:3306/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "vjPwlmiNZwTGRXSCsWvvQeZatsgoOiSm";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
