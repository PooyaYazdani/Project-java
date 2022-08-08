import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class DataBase {
    Scanner usersSC;
    File users = new File("E:\\negah\\daneshga\\term 2\\OOP\\project1\\src\\usersData.txt");
    FileWriter usersW;
    BufferedWriter usersBW;
    public DataBase() throws Exception{
        try {
            usersW = new FileWriter(users, true);
            usersBW = new BufferedWriter(usersW);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public Scanner getUsers() throws Exception {
        usersSC = new Scanner(users);
        return usersSC;
    }

    public boolean usernameExists (String username) throws Exception {
        Scanner checker = getUsers();
        String tempUsername;
        while (checker.hasNextLine()) {
            tempUsername = checker.nextLine();
            if (tempUsername.split(" ")[0].equals("username:")) {
                if (tempUsername.split(" ")[1].equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkPassword (String username, String password) throws Exception {
        Scanner checker = getUsers();
        String tempUsername;
        String tempPassword;
        while (checker.hasNextLine()) {
            tempUsername = checker.nextLine();
            if (tempUsername.split(" ")[0].equals("username:")) {
                if (tempUsername.split(" ")[1].equals(username)) {
                    tempPassword = checker.nextLine();
                    if (tempPassword.split(" ")[1].equals(password)) {
                        return true;
                    }
                    else
                        return false;
                }
                else
                    continue;
            }
        }
        return false;
    }

    public void addUser(User user) throws Exception {
        try{
            usersBW.append("username: "+user.getUserName());
            usersBW.newLine();
            usersBW.append("password: "+user.getPassword());
            usersBW.newLine();
            usersBW.append("security: "+user.getSecurityAnswer());
            usersBW.newLine();
            usersBW.append("business: "+user.getBusiness());
            usersBW.newLine();
            //usersBW.close();
            //usersW.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean checkSecurity (String username, String password) throws Exception {
        Scanner checker = getUsers();
        String tempUsername;
        String tempPassword;
        while (checker.hasNextLine()) {
            tempUsername = checker.nextLine();
            if (tempUsername.split(" ")[0].equals("username:")) {
                if (tempUsername.split(" ")[1].equals(username)) {
                    tempPassword = checker.nextLine();
                    tempPassword = checker.nextLine();
                    if (tempPassword.split(" ")[1].equals(password)) {
                        return true;
                    }
                    else
                        return false;
                }
                else
                    continue;
            }
        }
        return false;
    }

    public boolean checkBusiness (String username) throws Exception {
        Scanner checker = getUsers();
        String tempUsername;
        while (checker.hasNextLine()) {
            tempUsername = checker.nextLine();
            if (tempUsername.split(" ")[0].equals("username:")) {
                if (tempUsername.split(" ")[1].equals(username)) {
                    tempUsername = checker.nextLine();
                    tempUsername = checker.nextLine();
                    tempUsername = checker.nextLine();
                    if (tempUsername.split(" ")[1].equals("business")) {
                        return true;
                    }
                    else
                        return false;
                }
                else
                    continue;
            }
        }
        return false;
    }
}

