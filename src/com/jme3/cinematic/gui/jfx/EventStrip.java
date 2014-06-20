/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.cinematic.gui.jfx;

import com.jme3.gde.cinematic.core.Layer;
import com.jme3.gde.cinematic.gui.GuiManager;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author MAYANK
 */
public class EventStrip extends AnchorPane{
    private Layer layer;
    private List<EventControl> eventControls;
    public EventStrip(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("event_strip.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        
        try {
            loader.load();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        setPrefHeight(GuiManager.LAYER_HEIGTH);
        eventControls = new ArrayList<>();
        
    }
    public EventStrip(Layer layer){
        this();
        this.layer = layer;
    }

    public void render() {
        
    }
    public Layer getLayer() {
        return layer;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }

    public List<EventControl> getEventControls() {
        return eventControls;
    }

    public void setEventControls(List<EventControl> eventControls) {
        this.eventControls = eventControls;
    }
    
}
