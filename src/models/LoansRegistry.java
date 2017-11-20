
package models;

import java.util.ArrayList;
import utilities.LoanStatusType;

public class LoansRegistry {
    
    //private int nextPosition;//ovaa pozicija ke ni ja zacuvvuva v-sta i ke ja pokazuvaa slednata slobodna pozicija vo nizata
    private ArrayList<Loan> registry;//ni treba lista od tip Loan, so ime registry
    //vo konstrukt. sakame da ja inicijalizirame nizata
    public LoansRegistry(){
    registry = new ArrayList<Loan>();//ja inicijalizirame nizata
    //nextPosition = 0;//da pocnuva od prvata pozicija vo nizata
    
    }
    
    
    //add loan metod ni treba shto ke dade isklucok ako knigata veke e iznajmena, kreirame klasa za exceptions
    public void addLoan(Loan loan)throws LoanAlreadyExistsException{//zema varijabla od tip Loan i vraka isklucok
    //da proverime vo nizta dali ovaa kniga e tamu so loop i da znam kolku itemi ima tamu- 
    //ni treba extra varijabla vo klasata .Vo slucaj IF- dava throw exception
    
    if(registry.contains(loan))
    {
        throw new LoanAlreadyExistsException();
    }
    
    registry.add(loan);
        //for (int i = 0; i < nextPosition; i++) {
           
            //ako loan e vnesen vo metodov kako parameter == na loan koja shto e vo nizata
            //if(registry[i].equals(loan)){//ako bilo koja pozicija vo nizata se sovpaga so taa (knigata)
                //shto mushterijata ja bara, znaci deka knigata e iznajmena i treba da frlime isklucok
                
                //ovaj isklucok nie go pravime sami i nishto dr vo ovoj metod nema da run
                //ako e throws, togash samata jvk go rshava i isfrla, ostavame na nea
       
        //posle for prodolzzuvame vo slucaj knigata da NE e iznajmena, ja dodavame 
        //vo nizata vo slednata slobodna pozicija za iznajmuvanje
        //registry[nextPosition] = loan;//nashata kniga za iznajmuvanje "loan" ja stavame vo nizata vo nextPosition
        //nextPosition++;//slednata pozicija ja sprmame za slednata kniga shto treba da se iznajmi
    }
    
    
    
    public Loan findLoan(String bookID)throws LoanNotFoundException{//ke vrati tip na "loan",
        //i zema int od ID-to na knigata
        
        for(Loan loan : registry){
            if(loan.getBook().getID().equals(bookID) && loan.getStatus()==LoanStatusType.CURRANT){//ako loan od nizata ima book so 
        //takov id== so baraniot id, i status momentalno iznajmena - sme ja nashle knigata pa ke ja vratime za pozajmuvanje da odit
        return loan;//ke ja izvadi knigata koja e vo taa pozicija vo nizata i ke ni ja dade/return it
        //nas ni trebaat samo tie shto imaat status currant, pa treba i toa da go sporedime 
    }
        //ako ne vratila nishto vo loop, ne e najdena knigata, da isfrli isklucok
        
        } 
        throw new LoanNotFoundException();
    }
    //dali knigata e iznajmena ili ne - metod. 
    //Mozeme da go iskoristime pogorniot metod za da vidime dali postoi loan za taa kniga. 
    //rezultatot ke go stornirame kako tip- LOAN
    

   public boolean isBookOnLoan(String bookID)
    {
    
    try{
        Loan foundLoan = findLoan(bookID);//ako e najdena, treba da vraka true
        return true;
    }
    catch(LoanNotFoundException e){
        return false;//ako knigata ne e najdena
            }
        }
    }




    

