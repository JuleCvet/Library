
package models;

import java.util.Date;
import java.util.GregorianCalendar;
import utilities.GenderType;

public class Customer {
    private String title;
    private String firstName;
    private String surName;
    private String address;
    private String phoneNumber;
    private String email;
    private int customerNumber;
    private GenderType gender;
    private boolean isvalid;
    private Date expiryDate;

    public Customer(String title, String firstName, String surName, String address,
            String phoneNumber, String email, int customerNumber, GenderType gender) {
        
//ni treba konstruktor za datumot, gledame vo bibliotekata jave.util za konstruktori
GregorianCalendar gCal = new GregorianCalendar();
gCal.add(GregorianCalendar.YEAR, 1);//mu dodavame edna godina vaznost
  this.expiryDate = gCal.getTime(); //setuvame koga ke ispari datata
        
        setName(title, firstName, surName);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerNumber = customerNumber;
        this.gender = gender;
        this.isvalid = true;
    }
    
    public void setName(String title, String firstName, String surName){
    this.title = title;
    this.firstName = firstName;
    this.surName = surName;
    
    }
    
    public String getMailingName(){
        
        StringBuilder sb = new StringBuilder(title);//moze da parse in ili string ili int vo konstruktorov
        sb.append(" ");
        sb.append(firstName.substring(0,1));
        sb.append(" ");
        sb.append(surName);
   
    return sb.toString();//ssakame string da vratime
    
    }
    
    //geter za date
    public Date getExpiryDate(){
    return expiryDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public boolean isIsvalid() {
        return isvalid;
    }

    public void setIsvalid(boolean isvalid) {
        this.isvalid = isvalid;
    }

    @Override//od Object klasata go prepishuva ovoj metod
    public String toString() {
        return getMailingName();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    
    
    
    
}
