/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Caglar
 */
public class Customer {

    private int CustomerID;
    private String Name;
    private String Surname;

    public Customer() {
        CustomerID = 0;
        Name = "No-name";
        Surname = "No-Surname";
    }

    public Customer(int CustomerID, String Name, String Surname) {
        this.CustomerID = CustomerID;
        this.Name = Name;
        this.Surname = Surname;
    }

    public Customer(Customer originalObject) {
        CustomerID = originalObject.CustomerID;
        Name = originalObject.Name;
        Surname = originalObject.Surname;
    }

    /**
     * @return the CustomerID
     */
    public int getCustomerID() {
        return CustomerID;
    }

    /**
     * @param CustomerID the CustomerID to set
     */
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Surname
     */
    public String getSurname() {
        return Surname;
    }

    /**
     * @param Surname the Surname to set
     */
    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    @Override
    public String toString() {
        return "CustomerID=" + CustomerID + ", Name= " + Name + ", Surname= " + Surname;
    }

    /* public boolean equals(Object otherObject)
    {
      if(otherObject==null)
          return false;
      else if(getClass()!=otherObject.getClass())
          return false;
     
    
    
    }*/
}
