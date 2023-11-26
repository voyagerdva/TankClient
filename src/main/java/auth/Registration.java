package auth;

import DB.DBAgent;

import java.io.*;

public class Registration {
    public int loginOrRegistration() throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("\n-----------------------------------------------" +
                           "\nType:" +
                           "\n1 - new account registration" +
                           "\n2 - logIn by exising name");

        String choice = bufferedReader.readLine(); //читаем строку с клавиатуры
        return Integer.parseInt(choice);
    }


    public boolean addNewUserToDB() {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("Type new username & password for new registration:");
        System.out.println("USERNAME:");
        String username = null;
        try {
            username = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("PASSWORD:");
        String password = null;
        try {
            password = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (checkUsernameExistInDB(username)) {
            System.out.println("Sorry :-((((   " +
                               "This username exists in DB already. TRY AGAIN FROM BEGIN....");
            return false;
        }

        var dbAgent = new DBAgent();
        dbAgent.insertSql(username, password);
        System.out.println(" :-))  Congratulations!!! New account was added successful!!!");
        return true;
    }

    public boolean checkUsernameExistInDB(String username) {
        var dbAgent = new DBAgent();
        var result = dbAgent.selectSql(username);

        return result.size() != 0;
    }


    public boolean checkCredExistInDB(String username, String password) {
        var dbAgent = new DBAgent();
        var result = dbAgent.selectSql(username, password);

        return result.size() != 0;
    }

    public boolean logIn() throws IOException {
//        boolean isLog = false;

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("Type your username & password for logIn:");
        System.out.println("USERNAME:");
        var username = bufferedReader.readLine();
        System.out.println("PASSWORD:");
        var password = bufferedReader.readLine();

        return checkCredExistInDB(username, password);
    }

    public void registrationOrLogin() throws IOException {
        boolean flagLogIn = false;
        while (true) {
            var choice = loginOrRegistration();
            System.out.println("You have entered " + choice);

            if (choice == 1) {
                addNewUserToDB();
                continue;
            }

            if (choice == 2) {
                flagLogIn = logIn();

                if (flagLogIn) {
                    System.out.println("SUCCESS LOGGED!!!");
                    break;
                } else {
                    System.out.println("Cred failed :-(((  Login or password is NOT CORRECT. Try again...");
                }
            }
        }
    }



}
