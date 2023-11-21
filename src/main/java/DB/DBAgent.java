package DB;

import util.ConnectionManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    private final String SQL_SELECT_USERNAME = """
            SELECT username
            FROM credentials
            WHERE username = ?
            """;


    private final String SQL_INSERT = """
            INSERT INTO "credentials" (username, password)
            VALUES (?,?);
            """;

    private final String SQL_SELECT_USERNAME_PASSWORD = """
            SELECT username, password
            FROM credentials
            WHERE username = ? AND password = ?
            """;


    //----------------------------------------------------------------------------------------------------

    public List<String> selectSql(String username) {
        List<String> result = new ArrayList<>();

        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(SQL_SELECT_USERNAME, Statement.RETURN_GENERATED_KEYS)) {
            System.out.println("we are searching - " + username);
            preparedStatement.setString(1, username);
            var resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(resultSet.getString("username"));
                System.out.println(result);
            }
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String> selectSql(String username, String password) {
        List<String> result = new ArrayList<>();

        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(SQL_SELECT_USERNAME_PASSWORD, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            var resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(resultSet.getString("username"));
                System.out.println(result);
            }
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void insertSql(String username, String password) {
        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            System.out.println("Record inserted successfully\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
