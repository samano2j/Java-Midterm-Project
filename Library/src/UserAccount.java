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
                    "C: Log out\n"+
                    "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*="
                );
                option = ' ';
                option = input.nextLine().charAt(0); 

                clrscr();

                switch (Character.toLowerCase(option)) {
                    case 'a':
                        System.out.println("Enter a character or word: ");
                        userInput = input.nextLine();

                        library.searchBook(userInput);

                        System.out.println("Enter [read] if you want to read a book or any other key to return previous menu: ");
                        userInput = input.nextLine(); 
                        while(userInput.toLowerCase().equals("read")){
                            library.readBook();
                            System.out.println("Enter [read] if you want to read a book or any other key to return previous menu: ");
                            userInput = input.nextLine(); 
                        }

                        clrscr();
                        break;

                    case 'b':
                        library.showList();

                        System.out.println("Enter [read] if you want to read a book or any other key to return previous menu: ");
                        userInput = input.nextLine(); 
                        while(userInput.toLowerCase().equals("read")){
                            library.readBook();
                            System.out.println("Enter [read] if you want to read a book or any other key to return previous menu: ");
                            userInput = input.nextLine(); 
                        }

                        clrscr();
                        break;

                    default:
                        if (Character.toLowerCase(option) == 'c'){
                            break;
                        }
                        
                        System.out.println("Invalid option. Please try again");
                        break;
                }

            }while(Character.toLowerCase(option) != 'c');

            System.out.println("Thank you for visiting the library! See you again....");
            System.exit(0);
        }
        
    }

}
    
