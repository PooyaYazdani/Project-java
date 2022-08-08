import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            DataBase dataBase = new DataBase();
            Menu menu = new Menu(dataBase);
            menu.run();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
