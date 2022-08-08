import sun.rmi.runtime.Log;

import java.util.Scanner;

public class Menu {
    DataBase dataBase;
    Scanner console = new Scanner(System.in);
    Login login;
    public Menu(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void run() throws Exception {
        String command;
        boolean breakAll;
        while (true) {
            breakAll = false;
            System.out.println("to login type login to sign, to sign in type sign in and to exit type exit:");
            command = console.nextLine();
            if (command.equals("exit")) {
                dataBase.usersBW.close();
                dataBase.usersW.close();
                break;
            }
            else if (command.equals("login")) {
                String username;
                String password;
                while (true) {
                    if (breakAll)
                        break;
                    System.out.println("type your username or type back to return:");
                    username = console.nextLine();
                    if (username.equals("back"))
                        break;
                    else if (dataBase.usernameExists(username))
                        while (true){
                            if (breakAll)
                                break;
                            System.out.println("type your password or type forgot if you forgot your password type back to return:");
                            password = console.nextLine();
                            if (password.equals("back"))
                                break;
                            else if (password.equals("forgot")){
                                while (true) {
                                    if (breakAll)
                                        break;
                                    System.out.println("what is your favorite food? or type back to return");
                                    password = console.nextLine();
                                    if (password.equals("back"))
                                        break;
                                    else if(dataBase.checkSecurity(username, password)) {
                                        System.out.println("login successful");
                                        login = new Login(new User(username, dataBase.checkBusiness(username)), dataBase, console);
                                        login.mainApp();
                                        breakAll = true;
                                    }
                                    else
                                        System.out.println("wrong answer");
                                }

                            }
                            else{
                                try {
                                    if (dataBase.checkPassword(username, password)) {
                                        login = new Login(new User(username, dataBase.checkBusiness(username)), dataBase, console);
                                        System.out.println("login successful");
                                        login.mainApp();
                                        breakAll = true;
                                    }
                                    else
                                        System.out.println("wrong password");
                                }
                                catch (Exception e) {
                                    System.out.println(e + "ppp");
                                }
                            }
                        }
                    else
                        System.out.println("username not found");
                }
            }
            else if (command.equals("sign in")) {
                String username;
                String password1;
                String password2;
                String securityAnswer;
                String type;
                while (true) {
                    if (breakAll)
                        break;
                    System.out.println("type your username or type back to return:");
                    username = console.nextLine();
                    if (username.equals("back"))
                        break;
                    else if (username.contains(" "))
                        System.out.println("no spaces allowed in the username");
                    else if (dataBase.usernameExists(username))
                        System.out.println("username already exists");
                    else
                        while (true) {
                            if (breakAll)
                                break;
                            System.out.println("type your password or back to return:");
                            password1 = console.nextLine();
                            if (password1.equals("back"))
                                break;
                            else if (password1.length() < 8)
                                System.out.println("password must be at least 8 characters:");
                            else
                                while (true) {
                                    if (breakAll)
                                        break;
                                    System.out.println("repeat your password or type back to return");
                                    password2 = console.nextLine();
                                    if (password2.equals("back"))
                                        break;
                                    else if (!password1.equals(password2))
                                        System.out.println("passwords does not match");
                                    else {
                                        System.out.println("answer to this security question: what is your favorite food? or type back to return");
                                        securityAnswer = console.nextLine();
                                        if (securityAnswer.equals("back"))
                                            break;
                                        else {
                                            while (true) {
                                                if (breakAll)
                                                    break;
                                                System.out.println("type business for business account or normal for normal account or type back to return");
                                                type = console.nextLine();
                                                if (type.equals("back"))
                                                    break;
                                                else if (type.equals("normal")){
                                                    dataBase.addUser(new User(username, password1, securityAnswer, false));
                                                    System.out.println("sign in succesful");
                                                    breakAll = true;
                                                }
                                                else if (type.equals("business")) {
                                                    dataBase.addUser(new User(username, password1, securityAnswer, true));
                                                    System.out.println("sign in succesful");
                                                    breakAll = true;
                                                }
                                            }
                                        }
                                    }
                                }
                        }
                }
            }
        }
    }
}
