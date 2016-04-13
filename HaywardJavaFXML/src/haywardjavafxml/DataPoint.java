/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haywardjavafxml;

/**
 *
 * @author brucemelton
 */
public class DataPoint {
    private DataPointInfo dim;
    private int Value;
    @Override
    public String toString(){
        return dim.getCountry() + ": " + Value + "% immunized";
    }
    public int getValue(){
        return Value;
    }
    public String getCountry(){
        return dim.getCountry();
    
    }
}
