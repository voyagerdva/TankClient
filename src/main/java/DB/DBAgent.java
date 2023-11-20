package DB;

import util.ConnectionManager;

import java.sql.Driver;
import java.sql.SQLException;
import java.sql.Statement;
public class DBAgent {

    private final String SQL_CREATE_DATABASE = """
                CREATE DATABASE tanks;
                """;

    private final String SQL_CREATE_SCHEMA = """
                CREATE Schema IF NOT EXISTS tanks_schema;
                """;

    private final String SQL_CREATE_TABLE = """
                CREATE TABLE IF NOT EXISTS "credentials" (
                    id SERIAL PRIMARY KEY,
                    username TEXT,
                    password TEXT
                );
                """;

    private final String SQL_SELECT = """
            SELECT  id,
                    username,
                    password
            FROM credentials
            WHERE id = ?
            """;

    private final String SQL_INSERT_DEFAULT = """
            INSERT INTO credentials (username, password)
            VALUES ("user1", "password1");
            """;

    private final String SQL_INSERT_CRED = """
            INSERT INTO credentials (username, password)
            VALUES (?,?)
            """;



    //----------------------------------------------------------------------------------------------------

    public void connectionDB() throws SQLException {
        boolean dbExists = false;
        boolean schemaExists = false;
        boolean tableExists = false;

        var driverClass = Driver.class;

        try (var connection = ConnectionManager.open();
             var statement = connection.createStatement()) {
            System.out.println("Подключились к БД tanks");
            System.out.println("user = " + ConnectionManager.getUsernameValue());
            System.out.println("password = " + ConnectionManager.getPasswordValue());
            System.out.println("url = " + ConnectionManager.getUrlValue());
            System.out.println(connection.getTransactionIsolation());
        }
    }


    public void insertCredIntoDB(String username, String password) {
        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(SQL_INSERT_CRED, Statement.RETURN_GENERATED_KEYS)) {

            //set values
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            //execute query
            preparedStatement.executeUpdate();

            System.out.println("Record inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void insertCredIntoDB_DMDEV() {
//        try (var connection = ConnectionManager.open();
//             var preparedStatement = connection.prepareStatement(SQL_INSERT_CRED, Statement.RETURN_GENERATED_KEYS)) {
//            preparedStatement.setString(1, "ticket.getPassengerNo()");
//            preparedStatement.setString(2, "ticket.getPassengerName()");
//
//            preparedStatement.executeUpdate();
//
//            var generatedKeys = preparedStatement.getGeneratedKeys();
//
////            if (generatedKeys.next()) {
////                ticket.setId(generatedKeys.getLong("id"));
////            }
////            return ticket;
//        } catch (SQLException throwables) {
//            throw new DaoException(throwables);
//        }
//    }
}
