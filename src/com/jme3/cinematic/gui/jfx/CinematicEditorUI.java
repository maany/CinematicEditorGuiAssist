/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.cinematic.gui.jfx;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author MAYANK
 */
public class CinematicEditorUI extends AnchorPane{
    @FXML
    TimelineControl timeline ;
    @FXML
    LayerContainerControl layerContainer ;
    
    public CinematicEditorUI() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CinematicEditorUI.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
            
        }catch(Exception ex)
        {
            System.out.println("Failed to load CinematicEditorUI.fxml");
        }
        
    }
    public void initCinematicEditorUI() {
        timeline.initTimeline();
        layerContainer.initLayerContainer();
    }
    public void start(Stage stage) throws Exception {
       /* layerContainer = new LayerContainerControl();
        timeline = new TimelineControl();
        Scene scene;
        scene = new Scene(layerContainer,440,205);
        stage.setScene(scene);
        stage.show();
        layerContainer.initLayerContainer();
        ScrollBar vScrollBar = layerContainer.getVScrollBar();
        System.out.println("ScrolBar : " + vScrollBar.toString()); */
        //   timelineControl.initTimeline();
        //timeline.test();
        //timeline.getCurrentTime().setValue(10);
    }
    
}
