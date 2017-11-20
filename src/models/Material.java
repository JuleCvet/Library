 package models;

public abstract class Material {

    private String id;
    private String title;
    private String branch;
    private Customer borrower;//od tipot na klasata customer e
    //ako ova varijabla pokazuva kon Customer - ke znaeme deka e iznajmena

    public Material(String id, String title, String branch) {
        this.id = id;
        this.title = title;
        this.branch = branch;
    }

    public String getTitle() {
        return title;
    }

    public String getID() {
        return id;
    }

    public void relocate(String newBranch) {
        this.branch = newBranch;//ja relocira branshata, ako e kniga- da odi vo biblioteka, ako e dvd

    }

    public boolean lend(Customer customer) {//na koj mushterija ke mu pozajmime/ovaj metod ne vazi za knigi
        //pretpostavuvame deka na site mushterii sme pozajmile
        if (borrower == null) {//ako ne e iznajmena, ke vratime deka e true(ne e iznajmena)
            borrower = customer;
            return true;
        } else {//ovoj metod eoverriden od DVD i zatoa kompletno e ignoriran. Sakame ako 
            //ima licenca DVD-to, da se run ovaj parent metod (a ne toj od DVD), so koristenje na SUPER()
            return false;//ova avtomatski ke se odrazi na Book klasata
        }
    }

    //kolku dolgo ke bidat iznajmuvani, 3nedeli za knigi, 1 nedela za DVD
    public abstract int getLoanPeriod();//int- zatoa shto ke vraka broj na denovi za iznajmuvanje

    @Override
    public String toString() {
        return id + " : " + title;
    }

    @Override
    public boolean equals(Object obj) {
        
        if(obj == null){
            return false;
        }
        if (getClass() == obj.getClass()) {//dali se vo ista klasa t.s isti tip
            //treba da go konvertirame  (other klass) vo varijabla od prav tip

            Material otherClass = (Material) obj;//frlanje na objektot vo tip od Materijal za da se isti
            //so shto dobivame 2 varijabli od isti tip
            if (id == otherClass.id) {//so int koristime == za da sporedime dali imaat isti ID
                return true;
            } else {
                return false;
            }
        }else
            {
            return false;
        }
    }
}
