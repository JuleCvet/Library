
package ui;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TreeMap;
import javax.print.SimpleDoc;
import models.Book;
import models.Book;
import models.Customer;
import models.DVD;
import models.Loan;
import models.LoanAlreadyExistsException;
import models.LoansRegistry;
import models.Material;
import models.MaterialCatalogInterface;
import models.MaterialCatalogMemoryVersion;
import models.MaterialNotFoundException;
import utilities.GenderType;

public class Main {
    
    public static void main(String[] args) {
        
       MaterialCatalogInterface materialCatalog = new MaterialCatalogMemoryVersion();
       
       Book book1 = new Book("1", "Java book", "Bita", "3425",  "AnyTown branch", 400);
       Book book2 = new Book("2", "Best Java book", "Maria23", "3566", "AnyTown branch", 156 );
       Book book3 = new Book("3", "Best1 Java book", "Maria56", "34258", "AnyTown branch", 159 );
       Book book4 = new Book("4", "Best3 Java book", "Maria98", "3696", "AnyTown branch", 160 );
       Book book5 = new Book("5", "Best5 Java book", "Maria38", "3976", "AnyTown branch", 170 );
       DVD dvd1 = new DVD("5", "An epic film about java", "AnyTown branch", "Steffan Spilberg", "99887", 120);
       DVD dvd2 = new DVD("3", "An epic film about java", "AnyTown branch", "Steffan Spilberg", "99887", 120);
       
        //System.out.println(dvd1.getTitle());
        //book1.relocate("MyCytyBranch");

       
       materialCatalog.addMaterial(book1);
       materialCatalog.addMaterial(book2);
       materialCatalog.addMaterial(book3);
       materialCatalog.addMaterial(book4);
       materialCatalog.addMaterial(book5);
       materialCatalog.addMaterial(dvd1);
       materialCatalog.addMaterial(dvd2);
       
       UI ui = new UI();
       ui.printHeader();//book title, id author
       //ui.printBook(book1);
       //ui.printBook(book2);
       ui.printMaterialCatalog(materialCatalog.getMaterialMap());//ni treba za ovoj metod, niza kako atribut pa ja povikuvame so getArray()
       //metodot ke vrat naslov na kniga i sakame da go zacuvame toj naslov pa :
//       
//       try
//       {
//         Book foundBook = bookCatalog.findBook("epic");//da go fatime ecepshonot, go opkruzzuvame kodot so try- catch
//         System.out.println("We found: " + foundBook.getTitle());//ja prikazuva knigata so naslov
////odime vo BookCatalog klasata i go povikuvame metodot za findinG. ograniceni sme samo na ovoj rd
//       }
//       catch(BookNotFoundException e)//sekogash ke run, i kodot posle nego ke run
//       {
//           System.out.println("The book was no t found ");
//       }  
       //if(foundBook != null){ //ne e dobra praksa so If() tuku so . exceptions
//ako mu dozvolime na korisnikot da vnesuva title od kniga?ke treba da se osigurame deka ke vnese pravilen input           

    
    
    
       Customer customer = new Customer("Chef", "Julijana", "Cvetkovska", "Tummelisas gata 4", "026845295", 
       "jule@gmail",  25, GenderType.WOMEN);
       
       
        Loan firstLoan = new Loan(1, customer, book1);//nov objekt od novata klasa Loan so pogornite novi objekti Book i Customer
        System.out.println(firstLoan.getDueDate());//go testirame getdueDate()
        System.out.println(firstLoan);//za da go testirame toString(), pecatit podatoci od new objekti: 
        //knigata i od customer
        
        LoansRegistry registry = new LoansRegistry();
        
       try
       {
       registry.addLoan(firstLoan);//add frla isklucok koj treba da go fatime, i ako uspeeme da pozajmime treba da kazeme
           System.out.println("addLoan worked");
       }
       catch(LoanAlreadyExistsException e){
           System.out.println("addLoan failed");
       }
       
       //go povtoruvame 2 pati za da vidime dali prviot pat ke uspee a vtoriot pat ke padne
       try
       {
       registry.addLoan(firstLoan);//add frla isklucok koj treba da go fatime, i ako uspeeme da pozajmime treba da kazeme
           System.out.println("addLoan worked");
       }
       catch(LoanAlreadyExistsException e){
           System.out.println("Add loan failed");
       }
       
       
       //da go proverime statusot za nashata pozajmena kniga
        System.out.println(registry.isBookOnLoan(book1.getID()));//dali knigata so toj ID e iznajmena
        //ke smenime knigata poveke da ne e iznajmena, status ke i smenima
        firstLoan.endLoan();//stavame kraj na prvata iznajmena kniga
        System.out.println(registry.isBookOnLoan(book1.getID()));
//       
         //kreirame nova varijabla za da go zacuvame Date
//        Date today = new Date(); //go kreira vremeto koga ja pravime varijablava
//        System.out.println(today);
//        
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//zagradive znacat konstruktor
//        System.out.println(sdf.format(today));//2017-10-29, ni go dava poednostavno
//  
//        SimpleDateFormat sdf1 = new SimpleDateFormat("MMM");
//        System.out.println(sdf1.format(today));//окт. samo mesec so 3 bukvi
//        //ako sakame poln mesec so bukvi, MMMM
//        SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd / yyyy");
//        System.out.println(sdf2.format(today));//окт. 29 / 2017
//        
//        SimpleDateFormat sdf3 = new SimpleDateFormat("D");
//        System.out.println(sdf3.format(today));//302 ot den vo godinata
//        
//        GregorianCalendar gCal = new GregorianCalendar(2007,0, 1);
//        System.out.println(gCal);//pecati nerazbirlivo
//        today = gCal.getTime();
//        System.out.println("Today is: " + sdf.format(today));//Today is: 2007-02-01, mora od ! pozicija da pocnime, ne od 0
//        gCal.add(GregorianCalendar.DAY_OF_MONTH, 67);//prvoto e denovi za menuvanje birame od metodi + kolku dena sakame da zgolemime
//        today = gCal.getTime();//moze i nedeli od godina metod da se odberi
//      
        
        
       //Book[] bookCatalog = new Book[10]; ne ni treba veke ovaa niza zs imame vo UI
       //ni treba instance od bookCatalog klasata za da gi koristime nejzinite metodi    
      
//        System.out.println(customer.getMailingName());
//        System.out.println(dvd1.lend(customer));//true, ke bide false zs ne koristi licance()
//        dvd1.licence();//da go dodademe licence() za da moze da go izdavame
//        System.out.println(dvd1.lend(customer));//true, if(licence)- return true
//        System.out.println(dvd1.lend(customer));//veke izdadeno, false
//        
//        System.out.println(book1.lend(customer));//prv pat true, se run parent land()
//        System.out.println(book1.lend(customer));//2 pati da mu ja iznajmime istata kniga na mushterijata
//        
//        //Material materijal = new Material(99, "Test materijal", "Test branch");//pravime nov objekt od materijal
//        //ne moze od parent klasa da sozdavame direktno novi objekti zatoa ja pravime abstraktna
//        System.out.println(book1.getLoanPeriod());
//        System.out.println(dvd1.getLoanPeriod());


      
//      double d = 1.12345;
//      
//      //NumberFormat nf = NumberFormat.getPercentInstance();//procent 112%
////kako da napravime 123.4%, barame get metof vo java.text bibliotekata
//      //nf.setMinimumFractionDigits(2);//112,34%
//      NumberFormat nf = NumberFormat.getNumberInstance(Locale.FRANCE);//ni vraka 1,123, so zapirka
//      nf.setMaximumFractionDigits(10);//1,12345
//      //Locale swiss = new Locale("fr", "ch");//konstruktor za currency vo Shvajcarija
//      //NumberFormat nf = NumberFormat.getCurrencyInstance(swiss);//SFr. 1.12, gormat za 
//      //NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);//za sekoja nova klasa,ni vraka vo evra
////pravime nov object za da mozime da i gi koristime metodite
//      System.out.println(nf.format(d));
//      NumberFormat nf1 = NumberFormat.getCurrencyInstance();//vraka - Den 1,12, zatoa shto pc e od MK
//      System.out.println(nf1.format(d));
//      
//      NumberFormat nf2 = NumberFormat.getCurrencyInstance(Locale.US);
//      System.out.println(nf2.format(d));//vraka - $1.12 
//      
      
    }
 }

