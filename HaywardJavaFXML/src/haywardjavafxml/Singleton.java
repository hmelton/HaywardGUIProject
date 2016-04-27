/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haywardjavafxml;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Singleton implements java.io.Serializable{
    private transient static Singleton instance;
    private static double maxSliderVal;
    private static double minSliderVal;
    
    private Singleton(){}

    public void save(){
        init();
        try {
           FileOutputStream fileOut = new FileOutputStream("Settings.ser");
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(instance);
           out.close();
           fileOut.close();
           System.out.printf("Serialized data is saved in Settings.ser");
        }catch(IOException i) {
            i.printStackTrace();
        }    
    }
    
    public static void init(){
        if (instance == null) {
            try{
               FileInputStream fileIn = new FileInputStream("Settings.ser");
               ObjectInputStream in = new ObjectInputStream(fileIn);
               instance = (Singleton) in.readObject();
               in.close();
               fileIn.close();
            }catch(IOException i){
               instance = new Singleton();
               return;
            }catch(ClassNotFoundException c){
               System.out.println("Singleton class not found");
               c.printStackTrace();
               return;
            }            
        }
    }
    
    public static void setMinSlider(double val){
        init();
        minSliderVal = val;
    }
    
    public static void setMaxSlider(double val){
        init();
        maxSliderVal = val;
    }
    
    public static double getMaxSlider(){
        init();
        return maxSliderVal;
    }
    
    public static double getMinSlider(){
        init();
        return minSliderVal;
    }
    
}
