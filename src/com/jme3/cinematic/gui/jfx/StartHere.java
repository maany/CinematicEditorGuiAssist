/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.cinematic.gui.jfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author MAYANK
 */
public class StartHere extends Application{
    CinematicEditorUI cinematicEditor;
    TimelineControl timeline;
    LayerContainerControl layerContainer;
    Scene scene;
    @Override
    public void start(Stage stage) throws Exception {
        launchCinematicEditor(stage);
        //launchTimeline(stage);
        //launchLayerContainer(stage);
        
    }
    public void launchCinematicEditor(Stage stage) {
        cinematicEditor = new CinematicEditorUI();
        scene = new Scene(cinematicEditor,660,220);
        stage.setScene(scene);
        stage.show();
        cinematicEditor.initCinematicEditorUI();
    }
    public void launchTimeline(Stage stage){
        timeline = new TimelineControl();
        scene = new Scene(timeline,440,220);
        
        stage.setScene(scene);
        stage.show();
        timeline.initTimeline();
    }
    public void launchLayerContainer(Stage stage){
        layerContainer = new LayerContainerControl();
        scene = new Scene(layerContainer,220,220);
        stage.setScene(scene);
        stage.show();
        layerContainer.initLayerContainer();
    }
    public static void main(String args[]) {
        launch(args);
    }
}
