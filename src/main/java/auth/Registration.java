package auth;

import DB.DBAgent;

import java.io.*;

public class Registration {
    public int loginOrRegistration() throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("Type:\n1 - new account registration\n2 - logIn by exising name");
        String choice = bufferedReader.readLine(); //читаем строку с клавиатуры
        return Integer.parseInt(choice);
    }



    public boolean addNewUserToDB() throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("Type new username & password:");
        System.out.println("USERNAME:");
        var username = bufferedReader.readLine();

        System.out.println("PASSWORD:");
        var password = bufferedReader.readLine();


        if (checkUsernameExistInDB(username)) {
            System.out.println("Sorry :-((((   This username exists in DB already. The application will be closed with code 0!");
//            System.exit(0);
            return false;
        }

        var dbAgent = new DBAgent();
        dbAgent.insertSql(username, password);
        return true;

    }

    public boolean checkUsernameExistInDB(String username) {
        var dbAgent = new DBAgent();
        var result = dbAgent.selectSql(username);

        return result.size() != 0;

    }

    public boolean checkUsernameExistInDB(String username, String password) {
        var dbAgent = new DBAgent();
        var result = dbAgent.selectSql(username, password);

        return result.size() != 0;

    }

    public boolean logInToDB() throws IOException {
        boolean isLog = false;

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("Type your username & password:");
        System.out.println("USERNAME:");
        var username = bufferedReader.readLine();
        System.out.println("PASSWORD:");
        var password = bufferedReader.readLine();


        if (checkUsernameExistInDB(username)) {
            System.out.println("Sorry :-((((   This username exists in DB already. The application will be closed with code 0!");
//            System.exit(0);
            return false;
        }

        return isLog;
//        return bufferedReader.readLine();

    }




}
