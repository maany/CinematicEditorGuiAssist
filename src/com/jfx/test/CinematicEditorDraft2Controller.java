/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfx.test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.VBox;

/**
 *
 * @author MAYANK
 */
public class CinematicEditorDraft2Controller implements Initializable{
 
    @FXML
    ScrollBar vbar;
    @FXML
    VBox layerContainer;
    @FXML
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         assert vbar != null : "fx:id=\"vbar\" was not injected: check your FXML file 'CinematicEditorDraft2.fxml'.";
         final double reference = layerContainer.getLayoutY();
         System.out.println("reference : " + reference + "scrollbarValue : " + vbar.getValue());
        /* vbar.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                double change = (layerContainer.getHeight() / vbar.getMax()) * vbar.getValue();
                System.out.println("change : " + change);
                //double difference = t1.doubleValue()- t.doubleValue();
                System.out.println("Old Position :" + layerContainer.getLayoutY());
                 System.out.println("Difference : " + difference);
                 System.out.println("New Position : " + (reference-difference));
                 
                
                layerContainer.setLayoutY(reference - change);
                //System.out.println("ExactPosition : " + layerContainer.getLayoutY());
                //System.out.println("t = " + t.doubleValue() + " t1 : " + t1.doubleValue() + "(diff) : " + (t1.doubleValue()-t.doubleValue()));
                //System.out.println("Value : " + ov.getValue() + "Position : " + layerContainer.getTranslateY());
            }
        }); */

         
         layerContainer.setOnScroll(new EventHandler<ScrollEvent>(){

             @Override
             public void handle(ScrollEvent t) {
                 System.out.println("Scroll detected");
                 System.out.println("deltaY : " + t.getDeltaY()) ;
                 System.out.println("Position before : " + layerContainer.getLayoutY());
                 
                 //System.out.println("Min Y : " + layerContainer.getBoundsInLocal().getMinY() + " MaxY : " + layerContainer.getBoundsInLocal().getMaxY());
                 double limit = reference - layerContainer.getLayoutY();
                 System.out.println("Limit : " + limit);
                 if(limit>0 && limit<layerContainer.getHeight())
                 {
                    layerContainer.setLayoutY(layerContainer.getLayoutY() + t.getDeltaY());
                 }
                 if(limit==0 && t.getDeltaY()>0)
                     layerContainer.setLayoutY(layerContainer.getLayoutY() + t.getDeltaY());
                 if(limit==reference + layerContainer.getHeight() && t.getDeltaY()<0)
                     layerContainer.setLayoutY(layerContainer.getLayoutY() + t.getDeltaY());
                 System.out.println("Position after : " + layerContainer.getLayoutY());
                  
                 
                 
                /* if(vbar.getValue()>=vbar.getMin() && vbar.getValue()<=vbar.getMax())
                 {
                    
                    double change = (vbar.getMax()/layerContainer.getHeight())*t.getDeltaY();
                     System.out.println("Changed Value = " + change);
                    vbar.setValue(-change);
                 } */
             }
         
         });
         
    }
    @FXML
    public void layerScroll(ScrollEvent evt) {
        System.out.println("Scroll detected");
        vbar.setValue(evt.getDeltaY());
    }
}
