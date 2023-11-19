package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public final class ConnectionManager {

    private static final String PASSWORD_KEY = "db.password";
    private static final String USERNAME_KEY = "db.username";
    private static final String URL_KEY = "db.url";

    static {
        loadDriver();
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private ConnectionManager() {
    }

    public static Connection open() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USERNAME_KEY),
                    PropertiesUtil.get(PASSWORD_KEY)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getPasswordValue() {
        return PropertiesUtil.get(PASSWORD_KEY);
    }

    public static String getUsernameValue() {
        return PropertiesUtil.get(USERNAME_KEY);
    }

    public static String getUrlValue() {
        return PropertiesUtil.get(URL_KEY);
    }
}
