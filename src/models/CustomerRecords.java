
package models;

import java.util.HashSet;

public class CustomerRecords {
    
    private HashSet<Customer> records;
    
    public CustomerRecords(){//konstruktor
        
      records = new HashSet<Customer>();  
    }
    
    public void add(Customer customer){//od tip Customer
    records.add(customer);
    
    }
    
    public Customer findByName(String name)throws customerNotFoundException{//ke vrati Customer, parse in- String, za da barame po ime
        for(Customer customer : records){//looping in object Customer, ke gi vikame customer, ke bidat od setot: records
            if(customer.getMailingName().equals(name)){//ako dojdeme do ovde znaci sme go nashle mushterijata
                return customer;
            } 
    }
   throw new customerNotFoundException();     
    }
}

