package DB;

import util.ConnectionManager;

import java.sql.Driver;
import java.sql.SQLException;
import java.sql.Statement;
public class DBAgent {


    private static final String CREATE_DATABASE_SQL = """
                CREATE DATABASE tanks;
                """;

    private static final String CREATE_SCHEMA_SQL = """
                CREATE Schema IF NOT EXISTS tanks_schema;
                """;

    private static final String CREATE_TABLE_SQL = """
                CREATE TABLE IF NOT EXISTS auth_user (
                    id SERIAL PRIMARY KEY,
                    username TEXT,
                    password TEXT
                );
                """;

    private static final String INSERT_SQL = """
            INSERT INTO tanks (username, password) 
            VALUES (?, ?);
            """;

    private static final String FIND_BY_ID_SQL = """
            SELECT  id,
                    username,
                    password
            FROM tanks
            WHERE id = ?
            """;

    public static void connectionDB() throws SQLException {
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

            var executeResult = statement.execute(CREATE_SCHEMA_SQL);
            System.out.println(executeResult);

            executeResult = statement.execute(CREATE_SCHEMA_SQL);
            System.out.println(executeResult);
        }



    }

    public static void insertUsername() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, ticket.getPassengerNo());
            preparedStatement.setString(2, ticket.getPassengerName());

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                ticket.setId(generatedKeys.getLong("id"));
            }
            return ticket;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

}
