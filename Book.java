public class Book {
    private String author;
    private Boolean isAvailable;
    private String genre;
    private String title;
    private String id;
    public Book(String author,Boolean isAvailable,
                String genre, String title, String id){
        this.author = author;
        this.isAvailable = isAvailable;
        this.genre = genre;
        this.title = title;
        this.id = id;
    }
    public Boolean getIsAvailable(){ return isAvailable;}
    public void setIsAvailable(Boolean st){this.isAvailable = st;}
    public String getAuthor(){ return author;}
    public String getGenre(){ return genre;}
    public String getTitle(){ return title;}
    public String getId(){ return id;}
    public String toString(){return author+", "+genre+", "+title+", "
            +id+", "+isAvailable;}
}
