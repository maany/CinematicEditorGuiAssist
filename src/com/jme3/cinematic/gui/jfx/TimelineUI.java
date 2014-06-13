/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.cinematic.gui.jfx;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author MAYANK
 */
public class TimelineUI extends VBox {

    @FXML
    private Slider timebar;
    @FXML
    private StackPane timelineStackPane;
    @FXML
    private ScrollPane timelineScrollPane;
    @FXML
    private VBox timelineVBox;

    DoubleProperty vPos = new SimpleDoubleProperty();
    DoubleProperty hPos = new SimpleDoubleProperty();
    public TimelineUI() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("timeline_ui.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void test() {
        System.out.println("Connected to TimelineUI");
    }
    /*********** Listeners ***************/
    public void initListeners() {
        hPos.addListener(new ChangeListener<Number>(){

            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                
            }
        
        });
    }
    /***************** DURATION ******************/
    public void setDuration(double duration)
    {
        timebar.setMax(duration);
    }
    public double getDuration()
    {
        return timebar.getMax();
    }
}
