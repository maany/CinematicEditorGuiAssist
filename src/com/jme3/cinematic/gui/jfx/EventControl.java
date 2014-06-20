/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.cinematic.gui.jfx;

import com.jme3.gde.cinematic.core.Event;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * Provides the graphical representation of {@link com.jme3.gde.cinematic.core.Event}. 
 * Manages features like changing duration, start point, assigning color to event via the Editor
 * @author MAYANK
 */
public class EventControl extends Button {
    private Event event;
    private EventStrip eventStrip;
    public EventControl(Event event, String string, Node eventStrip) {
        super(string, eventStrip);
        this.event = event;
        this.setText(event.getName());
        this.setMaxWidth(USE_PREF_SIZE);
        this.setMaxHeight(USE_PREF_SIZE);
        this.setAlignment(Pos.CENTER);
        this.setLayoutX(0);
        this.setLayoutY(0);
    }
    
    public void render(){
        refactorDisplay(1);
    }
    public void refactorDisplay(double magnification){
        double width = magnification*event.getDuration();
        double startPoint = magnification*event.getStartPoint();
        setWidth(width);
        setTranslateX(startPoint);
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public EventStrip getEventStrip() {
        return eventStrip;
    }

    public void setEventStrip(EventStrip eventStrip) {
        this.eventStrip = eventStrip;
    }
    
}
