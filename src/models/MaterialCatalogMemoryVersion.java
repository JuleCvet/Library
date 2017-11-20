
package models;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MaterialCatalogMemoryVersion implements MaterialCatalogInterface {
    
    private TreeMap<String, Material> materialMap;//plus konstruktor za inicijalizacija
    
    public MaterialCatalogMemoryVersion(){
    materialMap = new TreeMap<String, Material>();
    }
    
    public void addMaterial(Material newMaterial){//vnesuvame objekt so ime
    materialMap.put(newMaterial.getID(), newMaterial);//preku iD kako tip i 
    //vrednost(memoriska lokacija) na newMaterial koja pokazzuva kon nekoj objekt
    
    }
    
    //metod za: da lupa niz Map i da ni gi isprinta Title, koj ke vraka varijabla od TIP TREEMAP so ime getMap
    public TreeMap<String, Material> getMaterialMap(){//so index na String, i values na Materija;
    return materialMap;
    
    }
    
    public Material findMaterial(String title)throws MaterialNotFoundException{
        
        title = title.trim();//za da nema prazni mesta
        
        for (Material newMaterial : materialMap.values()){//za da lupa niz vrednostite vo objktite
         if(newMaterial.getTitle().equalsIgnoreCase(title)){
                return newMaterial;
        }
        }
    throw new MaterialNotFoundException();
    }
    
    public void printMaterialCatalog(TreeMap<String, Material> materialCatalog){//vnesuvame(parse in) lista od tip -book, bez da morame da specificirame golemina na nizata
   //zatoa shto ovde ne ja kreirame t.s vo main klasata. Mora da stavime znak za niza[] i imeto
       for (Material nextMaterial : materialCatalog.values()) {
            System.out.println(nextMaterial.toString());//go povikuvame metodot za prinBook od pogore, koj vraka katalogot so knigite vo counter 
       }
   }  

//    @Override
//    public TreeMap<String, Material> getMaterialMap() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public int getNumberOfMaterial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
