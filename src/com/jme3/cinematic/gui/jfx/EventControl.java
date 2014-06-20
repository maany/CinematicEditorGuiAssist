/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.cinematic.gui.jfx;

import com.jme3.gde.cinematic.CinematicEditorManager;
import com.jme3.gde.cinematic.core.DurationChangeListener;
import com.jme3.gde.cinematic.core.Event;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * Provides the graphical representation of {@link com.jme3.gde.cinematic.core.Event}. 
 * Manages features like changing duration, start point, assigning color to event via the Editor
 * @author MAYANK
 */
public class EventControl extends Button implements DurationChangeListener{
    private Event event;
    
    private double magnification=1;
    public EventControl(Event event) {
        super(event.getName());
        this.event = event;
        this.setMaxWidth(USE_PREF_SIZE);
        this.setMaxHeight(USE_PREF_SIZE);
        this.setAlignment(Pos.CENTER);
        this.setLayoutX(0);
        this.setLayoutY(0);
        CinematicEditorManager.getInstance().getCurrentClip().getDurationChangeListeners().add(this);
        
    }
    /**
     * Renders the event in the appropriate position in the Eventstrip. It takes into account the magnification 
     * and duration of clip.
     */
    public void render() {
        double clipDuration = CinematicEditorManager.getInstance().getCurrentClip().getDuration();
        EventStrip eventStrip = (EventStrip)getParent();
        double editorWidth = eventStrip.getTimeline().getPrefWidth();
        double width = event.getDuration()*editorWidth/clipDuration;
        double startX = event.getStartPoint()*editorWidth/clipDuration;
        setPrefWidth(width);
        setTranslateX(startX);
        
    }
    /**
     * When duration changes, event startPoint and width are adjusted automatically by this method
     */
     @Override
    public void durationChanged() {
        render();
    }

    /**
     * When magnification or duration changes, the event's start point and width will change. 
     * This method refactors the startPoint and width to keep the event in sync with the timebar
     * @param magnification 
     */
     @Deprecated
    public void refactorDisplay(double magnification){
        double clipDuration = CinematicEditorManager.getInstance().getCurrentClip().getDuration();
        this.magnification = magnification;
        double width = magnification*getPrefWidth();
        double startPoint = magnification*event.getStartPoint()/clipDuration;
        setPrefWidth(width);
        setTranslateX(startPoint);
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
