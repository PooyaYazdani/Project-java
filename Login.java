import java.util.Scanner;

public class Login {
    User currentUser;
    DataBase dataBase;
    Scanner console;
    
    Scanner reader;

    public Login(User currentUser, DataBase dataBase, Scanner console) {
        this.currentUser = currentUser;
        this.dataBase = dataBase;
        this.console = console;
    }

    public void mainApp () {
        String command;
        Boolean breakAll;
        while (true) {
            breakAll = false;
            System.out.println("type create post to create post or exit to exit");
            command = console.nextLine();
            if (command.equals("exit"))
                break;
            else if ()
        }
    }

    public void showPosts() {

    }
}
