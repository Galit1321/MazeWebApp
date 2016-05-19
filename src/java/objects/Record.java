/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * 
 */
public class Record {

    private double value;
    private String desc;
    private boolean deposite;

    public Record(double value, String desc, boolean deposite) {
        this.deposite = deposite;
        this.value = value;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public double getValue() {
        return value;
    }

    public boolean isDeposite() {
        return deposite;
    }
}
