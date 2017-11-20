package models;

import java.util.Date;
import java.util.GregorianCalendar;
import utilities.LoanStatusType;


public class Loan {
    
    private int ID;
    private Customer customer;//zatoa shto veke imame klasa Customer, pravime od nejze objekt
    private Book book;//zatoa shto veke imame klasa Book, pravime od nejze objekt
    private Date startDate;//mora da importirame date klass, ne go stavame vo konstruktor zatoa shto ke go inicijalizirame sami
    private Date dueDate;//ne go stavame vo konstruktor zatoa shto ke go inicijalizirame sami so omosh na gregorijanskiot kalendar 
    private Date returnDate;//ne go stavame vo konstruktor zatoa shto ke go inicijalizirame sami
    private LoanStatusType status;
   

    public Loan(int ID, Customer customer, Book book) {//ovde isto kako tip na objekt gi koristime klasite
        super();
        this.ID = ID;
        this.customer = customer;
        this.book = book;
        startDate = new Date();
        
       GregorianCalendar gCal = new GregorianCalendar();//kreirame kalendar i go importirame
       gCal.add(GregorianCalendar.DAY_OF_MONTH, 14);//mu dodavame 14 dena od mesecot, vaznost na kalendarot
       this.dueDate = gCal.getTime(); //setuvame koga ke ispari datata so getTime()
       
       status = LoanStatusType.CURRANT;
       
    }

    @Override//smo id, book i mushterija sakame da pecatime
    public String toString() {
        return "ID=" + ID + ", customer=" + customer.getMailingName() + ", book=" + book.getTitle();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.ID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {//ako e objekt ok e
            return true;
        }
        if (obj == null) {//ako e 0, ne e ok
            return false;
        }
        if (getClass() != obj.getClass()) {//ako ne e klasa od nizata, ne e ok
            return false;
        }
        final Loan other = (Loan) obj;//ako go nema ID-to, ne e ok
        if (this.ID != other.ID) {
            return false;
        }
        return true;//vo sprotivno sporedi gi
    }

    public Customer getCustomer() {//gi setirame samo vo konstruktorot, dr set ne ni trebit
        return customer;
    }

    public Book getBook() {
        return book;
    }

    public Date getDueDate() {
        return dueDate;
    }
    //metod so koj ke proverime dali knigata e iznajmena i koj i e statusot 
    public void endLoan(){//koga knigata e vratena i da i namestime status historic
    returnDate = new Date();
    status = LoanStatusType.HISTORIC;
    }
    
   public LoanStatusType getStatus(){//zemame tip od enum i vrakame takov
    return status;//shto e inicijaliziran kako:  status = LoanStatusType.CURRANT;
    
   }  
}
