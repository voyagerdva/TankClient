package auth;

import util.ConnectionManager;

import java.io.*;
import java.sql.SQLException;
import java.sql.Statement;

public class Registration {

    public int loginOrRegistration() throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("Введите:\n1 - регистрация новой учетки\n2 - залогиниться под существующим именем");
        String choice = bufferedReader.readLine(); //читаем строку с клавиатуры
        return Integer.parseInt(choice);
    }



    public void addNewUserToDB() throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        var username = bufferedReader.readLine();

        if (checkUsernameExistInDB(username)) {
            System.out.println("Такой юзер уже зарегистрирован в базе");
            System.exit(0);
        }

        insert();

    }

    private void insert() {
        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, ticket.getPassengerNo());
            preparedStatement.setString(2, ticket.getPassengerName());
            preparedStatement.setLong(3, ticket.getFlight().id());
            preparedStatement.setString(4, ticket.getSeatNo());
            preparedStatement.setBigDecimal(5, ticket.getCost());

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

    public boolean checkUsernameExistInDB(String username) {
        return true;

    }

    public String logIn() throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        return bufferedReader.readLine();

    }




}
