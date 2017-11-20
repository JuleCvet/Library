
package models;

import java.util.TreeMap;

public interface MaterialCatalogInterface {
    
    public void addMaterial(Material newMaterial);
    public TreeMap<String, Material> getMaterialMap();//zema objekt od tip String, v-sti od tip Materijal, i vraka nova kolekcija
    public Material findMaterial(String title)throws MaterialNotFoundException;//ke vraka Material ako go najde, ako ne ke dade isklucok
    public int getNumberOfMaterial();//ke vraka int
    
    
}
