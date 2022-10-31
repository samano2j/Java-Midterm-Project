import java.util.Scanner;

public class UserAccount extends LibraryAccount{

    public UserAccount(String username, String password) {
        super(username, password);
    }

    @Override
    public void showDashboard(){
        char option;
        String userInput;
        int userInt = 0;
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
                        System.out.println("\nEnter [title] to sort by title \nEnter [author] to sort  by author \nEnter [year] to sort by year \nEnter [genre] to sort by genre \nEnter [back] to go back");
                        userInput = input.nextLine();
                        while(!userInput.toLowerCase().equals("back")){
                            if(userInput.toLowerCase().equals("title")){
                                clrscr();
                                System.out.println("Enter a character or word: ");
                                userInput = input.nextLine();

                                library.searchBookTitle(userInput);

                                System.out.println("Enter [read] if you want to read a book or any other key to return previous menu: ");
                                userInput = input.nextLine(); 
                                while(userInput.toLowerCase().equals("read")){
                                    library.readBook();
                                    System.out.println("Enter [read] if you want to read a book or any other key to return previous menu: ");
                                    userInput = input.nextLine(); 
                                }

                                clrscr();
                                System.out.println("Enter [title] to sort by title \nEnter [author] to sort  by author \nEnter [year] to sort by year \nEnter [genre] to sort by genre \nEnter [back] to go back");
                                userInput = input.nextLine(); 
                            }
                            else if (userInput.toLowerCase().equals("author")){
                                clrscr();
                                System.out.println("Enter a character or word: ");
                                userInput = input.nextLine();

                                library.searchBookAuthor(userInput);

                                System.out.println("Enter [read] if you want to read a book or any other key to return previous menu: ");
                                userInput = input.nextLine(); 
                                while(userInput.toLowerCase().equals("read")){
                                    library.readBook();
                                    System.out.println("Enter [read] if you want to read a book or any other key to return previous menu: ");
                                    userInput = input.nextLine(); 
                                }

                                clrscr();
                                System.out.println("Enter [title] to sort by title \nEnter [author] to sort  by author \nEnter [year] to sort by year \nEnter [genre] to sort by genre \nEnter [back] to go back");
                                userInput = input.nextLine();   
                            }
                            else if (userInput.toLowerCase().equals("year")) {
                                clrscr();
                                boolean checkContinue = true;
                                System.out.println("Enter a year: ");

                                while(checkContinue) {
                                    if(input.hasNextInt()) {
                                        userInt = input.nextInt();
                                    }
                                    else {
                                        System.out.println("Enter a valid year");
                                        input.next();
                                        continue;
                                    }
                                    checkContinue = false;
                                } 

                                library.searchBookYear(userInt);

                                input.nextLine(); 

                                System.out.println("Enter [read] if you want to read a book or any other key to return previous menu: ");
                                userInput = input.nextLine(); 
                                while(userInput.toLowerCase().equals("read")){
                                    library.readBook();
                                    System.out.println("Enter [read] if you want to read a book or any other key to return previous menu: ");
                                    userInput = input.nextLine(); 
                                }

                                clrscr();
                                System.out.println("Enter [title] to sort by title \nEnter [author] to sort  by author \nEnter [year] to sort by year \nEnter [genre] to sort by genre \nEnter [back] to go back");
                                userInput = input.nextLine(); 
                            }
                            else if (userInput.toLowerCase().equals("genre")){
                                clrscr();
                                System.out.println("Enter a word: ");
                                userInput = input.nextLine();

                                library.searchBookGenre(userInput);

                                System.out.println("Enter [read] if you want to read a book or any other key to return previous menu: ");
                                userInput = input.nextLine(); 
                                while(userInput.toLowerCase().equals("read")){
                                    library.readBook();
                                    System.out.println("Enter [read] if you want to read a book or any other key to return previous menu: ");
                                    userInput = input.nextLine(); 
                                }

                                clrscr();
                                System.out.println("Enter [title] to sort by title \nEnter [author] to sort by author \nEnter [year] to sort by year \nEnter [genre] to sort by genre \nEnter [back] to go back");
                                userInput = input.nextLine();   
                            }
                            else if (userInput.toLowerCase().equals("back")) {
                                break;
                            }
                            else {
                                clrscr();
                                System.out.println("\nInvalid input");
                                System.out.println("\nEnter [title] to sort by title \nEnter [author] to sort by author \nEnter [year] to sort by year \nEnter [genre] to sort by genre \nEnter [back] to go back");
                                userInput = input.nextLine(); 
                            }
                        }

                        clrscr();
                        break;

                    case 'b':
                        library.showList();

                        System.out.println("\nEnter [title] to sort by title \nEnter [author] to sort  by author \nEnter [year] to sort  by year \nEnter [back] to go back");
                        userInput = input.nextLine(); 

                        while(!userInput.toLowerCase().equals("back")){
                            if(userInput.toLowerCase().equals("title")){
                                clrscr();
                                library.sortbyTitle();
                                library.showList();

                                System.out.println("\nEnter [title] to sort by title \nEnter [author] to sort  by author \nEnter [year] to sort  by year \nEnter [back] to go back");
                                userInput = input.nextLine(); 
                            }
                            else if (userInput.toLowerCase().equals("author")){
                                clrscr();
                                library.sortbyAuthor();
                                library.showList();

                                System.out.println("\nEnter [title] to sort by title \nEnter [author] to sort  by author \nEnter [year] to sort  by year \nEnter [back] to go back");
                                userInput = input.nextLine();   
                            }
                            else if (userInput.toLowerCase().equals("year")) {
                                clrscr();
                                library.sortbyYear();
                                library.showList();

                                System.out.println("\nEnter [title] to sort by title \nEnter [author] to sort  by author \nEnter [year] to sort  by year \nEnter [back] to go back");
                                userInput = input.nextLine(); 
                            }
                            else if (userInput.toLowerCase().equals("back")) {
                                break;
                            }
                            else {
                                clrscr();
                                library.showList();
                                System.out.println("\nInvalid input");
                                System.out.println("\nEnter [title] to sort by title \nEnter [author] to sort  by author \nEnter [year] to sort  by year \nEnter [back] to go back");
                                userInput = input.nextLine(); 
                            }
                        }

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
    
