import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    public Library() {
        ArrayList<String> genre1 = new ArrayList<>();
        genre1.add("Action");
        genre1.add("Sports");
        genre1.add("Thriller");

        ArrayList<String> genre2 = new ArrayList<>();
        genre2.add("Science Fiction");
        genre2.add("Thriller");

        books.add(new Book("Blue Lock", "Muneyuki Kaneshiro", 2021, genre1, 
        "In 2018, the Japanese national team finished 16th in the FIFA World Cup. As a result, the Japanese Football Union hires the soccer enigma Ego Jinpachi. His master plan to lead Japan to stardom is Blue Lock," +
         " a training regimen designed to create the world's greatest egotist striker. Those who fail Blue Lock will never again be permitted to represent Japan. Yoichi Isagi, an unknown high school soccer player who " + 
         "is conflicted about his playing style, decides to join the program in order to become the best player in the world."));
        books.add(new Book("The Hunger Games", "Suzanne Collins", 2008, genre2, "In what was once North America, the Capitol of Panem maintains its hold on its 12 districts by forcing them" + 
        " each to select a boy and a girl, called Tributes, to compete in a nationally televised event called the Hunger Games. Every citizen must watch as the youths fight to the death until only one remains." + 
        " District 12 Tribute Katniss Everdeen (Jennifer Lawrence) has little to rely on, other than her hunting skills and sharp instincts, in an arena where she must weigh survival against love."));
    }

    public void addBook() {
        String title, author;
        char userInput;
        int year = 0;
        boolean checkContinue = true;
        Scanner input = new Scanner(System.in);

        while(checkContinue) {
            System.out.println("Enter the title: ");
            title = input.next();
            System.out.println("Enter the author: ");
            author = input.next();
            System.out.println("Enter the year: ");

            while(checkContinue) {
                if(input.hasNextInt()) {
                    year = input.nextInt();
                }
                else {
                    System.out.println("Enter a valid year");
                    input.next();
                    continue;
                }
                checkContinue = false;
            } 

           

            System.out.println("Is the following details correct?(y/n)");
            System.out.println("Title: " + title +
                                "\nAuthor: " + author +
                                "\nYear: " + year);
            userInput = input.next().charAt(0); 

            if(Character.toLowerCase(userInput) == 'y') {
                books.add(new Book(title, author, year, null, null));
                System.out.println("Book successfully added");
                checkContinue = false;
            }
            else if (Character.toLowerCase(userInput) == 'n') {
                checkContinue = true;
            }
            else {
                userInput = input.next().charAt(0); 
            }
        }
    }
    

    public void removeBook(String title) {
        boolean contain = false;

        for (int i = 0; i < books.size(); i++) {
            if((books.get(i).getTitle().toLowerCase()).equals(title.toLowerCase())) {
                System.out.println("Successfully removed book " + books.get(i).getTitle());
                books.remove(i);
                contain = true;
            }
        }

        if (!contain) {
            System.out.println("Book does not exist");
        }
    }

    public void editBook() {
        String title, author, description, genre, userInput;
        char option = ' ';
        ArrayList <String> genreList = new ArrayList<>();
        int year = 0, index = 0;
        boolean checkContinue = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Which book to edit: ");
        title = input.nextLine();

        for (int i = 0; i < books.size(); i++) {
            if((books.get(i).getTitle().toLowerCase()).equals(title.toLowerCase())) {
                checkContinue = true;
                index = i;
            }
        }

        if(checkContinue) {
            do {
                System.out.println("Which property to edit? (title, author, year, description, genre) ");
                userInput = input.nextLine();
                if(userInput.toLowerCase().equals("title")) {
                    System.out.println("Change title: ");
                    title = input.nextLine();
                    books.get(index).setTitle(title);
                    System.out.println("Successful edit");
                    System.out.println(books.get(index));
                    break;
                }
                else if (userInput.toLowerCase().equals("author")) {
                    System.out.println("Change author: ");
                    author = input.nextLine();
                    books.get(index).setAuthor(author);
                    System.out.println("Successful edit");
                    System.out.println(books.get(index));
                    break;
                }
                else if (userInput.toLowerCase().equals("year")) {
                    System.out.println("Change year: ");

                    while(checkContinue) {
                        if(input.hasNextInt()) {
                            year = input.nextInt();
                        }
                        else {
                            System.out.println("Enter a valid year");
                            input.next();
                            continue;
                        }
                        checkContinue = false;
                    } 

                    books.get(index).setYear(year);
                    System.out.println("Successful edit");
                    System.out.println(books.get(index));
                    break;
                }
                else if (userInput.toLowerCase().equals("description")) {
                    System.out.println("Change description: ");
                    description = input.nextLine();
                    books.get(index).setDescription(description);
                    System.out.println("Successful edit");
                    System.out.println(books.get(index));
                    System.out.println(books.get(index).getDescription());
                    break;
                }
                else if (userInput.toLowerCase().equals("genre")) {
                    while (!(Character.toLowerCase(option) == 'y')) {
                        System.out.println("Add genre: ");
                        genre = input.nextLine();
                        
                        while (!(genre.toLowerCase().equals("done"))) {
                            genreList.add(genre);
                            System.out.println("Enter [done] when finish adding genre: ");
                            genre = input.nextLine();
                        }

                        System.out.println(genreList);
                        System.out.println("Is this correct, enter 'y'? [no for any key] ");
                        option = input.nextLine().charAt(0);

                        if(Character.toLowerCase(option) == 'y') {
                            books.get(index).setGenre(genreList);
                            System.out.println("Successful edit");
                            System.out.println(books.get(index));
                            break;
                        }
                    }   
                    
                }
                else {
                    System.out.println("Invalid option");
                }
            } while(!userInput.equals("title") || !userInput.equals("author") || !userInput.equals("year") || !userInput.equals("description") || !userInput.equals("genre"));
        }
        else {
            System.out.println("Book does not exist");
        }
    }

    public void searchBook(String title) {
        boolean contain = false;

        for (int i = 0; i < books.size(); i++) {
            if((books.get(i).getTitle().toLowerCase()).contains(title.toLowerCase())) {
                System.out.println(books.get(i));
                contain = true;
            }
        }

        if(!contain) {
            System.out.println("Book does not exist");
        }
    }

    public void showList() {
        for(int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }

    public void readBook() {
        String title;
        Scanner input = new Scanner(System.in);
        boolean checkContinue = false;

        System.out.println("Which book to read?");
        title = input.nextLine();

        for (int i = 0; i < books.size(); i++) {
            if((books.get(i).getTitle().toLowerCase()).equals(title.toLowerCase())) {
                System.out.println(books.get(i).getDescription());
                checkContinue = true;
            }
        }

        if(!checkContinue) {
            System.out.println("Title does not exist");
        }
    }

}
