package auth;

import DB.DBAgent;
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
        System.out.println("Введите username & password нового пользователя:");
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("USERNAME:");
        var username = bufferedReader.readLine();

        System.out.println("PASSWORD:");
        var password = bufferedReader.readLine();


        if (!checkUsernameExistInDB(username, password)) {
            System.out.println("Такой юзер уже зарегистрирован в базе, выходим из программы");
            System.exit(0);
        }

        var dbAgent = new DBAgent();
        dbAgent.insertCredIntoDB(username, password);

    }

    public boolean checkUsernameExistInDB(String username, String password) {
        return true;

    }

    public String logInToDB() throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        return bufferedReader.readLine();

    }




}
