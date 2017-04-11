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
public class InternationalCustomer extends Customer {

    private String Country;
    private String City;
    private String karekter;

    public InternationalCustomer() {
        super();
        Country = "No-country";
        City = "No-city";
    }

    public InternationalCustomer(int CustomerID, String Name, String Surname, String Country, String City) {
        super(CustomerID, Name, Surname);
        this.Country = Country;
        this.City = City;

    }

    public InternationalCustomer(InternationalCustomer originalObject) {
        super(originalObject);
        Country = originalObject.Country;
        City = originalObject.City;
    }

    @Override
    public String toString() {

        return "InternationalCustomer= " + super.toString() + ", Country= " + Country + ", City= " + City;
    }

    /**
     * @return the Country
     */
    public String getCountry() {
        return Country;
    }

    /**
     * @param Country the Country to set
     */
    public void setCountry(String Country) {
        this.Country = Country;
    }

    /**
     * @return the City
     */
    public String getCity() {
        return City;
    }

    /**
     * @param City the City to set
     */
    public void setCity(String City) {
        this.City = City;
    }

}
