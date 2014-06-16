/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.cinematic.gui.jfx;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author MAYANK
 */
public class CinematicEditorUI extends Application{
    TimelineControl timelineControl ;
    Timeline timeline = new Timeline();
    @Override
    public void start(Stage stage) throws Exception {
        timelineControl = new TimelineControl();
        Scene scene = new Scene(timelineControl,440,205);
        stage.setScene(scene);
        stage.show();
        timelineControl.initTimeline();
        //timeline.test();
        //timeline.getCurrentTime().setValue(10);
    }
    public static void main(String args[])
    {
        launch(args);
    }
}
