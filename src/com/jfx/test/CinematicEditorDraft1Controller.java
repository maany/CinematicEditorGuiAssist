/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfx.test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author MAYANK
 */
public class CinematicEditorDraft1Controller implements Initializable {
    @FXML 
    ScrollPane layerPane;
    @FXML
    ScrollPane timeline;
    @FXML
    TitledPane timebar;
    @FXML 
    Button btn;
    @FXML
    AnchorPane timelineAnchor;
    @FXML
    AnchorPane layerAnchor;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Initialize script run");
        
    }  
    @FXML
    public void btnClicked(ActionEvent evt){
        System.out.println("yoyoyoyo");
    } 
    @FXML
    public void verticalScroll(ScrollEvent evt)
    {
        System.out.println("Scrolling this");
        System.out.println("Current Pos of timeline: " + timelineAnchor.getTranslateY());
        System.out.println("Delta Y : " + evt.getDeltaY());
        timelineAnchor.setTranslateY(timelineAnchor.getTranslateY() + evt.getDeltaY());
        layerAnchor.setTranslateY(layerAnchor.getTranslateY()+evt.getDeltaY());
        System.out.println("New Pos: " + timelineAnchor.getTranslateY());
        System.out.println("");
        
    }
}
