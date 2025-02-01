public class Member {
    private String email;
    private String id;
    private String name;
    public Member(String email, String id, String name){
        this.email = email;
        this.id = id;
        this.name = name;
    }
    public String getEmail(){return email;}
    public String getId(){return id;}
    public String getName(){return name;}
    public String toString(){ return email+", "+id+", "+name;}
}
