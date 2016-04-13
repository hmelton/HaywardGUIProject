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
public class DataSet {
    private Legend[] dimension;
    private DataPoint[] fact;
    @Override
    public String toString(){
        String outputStr = "";
        for(DataPoint point: fact){
            outputStr += point.toString();
            outputStr += "\n";
        }
        return outputStr;
    }
    public DataPoint[] getDataPoints(){
        return fact;
    }
    
}
