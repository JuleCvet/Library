
package models;

public class DVD extends Material{
    private String director;
    private String catalogNo;
    private int runningTime;
    private boolean licenced;

    public DVD(String id, String title, String branch, String director, String catalogNo, int runningTime) {
        super(id, title, branch);
        
        this.director = director;
        this.catalogNo = catalogNo;
        this.runningTime = runningTime;
        licenced = false;
    }
    
    public void licence(){
    licenced = true;
    
    } 
    
    public boolean lend(Customer customer){//ako dvd e licencirano - ke go izdademe, ako ne- false
 //ovoj metod go override od materijal parent klasata (i toj prvo se run)
 //zema dvd ili book i im gi dava na mushteriite. Moze da izdademe samo ako dr klient veke ne gi ima iznajmeno
 //za da im go prikazeme statusot na dvd/book, dali se iznajmeni ili ne, i ako se- na kogo se iznajmeni
 //zatoa pravime private varijable za pozajmuvacot
        if(licenced){//namesto da vraka true, da se run metodot od parent za lend i da vraka v-sta
        return super.lend(customer);
        }else
        {
        return false;
        }
    }
    
      public int getLoanPeriod(){
      return 7;
      }
      
        @Override
    public String toString() {
        return "DVD" + getID() + " " + getTitle() + " / " + director; //To change body of generated methods, choose Tools | Templates.
    }
}
