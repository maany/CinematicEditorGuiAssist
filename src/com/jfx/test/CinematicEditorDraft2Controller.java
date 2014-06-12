/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfx.test;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollBar;
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
         System.out.println("reference : " + reference);
         vbar.valueProperty().addListener(new ChangeListener<Number>(){
             
             @Override
             public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                 double difference = t1.doubleValue()- t.doubleValue();
                 System.out.println("Old Position :" + layerContainer.getLayoutY());
                 System.out.println("Difference : " + difference);
                 System.out.println("New Position : " + (reference-difference));
                 layerContainer.setLayoutY(layerContainer.getLayoutY()- difference);
                 System.out.println("ExactPosition : " + layerContainer.getLayoutY());
                 //System.out.println("t = " + t.doubleValue() + " t1 : " + t1.doubleValue() + "(diff) : " + (t1.doubleValue()-t.doubleValue()));
                 //System.out.println("Value : " + ov.getValue() + "Position : " + layerContainer.getTranslateY());
             }
         
         
         });
    }
}
