/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haywardjavafxml;


import java.util.*;
import com.google.gson.*;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Slider;
import javafx.scene.media.AudioClip;


/**
 *
 * @author csstudent
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private BarChart chart;
    
    @
    FXML
    private Slider minSlider;
    
    @
    FXML
    private Slider maxSlider;
    
    public DataSet dataSet;
    
    @
    FXML
    private void handleChangeSlider(){
        chart.getData().clear();
        BarChart.Series immunizedSeries = new BarChart.Series();
        
        for(DataPoint data : dataSet.getDataPoints()){
            if((data.getValue() >= minSlider.getValue()) && (data.getValue() <= maxSlider.getValue())){
                if(data.getCountry()!=null){
                     immunizedSeries.getData().add(new BarChart.Data(data.getCountry(), data.getValue()));
                }
            }
        }
        chart.getData().add(immunizedSeries);
        AudioClip sound = new AudioClip(getClass().getResource("CanonInD.mp3").toString());
        sound.play();
    }
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String s = "http://apps.who.int/gho/athena/data/GHO/WHS4_544.json?profile=simple&filter=YEAR:1980";
        URL myUrl = null;
        try {
            myUrl = new URL(s);
        } catch (Exception e) {
            System.out.println("Improper URL " + s);
            System.exit(-1);
        }
     //
        // read from the URL
        Scanner scan = null;
        try {
            scan = new Scanner(myUrl.openStream());
        } catch (Exception e) {
            System.out.println("Could not connect to " + s);
            System.exit(-1);
        }
        
        String str = new String();
        while (scan.hasNext()) {
            str += scan.nextLine() + "\n";
        }
        scan.close();
        
        Gson myGSON = new Gson();
        DataSet immunizations = myGSON.fromJson(str, DataSet.class);
        dataSet  = immunizations;
        chart.getData().clear();
        BarChart.Series immunizedSeries = new BarChart.Series();
        
        for(DataPoint data : dataSet.getDataPoints()){
            if(data.getCountry()!=null){
                     immunizedSeries.getData().add(new BarChart.Data(data.getCountry(), data.getValue()));
            } 
        }
        chart.getData().add(immunizedSeries);
        
    }    
    @Override
    public final void stop(){
        Singleton.init();
    }
    
    
}
