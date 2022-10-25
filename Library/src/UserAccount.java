import java.util.Scanner;

public class UserAccount extends LibraryAccount{

    public UserAccount(String username, String password) {
        super(username, password);
    }

    @Override
    public void showDashboard(){
        char option;
        String userInput;
        Library library = new Library();

        try (Scanner input = new Scanner(System.in)) {

            do{
                System.out.println(
                    "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=\n"+
                    "Select an option from the menu\n"+
                    "A: Search book\n"+
                    "B: Show List of Books\n"+
                    "C: Read a book\n"+
                    "D: Log out\n"+
                    "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                );

                option = input.next().charAt(0); 

                clrscr();

                switch (Character.toLowerCase(option)) {
                    case 'a':
                        System.out.println("Enter a character or word: ");
                        userInput = input.next();
                        library.searchBook(userInput);
                        System.out.println("Enter any key to return to previous menu: ");
                        option = input.next().charAt(0); 
                        break;
                    case 'b':
                        library.showList();
                        System.out.println("Enter any key to return to previous menu: ");
                        option = input.next().charAt(0); 
                        break;
                    case 'c':
                        library.showList();
                        library.readBook();
                        System.out.println("Enter any key to return to previous menu: ");
                        option = input.next().charAt(0); 
                        break;
                    default:
                        if (Character.toLowerCase(option) == 'd'){
                            break;
                        }
                        System.out.println("Invalid option. Please try again");
                        break;
                }

            }while(Character.toLowerCase(option) != 'd');

            System.out.println("Thank you for visiting the library! See you again....");
            System.exit(0);
        }
        
    }

}
    
}
