import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private static List<LibrarySystem> librarySystems = new ArrayList<>();
    private static List<Book> books = new ArrayList<>();
    private static List<Member> members = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try {
            librarySystems = FileHandler.loadTransactions();
            books = FileHandler.loadBooks();
        }catch (Exception e){
            System.out.println("No transaction exists!! ADD DATA");
        }
        try {
            books = FileHandler.loadBooks();
        }catch (Exception e){
            System.out.println("No Books exists!! ADD DATA");
        }
        while(true){
            System.out.println("Enter Your Choice: ");
            System.out.println("1.Add Book");
            System.out.println("2.Display All Books in Library");
            System.out.println("3.Display All Transaction details");
            System.out.println("4.Search member by name");
            System.out.println("5.Add transaction");
            System.out.println("6.Display All members");
            System.out.println("7.Return Book");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch){
                case 1: addBook();
                break;
                case 2: FileHandler.displayBooks();
                    break;
                case 3: FileHandler.displayTransactions();
                    break;
                case 4: getMember();
                    break;
                case 5: lendBook();
                    break;
                case 6: FileHandler.displayMembers();
                    break;
                case 7:returnBook();
                break;
                default:
                    System.out.println("Invalid choice!!! TRY AGAIN");
            }
        }
    }
    public static void addBook(){
        System.out.println("Enter author name:");
        String author = sc.nextLine();

        System.out.println("Enter genre: ");
        String genre = sc.next();
        sc.nextLine();

        System.out.println("Enter title: ");
        String title = sc.nextLine();

        System.out.println("Enter id: ");
        String id = sc.next();

        books.add(new Book(author, true, genre, title, id));
        System.out.println("Added data in the list!!");
        try{
            FileHandler.saveBook(books);
            System.out.println("Data saved");
        }catch (Exception e){
            System.out.println("Fail to save data");
            e.printStackTrace();
        }
    }

    public static void lendBook() throws IOException {
        System.out.println("Enter Book name: ");
        String book = sc.nextLine();
        for(Book bookk: books){
            if(bookk.getTitle().equalsIgnoreCase(book)){
                if(bookk.getIsAvailable()){
                    System.out.println("Book is Available");
                    System.out.println("Enter reference id: ");
                    String referenceId = sc.nextLine();
                    System.out.println("Enter issue date(YY MM DD): ");
                    String issueDate = sc.nextLine();
                    System.out.println("Enter due Date(YY MM DD): ");
                    String dueDate = sc.nextLine();


                    System.out.println("Enter member name: ");
                    String member = sc.nextLine();
                    System.out.println("Enter his/her mail id: ");
                    String email = sc.nextLine();
                    System.out.println("Enter his id: ");
                    String id = sc.nextLine();
                    members.add(new Member(email,id,member));
                    FileHandler.saveMember(members);
                    String returnDate = null;
                    librarySystems.add(new LibrarySystem(referenceId,issueDate,dueDate,returnDate,book, member));

                    bookk.setIsAvailable(false);
                    FileHandler.saveBook(books);

                    FileHandler.saveTransactions(librarySystems);
                    System.out.println("Book successfully lent!!");
                    return;
                } else {
                    System.out.println("Book is not available");
                    return;
                }
            }
        }
    }
    public static void getMember() {
        System.out.println("Enter member's name: ");
        String name = sc.nextLine();
        boolean found = false;

        for(Member mem: members) {
            if(mem.getName().equalsIgnoreCase(name)) {
                System.out.println(mem);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("No member exists by this name.");
        }
    }
    public static void returnBook() {
        System.out.println("Enter book's name: ");
        String book = sc.nextLine();
        boolean bookFound = false;

        for(Book book1 : books) {
            if(book1.getTitle().equalsIgnoreCase(book)) {
                book1.setIsAvailable(true);
                bookFound = true;
                break;
            }
        }

        if(!bookFound) {
            System.out.println("Book not found in library records.");
            return;
        }

        System.out.println("Enter return date (YY MM DD): ");
        String returnDate = sc.nextLine();

        boolean transactionFound = false;
        for(LibrarySystem transaction : librarySystems) {
            if(transaction.getBookName().equalsIgnoreCase(book) &&
                    transaction.getReturnDate() == null) {
                transaction.setReturnDate(returnDate);
                transactionFound = true;
                break;
            }
        }

        try {
            FileHandler.saveBook(books);
            FileHandler.saveTransactions(librarySystems);
            System.out.println("Book successfully returned!");
        } catch(IOException e) {
            System.out.println("Error saving return transaction: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
