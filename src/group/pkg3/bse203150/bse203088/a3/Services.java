/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group.pkg3.bse203150.bse203088.a3;

/**
 *
 * @author sahaf
 */
public class Services {
     private String name;
    private String date;
    private int charges;
    private int pat_id;
    private String pat_name;
    public Services(String name, String date, int charges) {
        this.name = name;
        this.date = date;
        this.charges = charges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    public int getPat_id() {
        return pat_id;
    }

    public void setPat_id(int pat_id) {
        this.pat_id = pat_id;
    }

    public String getPat_name() {
        return pat_name;
    }

    public void setPat_name(String pat_name) {
        this.pat_name = pat_name;
    }

    public Services(String name, String date, int charges, int pat_id, String pat_name) {
        this.name = name;
        this.date = date;
        this.charges = charges;
        this.pat_id = pat_id;
        this.pat_name = pat_name;
    }
}
