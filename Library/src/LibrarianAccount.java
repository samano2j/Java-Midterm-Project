import java.util.Scanner;

public class LibrarianAccount extends LibraryAccount{

    public LibrarianAccount(String username, String password) {
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
                    "C: Add a book\n"+
                    "D: Remove a book\n"+
                    "E: Edit a book\n"+
                    "F: Log out\n"+
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

                    case 'c':
                        library.addBook();
                        System.out.println("Enter any key to return to previous menu: ");
                        option = input.nextLine().charAt(0); 
                        clrscr();
                        break;

                    case 'd':
                        library.showList();
                        System.out.println("Enter a title: ");
                        userInput = input.nextLine();
                        library.removeBook(userInput);
                        System.out.println("Enter any key to return to previous menu: ");
                        option = input.nextLine().charAt(0); 
                        clrscr();
                        break;
                        
                    case 'e':
                        library.showList();
                        library.editBook();
                        System.out.println("Enter any key to return to previous menu: ");
                        option = input.nextLine().charAt(0); 
                        clrscr();
                        break;
                
                    default:
                        if (Character.toLowerCase(option) == 'f'){
                            break;
                        }
                        System.out.println("Invalid option. Please try again");
                        break;
                }

            }while(Character.toLowerCase(option) != 'f');

            System.out.println("Thank you for visiting the library! See you again....");
            System.exit(0);
        }
        
    }

}
