package DB;

import util.ConnectionManager;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBAgent {
    public static void connectionDB() throws SQLException {
//        var driverClass = Driver.class;

        try (var connection = ConnectionManager.open()) {
            System.out.println("Подключились к БД tanks");
            System.out.println(connection.getTransactionIsolation());

        }

    }


}
