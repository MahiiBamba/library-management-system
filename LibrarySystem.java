public class LibrarySystem {
    private String referecnceId;
    private String issueDate;
    private String dueDate;
    private String returnDate;
    private String bookName;
    private String memberName;
    public LibrarySystem(
            String referenceId,String issueDate,
    String dueDate, String returnDate, String bookName, String memberName){
        this.referecnceId = referenceId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.bookName = bookName;
        this.memberName = memberName;
    }
    public String getReferecnceId(){ return referecnceId;}
    public String getIssueDate(){return issueDate;}
    public String getDueDate(){return dueDate;}
    public String getReturnDate(){return returnDate;}
    public void setReturnDate(String date){this.returnDate=date;}
    public String getBookName(){return bookName;}
    public String getMemberName(){return memberName;}
    public String toString(){return referecnceId+", "+issueDate+", "+dueDate
    +", "+returnDate+", "+bookName+", "+memberName;}
}
