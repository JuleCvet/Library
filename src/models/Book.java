package models;

public class Book extends Material{//se od materijal nasleduva, materijal nikogash nema da s koristi za dr
 
  
    private String author;
    private String isbn;  
    private int noOfPages;

    public Book(String id, String title, String author, String isbn, String branch, int noOfPages) {
        super(id, title, branch);
        
        this.author = author;
        this.isbn = isbn;
        this.noOfPages = noOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
    
    public void sendForRepair(){
        System.out.println("Book has been sent for repair.");
    
    }
    
      public int getLoanPeriod(){
      return 21;
      
      }  

    @Override
    public String toString() {
        return "BOOK" + getID() + " " + getTitle() + " / " + getAuthor(); //To change body of generated methods, choose Tools | Templates.
    }
      
      
}