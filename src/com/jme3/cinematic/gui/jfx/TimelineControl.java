/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.cinematic.gui.jfx;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 *
 * @author MAYANK
 */
public class TimelineControl extends VBox {

    @FXML
    private Group timebarTimesliderGroup;
    @FXML
    private Slider timebar;
    @FXML
    private Separator timeslider;
    @FXML
    private ScrollPane timelineScrollPane;
    @FXML
    private VBox timelineScrollPaneVBox;

    private DoubleProperty currentTime = new SimpleDoubleProperty(0);
    private double endAdjustment = 8; // timebar extra width due to circular thumb of slider
    private double startAdjustment = 6.5;
    public TimelineControl() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("timeline_ui_control.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        //initListeners();
    }

    public final void initListeners() {

        
        timelineScrollPane.hvalueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                double extraDistance = timelineScrollPaneVBox.getPrefWidth() - timelineScrollPane.getPrefWidth();
                double timebarHVal = -1 * t1.doubleValue() * extraDistance;
                timebarTimesliderGroup.setTranslateX(timebarHVal);
            }
        });
        
        timebar.valueProperty().addListener(new ChangeListener<Number>(){

            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                currentTime.setValue(t1);
            }
        });
        
        currentTime.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                if (timebar.getValue() != t1) {
                    timebar.setValue(t1.doubleValue());
                }
                boolean isTimesliderSync;
                double expectedPosition = (timebar.getWidth()-endAdjustment-startAdjustment) * timebar.getValue() / timebar.getMax();
                expectedPosition+=startAdjustment;
                isTimesliderSync = timeslider.getTranslateX() == expectedPosition;
                System.out.println("Expected Position : " + expectedPosition);
                if (!isTimesliderSync) {
                    timeslider.setLayoutX(expectedPosition);
                }
            }
        });
        
        enableTimesliderDrag();
    }
class Delta { double x, currentTime; }
    private void enableTimesliderDrag() {
        final Delta dragDelta = new Delta();
        
        timeslider.setOnMouseEntered(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent t) {
                timeslider.getScene().setCursor(Cursor.H_RESIZE);
            }
        
        });
        
        timeslider.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // record a delta distance for the drag and drop operation.
                dragDelta.x = timeslider.getLayoutX() - mouseEvent.getX();

            }
        });
        
        timeslider.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                double newPos = mouseEvent.getX() + dragDelta.x;
                dragDelta.currentTime = timebar.getMax()*newPos/(timebar.getWidth()-endAdjustment-startAdjustment);
                currentTime.set(dragDelta.currentTime);
                System.out.println("Mouse Dragged");
            }
        });
        timeslider.setOnMouseExited(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent t) {
                timeslider.getScene().setCursor(Cursor.DEFAULT);
            }
        
        });
        
        
    }

    
}
