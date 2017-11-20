

package ui;

import java.util.TreeMap;
import models.Book;
import models.Material;

public class UI {
    
    public void printHeader(){//print heder
        System.out.println("BookID  Title                 Author");
    }
    
    
    public void printBook(Book book){//sakame da pecatime autor, id, title//BOOK PRINT
    //ni trebaat metodite get za site- vo klasata Book
    //String bookIdString = String.valueOf(book.getBookID());//so metodi na String objectot, int go konvertirame vo string
        System.out.println(fixLengthString(book.getID(), 6)+ "  " + fixLengthString(book.getTitle(), 20)
                + "  " + fixLengthString(book.getAuthor(), 20));
    //go koristi podolniot metod za da ja sredi dolzzinata so atributot int length - na tip Strig. Ama get bookID e int
    //1. moze da go konvertirame vo strinf so kreiranje na nova string, kade potoa ke go vmetne int (parse in)
    //2. vo podolniot metod da dodademe da prifaka i int
    }
    
    private String fixLengthString(String start, int length){//konvert int vo string 
    if(start.length() >= length){
    return start.substring(0, length);
        }
    else{
        while(start.length() < length){
        start += " ";
        
        }   
        return start;
    }
  }
    
   private String fixLengthString(int start, int length){ //overloaded, java bira spored parametrite- koj metod da go povika
       String startString = String.valueOf(start);//ja konvertirame stringot vo int. Moze i cel kod od pogore da se kopirat
       return fixLengthString(startString, length);
       
   } 
//    public void printBookCatalog(TreeMap<String, Book> BookCatalog){//vnesuvame(parse in) lista od tip -book, bez da morame da specificirame golemina na nizata
//   //zatoa shto ovde ne ja kreirame t.s vo main klasata. Mora da stavime znak za niza[] i imeto
//       for (Book nextBook : BookCatalog.values()) {
//           printBook(nextBook);//go povikuvame metodot za prinBook od pogore, koj vraka katalogot so knigite vo counter 
//       }
//   } 
   
   
   public void printMaterialCatalog(TreeMap<String, Material> materialCatalog){//vnesuvame(parse in) lista od tip -book, bez da morame da specificirame golemina na nizata
   //zatoa shto ovde ne ja kreirame t.s vo main klasata. Mora da stavime znak za niza[] i imeto
       for (Material nextMaterial : materialCatalog.values()) {
            System.out.println(nextMaterial.toString());//go povikuvame metodot za prinBook od pogore, koj vraka katalogot so knigite vo counter 
       }
   }   
}
