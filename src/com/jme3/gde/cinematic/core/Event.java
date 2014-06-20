/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.gde.cinematic.core;

import javafx.scene.control.Button;

/**
 * 
 * @author MAYANK
 */
public class Event {
    private Layer layer;
    private String name;
    private double duration;
    private double startPoint;

    public Event() {
        
    }
    public Event(String name, Layer layer,double startPoint,double duration ) {
        this.layer = layer;
        this.name = name;
        this.duration = duration;
        this.startPoint = startPoint;
    }
    
    public void offset(double offset) {
        startPoint+=offset;
    }

    
    
    public Layer getLayer() {
        return layer;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(double startPoint) {
        this.startPoint = startPoint;
    }
    
}
