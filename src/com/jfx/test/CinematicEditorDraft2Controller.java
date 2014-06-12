/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfx.test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
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
public class CinematicEditorDraft2Controller implements Initializable {

    @FXML
    ScrollBar vbar;
    @FXML
    VBox layerContainer;
    DoubleProperty vPos;

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vPos = new SimpleDoubleProperty();
        vPos.setValue(0);
        assert vbar != null : "fx:id=\"vbar\" was not injected: check your FXML file 'CinematicEditorDraft2.fxml'.";
        final double reference = layerContainer.getLayoutY();
        System.out.println("reference : " + reference + "scrollbarValue : " + vbar.getValue());


        /*
         vbar.valueProperty().addListener(new ChangeListener<Number>() {
         @Override
         public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
         double change = (layerContainer.getHeight() / vbar.getMax()) * vbar.getValue();
         System.out.println("change : " + change);
         double difference = t1.doubleValue()- t.doubleValue();
         System.out.println("Old Position :" + layerContainer.getLayoutY());
         System.out.println("Difference : " + difference);
         System.out.println("New Position : " + (reference-difference));
                 
                
         layerContainer.setLayoutY(reference - change);
         //System.out.println("ExactPosition : " + layerContainer.getLayoutY());
         //System.out.println("t = " + t.doubleValue() + " t1 : " + t1.doubleValue() + "(diff) : " + (t1.doubleValue()-t.doubleValue()));
         //System.out.println("Value : " + ov.getValue() + "Position : " + layerContainer.getTranslateY());
         }
         }); 
         */
//**************************** BINDING ******************//
        DoubleBinding layoutYToVPosBinding = new DoubleBinding() {
            {
                super.bind(vPos);
            }
            double upperLimit = vbar.getPrefHeight() - layerContainer.getLayoutY() + layerContainer.getPrefHeight();
            double lowerLimit = layerContainer.getLayoutY();
            
            @Override
            protected double computeValue() {
                System.out.println("Upper Limit : " + upperLimit + " Lower Limit : " + lowerLimit);
                double ratio = (lowerLimit - upperLimit)/vbar.getMax();
                if(ratio<0)
                    ratio*=-1;
                System.out.println("Ratio : " + ratio);
                double newPos = upperLimit + ratio*vPos.doubleValue();
                System.out.println("new Pos : " + newPos);
                if (newPos >= upperLimit && newPos <= lowerLimit) {
                    System.out.println("In Middle");
                    return newPos;
                } else if (newPos < upperLimit) {
                    System.out.println("At upper Limit");
                    return upperLimit;
                } else if (newPos > lowerLimit) {
                    System.out.println("At lower Limit");
                    return lowerLimit;

                }
                return 0;
            }
        };

         layerContainer.layoutYProperty().bind(layoutYToVPosBinding);
        //vbar.valueProperty().bindBidirectional(vPos);
      
        
        
        
        
        
        /*layerContainer.setOnScroll(new EventHandler<ScrollEvent>() {
            double upperLimit = vbar.getPrefHeight() - layerContainer.getLayoutY() + layerContainer.getPrefHeight();
            double lowerLimit = layerContainer.getLayoutY();

            @Override
            public void handle(ScrollEvent evt) {
                double newPos = layerContainer.getLayoutY() + evt.getDeltaY();
                System.out.println("Layer Container Height : " + layerContainer.getHeight());
                System.out.println("Scroll Detected.\n After this Scroll position will be : " + newPos);
                System.out.println("lower Limit : " + lowerLimit + " upper Limit : " + upperLimit);
                if (newPos >= upperLimit && newPos <= lowerLimit) {
                    layerContainer.setLayoutY(newPos);
                    System.out.println("In Middle");
                } else if (newPos < upperLimit) {
                    layerContainer.setLayoutY(upperLimit);
                    System.out.println("At upper Limit");
                } else if (newPos > lowerLimit) {
                    layerContainer.setLayoutY(lowerLimit);
                    System.out.println("At lower Limit");
                }
            }
        }); */

    } 

    
}
