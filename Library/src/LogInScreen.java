import java.util.Scanner;

public class LogInScreen {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            UserAccount user = new UserAccount("userN","1234");            
            LibrarianAccount librarian = new LibrarianAccount("userL","5678");      
            String username;
            String password;
           
            System.out.println("=============================\n" +
                                "Welcome to Book Buddy Library\n" +
                                "=============================");

            while(true){
                
                System.out.println("Enter your username: ");
                username = input.nextLine();
                System.out.println("Enter your password: ");
                password = input.nextLine();

                if((username.equals(user.getUsername()) && password.equals(user.getPassword()))
                || (username.equals(librarian.getUsername()) && password.equals(librarian.getPassword()))){
                    break;
                }

                System.out.println("Invalid credentials\nPress [enter] key to try again or press q to quit");

                if(input.nextLine().toLowerCase().equals("q")){
                    System.out.println("Thank you for visiting the library!");
                    System.exit(0);
                }
            }

            user.clrscr();

            if(username.equals(user.getUsername())) {
                System.out.println("Welcome! " + username);
                user.showDashboard();
            }

            if(username.equals(librarian.getUsername())) {
                System.out.println("Welcome! Librarian " + username);
                librarian.showDashboard();
            }
            
        }
        
    
    }

}
