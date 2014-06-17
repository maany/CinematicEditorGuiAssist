/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.cinematic.gui.jfx;



import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.stage.Stage;

/**
 *
 * @author MAYANK
 */
public class CinematicEditorUI extends Application{
    TimelineControl timelineControl ;
   // TimelineUI timeline = new TimelineUI();
    LayerContainerControl layerContainer ;
    @Override
    public void start(Stage stage) throws Exception {
        layerContainer = new LayerContainerControl();
        timelineControl = new TimelineControl();
        Scene scene;
        scene = new Scene(layerContainer,440,205);
        stage.setScene(scene);
        stage.show();
        layerContainer.initLayerContainer();
        ScrollBar vScrollBar = layerContainer.getVScrollBar();
        System.out.println("ScrolBar : " + vScrollBar.toString());
        //   timelineControl.initTimeline();
        //timeline.test();
        //timeline.getCurrentTime().setValue(10);
    }
    public static void main(String args[])
    {
        launch(args);
    }
}
