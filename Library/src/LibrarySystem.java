import java.io.IOException;
import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            UserAccount user = new UserAccount("userN","1234");            //Normal User
            LibrarianAccount librarian = new LibrarianAccount("userL","5678");      //Librarian User
            String username;
            String password;
           
            System.out.println("=============================\n" +
                                "Welcome to Book Buddy Library\n" +
                                "=============================");

            while(true){
                clrscr();
                System.out.println("Please enter your username");
                username = input.nextLine();
                System.out.println("Please enter your password");
                password = input.nextLine();

                if((username.equals(user.getUsername()) && password.equals(user.getPassword()))
                || (username.equals(librarian.getUsername()) && password.equals(librarian.getPassword()))){
                    break;
                }

                System.out.println("Invalid credentials\nPress [enter] key to try again or press [Q] to quit");

                if(input.nextLine().toLowerCase().equals("q")){
                    System.out.println("Thank you for visiting the library!");
                    System.exit(0);
                }
            }

            clrscr();

            if(username.equals(user.getUsername())) {
                System.out.println("Welcome! " + username);
                user.showDashboard();
            }

            if(username.equals(librarian.getUsername())) {
                System.out.println("Welcome! " + username);
                librarian.showDashboard();
            }
            
        }
        
    
    }

    public static void clrscr(){
		//Clears Screen in java
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
				System.out.print("\033\143");
		} catch (IOException | InterruptedException ex) {}
	}

}
