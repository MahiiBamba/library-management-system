import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String transaction = "database.txt";
    private static final String library = "stacks.txt";
    private static final String members = "members.txt";
    public static void saveTransactions(List<LibrarySystem> lists)throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(transaction))){
            for(LibrarySystem list: lists){
                writer.write(list.toString());
                writer.newLine();
            }
        }
    }
    public static void saveBook(List<Book> lists)throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(library))){
            for(Book list: lists){
                writer.write(list.toString());
                writer.newLine();
            }
        }
    }

    public static void saveMember(List<Member> lists)throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(members))){
            for(Member list: lists){
                writer.write(list.toString());
                writer.newLine();
            }
        }
    }

    public static List<LibrarySystem> loadTransactions() throws IOException {
        List<LibrarySystem> transactions = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(transaction))){
            String line;
            while((line = reader.readLine())!=null){
                String[] parts = line.split(",");
                String referenceId = parts[0];
                String issueDate = parts[1];
                String dueDate = parts[2];
                String returnDate = parts[3];
                String bookName = parts[4];
                String memberName = parts[5];
                transactions.add(new LibrarySystem(referenceId,issueDate,dueDate,returnDate,bookName,memberName));
            }
        }
        return transactions;
    }


    public static List<Book> loadBooks() throws IOException{
        List<Book> books = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(transaction))){
            String line;
            while((line = reader.readLine())!=null){
                String[] parts = line.split(",");
                String author = parts[0];
                Boolean isThere = Boolean.parseBoolean(parts[1]);
                String genre = parts[2];
                String title = parts[3];
                String id = parts[4];
                books.add(new Book(author,isThere,genre,title,id));
            }
        }
        return books;
    }

    public static void displayTransactions() throws IOException{
        try(BufferedReader reader = new BufferedReader(new FileReader(transaction))){
            String line;
            System.out.println("------------------------------------------------------------------");
            System.out.println("reference Id || Issue Date || Due Date || Return Date || Book || MemberName");
            System.out.println();
            while((line = reader.readLine())!=null){
                System.out.println(line);
            }
            System.out.println("------------------------------------------------------------------");
        }
    }
    public static void displayBooks() throws IOException{
        try(BufferedReader reader = new BufferedReader(new FileReader(library))){
            String line;
            System.out.println("-------------------------------------------");
            System.out.println("Author || Genre || Title || Id || Status");
            System.out.println();
            while((line = reader.readLine())!=null){
                System.out.println(line);
            }
            System.out.println("-------------------------------------------");
        }
    }
    public static void displayMembers() throws IOException{
        try(BufferedReader reader = new BufferedReader(new FileReader(members))){
            String line;
            System.out.println("-------------------------------------------");
            System.out.println("Email || Id || Name");
            System.out.println();
            while((line = reader.readLine())!=null){
                System.out.println(line);
            }
            System.out.println("-------------------------------------------");
        }
    }
}
