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
public class NationalCustomer extends Customer {

    private int LicencePlateNumber;
    private String Occupation;
    private String karekter;

    public NationalCustomer() {
        super();
        LicencePlateNumber = 0;
        Occupation = "No-Occupation";
    }

    public NationalCustomer(int CustomerID, String Name, String Surname, int LicencePlateNumber, String Occupation) {
        super(CustomerID, Name, Surname);
        this.LicencePlateNumber = LicencePlateNumber;
        this.Occupation = Occupation;

    }

    public NationalCustomer(NationalCustomer originalObject) {
        super(originalObject);
        LicencePlateNumber = originalObject.LicencePlateNumber;
        Occupation = originalObject.Occupation;
    }

    @Override
    public String toString() {
        return "NationalCustomer= " + super.toString() + ", LicencePlateNumber= " + LicencePlateNumber + ", Occupation= " + Occupation;
    }

    /**
     * @return the LicencePlateNumber
     */
    public int getLicencePlateNumber() {
        return LicencePlateNumber;
    }

    /**
     * @param LicencePlateNumber the LicencePlateNumber to set
     */
    public void setLicencePlateNumber(int LicencePlateNumber) {
        this.LicencePlateNumber = LicencePlateNumber;
    }

    /**
     * @return the Occupation
     */
    public String getOccupation() {
        return Occupation;
    }

    /**
     * @param Occupation the Occupation to set
     */
    public void setOccupation(String Occupation) {
        this.Occupation = Occupation;
    }

}
