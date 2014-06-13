/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfx.test;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventType;

/**
 * FXML Controller class
 *
 * @author MAYANK
 */
public class CinematicEditorDraft1Controller implements Initializable {
    @FXML
    TitledPane layerPaneSuperHolder;
    @FXML
    AnchorPane layerPaneHolder;
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
    @FXML
    ScrollBar vbar;
    
    

    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        assert timebar != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        if(layerPane!=null)
            System.out.println("layerPane is not null");
        //timelineAnchor.layoutYProperty().bindBidirectional(layerAnchor.layoutYProperty());
        System.out.println("Initialize script run 1 ");
        System.out.println("position of layerPane" + timebar.getLayoutX() + " y: " +timebar.getLayoutY());
        Set<Node> nodes = layerPane.lookupAll(".scroll-bar");
        System.out.println("No of elemetns : " + nodes.size());
        
        for (final Node node : nodes) {
            System.out.println("node :" + node.getId() + " : " + node.toString());
            if (node instanceof ScrollBar) {
                ScrollBar sb = (ScrollBar) node;
                if (sb.getOrientation() == Orientation.VERTICAL) {
                    System.out.println("vertical scrollbar visible = " + sb.isVisible());
                    System.out.println("width = " + sb.getWidth());
                    System.out.println("height = " + sb.getHeight());
                }
            }
        }
        
    }  
    @FXML
    public void btnClicked(ActionEvent evt){
        System.out.println("yoyoyoyo");
        ScrollBar vbar = null ;
        ScrollBar vbarTimeline = null;
        Set<Node> nodes = layerPane.lookupAll(".scroll-bar");
        System.out.println("size after button" + nodes.size());
        for (final Node node : nodes) {
            System.out.println("node :" + node.getId() + " : " + node.toString());
            if (node instanceof ScrollBar) {
                ScrollBar sb = (ScrollBar) node;
                if (sb.getOrientation() == Orientation.VERTICAL) {
                    System.out.println("vertical scrollbar visible = " + sb.isVisible());
                    System.out.println("width = " + sb.getWidth());
                    System.out.println("height = " + sb.getHeight());
                    vbar = sb;
                }
            }
        }
       Set<Node> nodesTimeline = timeline.lookupAll(".scroll-bar");
        for (final Node node : nodesTimeline) {
            System.out.println("node :" + node.getId() + " : " + node.toString());
            if (node instanceof ScrollBar) {
                ScrollBar sb = (ScrollBar) node;
                if (sb.getOrientation() == Orientation.VERTICAL) {
                    System.out.println("vertical scrollbar visible = " + sb.isVisible());
                    System.out.println("width = " + sb.getWidth());
                    System.out.println("height = " + sb.getHeight());
                    vbarTimeline = sb;
                }
            }
        }
        
        vbarTimeline.valueProperty().bind(vbar.valueProperty());
        /*vbar.valueProperty().addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue<? extends Number> ov,
        Number old_val, Number new_val) {
            //timelineAnchor.setLayoutY(-new_val.doubleValue());
            timelineAnchor.setTranslateY(timelineAnchor.getTranslateY() - new_val.doubleValue());
            layerAnchor.setTranslateY(layerAnchor.getTranslateY() - new_val.doubleValue());
            System.out.println("SCROLLING MAN");
        }
    });*/
    }
    /*@FXML
    public void verticalScroll(ScrollEvent evt)
    {
        System.out.println("Scrolling this");
        System.out.println("Current Pos of timeline: " + timelineAnchor.getTranslateY());
        System.out.println("Delta Y : " + evt.getDeltaY());
        timelineAnchor.setTranslateY(timelineAnchor.getTranslateY() + evt.getDeltaY());
        layerAnchor.setTranslateY(layerAnchor.getTranslateY()+evt.getDeltaY());
        System.out.println("New Pos: " + timelineAnchor.getTranslateY());
        System.out.println("");
        
    }*/
}
