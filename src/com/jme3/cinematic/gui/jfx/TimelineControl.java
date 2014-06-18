/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.cinematic.gui.jfx;

import com.jme3.gde.cinematic.core.Layer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

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
    @FXML
    private Slider zoom;
    @FXML
    private ToggleButton snapToggle;
    @FXML
    private AnchorPane anchor;
    @FXML
    private TextField durationInput;
    @FXML
    private StackPane timebarTimeSliderStackPane;
    @FXML
    private Group timebarTimesliderSuperGroup;
    private DoubleProperty currentTime = new SimpleDoubleProperty(0);
    private DoubleProperty magnification = new SimpleDoubleProperty();
    private DoubleProperty maxMagnification = new SimpleDoubleProperty();
    private DoubleProperty duration = new SimpleDoubleProperty();
    private DoubleProperty frameRate = new SimpleDoubleProperty();
    private DoubleProperty frameWidth = new SimpleDoubleProperty();
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
        initView();
        //initListeners();
    }

    public void initTimeline() {
        initView();
        initListeners();
        initActions();
    }
    private void initListeners() {

        
        timelineScrollPane.hvalueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                double extraDistance = timelineScrollPaneVBox.getPrefWidth() - timelineScrollPane.getPrefWidth();
                double timebarHVal = -1 * t1.doubleValue() * extraDistance;
                timebarTimesliderSuperGroup.setTranslateX(timebarHVal);
                //System.out.println("Margins : " +  getMargin(zoom));
                System.out.println("Positions : " + timebarTimesliderSuperGroup.getTranslateX());
            }
        });

        timebar.valueProperty().addListener(new ChangeListener<Number>() {
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
                double expectedPosition = (timebar.getWidth() - endAdjustment - startAdjustment) * timebar.getValue() / timebar.getMax();
                expectedPosition += startAdjustment;
                isTimesliderSync = timeslider.getLayoutX() == expectedPosition;
                System.out.println("Expected Position : " + expectedPosition + " timebar layout : " + timebar.getLayoutX()+ " timebar trans" + timebar.getTranslateX() + "Anchor pane " + anchor.getLayoutX() + " : " + anchor.getTranslateX());
                if (!isTimesliderSync) {
                    timeslider.setLayoutX(expectedPosition);
                }
                if(expectedPosition==startAdjustment)
                    timeslider.setLayoutX(0);
            }
        });

        enableTimesliderDrag();
        
        
        
        
    }

    class Delta {

        double x, currentTime;
    }

    private void enableTimesliderDrag() {
        final Delta dragDelta = new Delta();

        timeslider.setOnMouseEntered(new EventHandler<MouseEvent>() {
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
                dragDelta.currentTime = timebar.getMax() * newPos / (timebar.getWidth() - endAdjustment - startAdjustment);
                currentTime.set(dragDelta.currentTime);
                System.out.println("Mouse Dragged");
            }
        });
        timeslider.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                timeslider.getScene().setCursor(Cursor.DEFAULT);
            }
        });
    }
    
    public void resetView() {
        magnification.set(timebar.getPrefWidth()/timelineScrollPane.getPrefWidth());
        timelineScrollPaneVBox.setPrefWidth(timelineScrollPaneVBox.getPrefWidth()/magnification.doubleValue());
        timebar.setPrefWidth(timebar.getPrefWidth()/magnification.doubleValue());
        timeslider.setTranslateX(timeslider.getTranslateX()/magnification.doubleValue());
        magnification.set(1);
        duration.setValue(60);
        durationInput.setText(duration.getValue().toString());
        Integer majorTickUnit = new Integer((int) (zoom.getMax()));
                    System.out.println("Majot Tick Unit : " + majorTickUnit);
                timebar.setMajorTickUnit(majorTickUnit);
                timebar.setMinorTickCount(100/ majorTickUnit);
    }
    public final void initView() {
        resetView();
        Rectangle timebarClip = new Rectangle(0,0,440,190);
        //timebarTimeSliderStackPane.getChildren().add(timebarClip);
        timebarTimeSliderStackPane.setClip(timebarClip);
        //timebarTimesliderSuperGroup
        maxMagnification.bindBidirectional(zoom.maxProperty());
        magnification.bindBidirectional(zoom.valueProperty());
        magnification.addListener(new ChangeListener<Number>() {
        //TODO Zoom Issues . see notebook
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number mag) {
                if (mag.doubleValue() > 0) {
                    // change current width
                    double currentWidth = mag.doubleValue() * timelineScrollPane.getWidth();
                    timelineScrollPaneVBox.setPrefWidth(currentWidth);
                    timebar.setPrefWidth(currentWidth);
                    currentTime.setValue(timebar.getValue());
                    System.out.println("Current Width : " + currentWidth);
                    // change ticks
                    Integer majorTickUnit = new Integer((int) (zoom.getMax() + zoom.getMin() - mag.floatValue()));
                    timebar.setMajorTickUnit(majorTickUnit);
                    //double timesliderPos = currentWidth*timebar.getValue()/majorTickUnit;
                    //timeslider.setTranslateX(timesliderPos);
                    
                    int durationNearestSecond = (int) duration.doubleValue() - (((int) duration.doubleValue()) % ((int) zoom.getValue()));
                    timebar.setMinorTickCount(100/ majorTickUnit);
                   // System.out.println("Majot Tick Unit : " + majorTickUnit + " Minor Tick Count "+ timebar.getMinorTickCount() + "Position : " + anchor.getTranslateX());
                }
            }
        });

        
    }

    private void initActions() {
        timebar.snapToTicksProperty().set(false);
        snapToggle.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent t) {
                
                if(!timebar.snapToTicksProperty().getValue())
                {
                    System.out.println("Snap On");
                    timebar.snapToTicksProperty().set(true);
                }
                    else
                {
                    System.out.println("Snap Off");
                    timebar.snapToTicksProperty().set(false);
                }
            }
        });
        
        durationInput.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                try {
                    
                    duration.set(new Double(durationInput.getText()));
                    System.out.println("duration : " + duration.getValue());
                    timebar.setMax(duration.get());
                    
                } catch(Exception ex)
                {
                    System.out.println("invalid duration"  + duration.getValue());
                    durationInput.setText(duration.getValue().toString());
                    //TODO see jme convention
                    ex.printStackTrace();
                }
            }
        });
    }
    /**
     * Creates a layer view in the timeline for the given layer at the given index
     * @param index
     * @param layer 
     */
    public void addLayerView(int index, Layer layer) {
        AnchorPane eventStrip = new AnchorPane();
        eventStrip.setPrefHeight(CinematicEditorUI.ROW_HEIGHT);
        eventStrip.setMinHeight(USE_PREF_SIZE);
        eventStrip.setMaxHeight(USE_PREF_SIZE);
        /*
         * Add code for rendering events
         */
        eventStrip.getChildren().add(new Button("Layer" + index));
        timelineScrollPaneVBox.getChildren().add(index, eventStrip);
    }
    public void removeLayerView(int index) {
        AnchorPane eventStrip = (AnchorPane)timelineScrollPaneVBox.getChildren().remove(index);
        //System.out.println("Removed : " + eventStrip);
    }
    public DoubleProperty getDuration() {
        return duration;
    }

    public DoubleProperty getFrameRate() {
        return frameRate;
    }

    public ScrollPane getTimelineScrollPane() {
        return timelineScrollPane;
    }

    public void setTimelineScrollPane(ScrollPane timelineScrollPane) {
        this.timelineScrollPane = timelineScrollPane;
    }

    public VBox getTimelineScrollPaneVBox() {
        return timelineScrollPaneVBox;
    }

    public void setTimelineScrollPaneVBox(VBox timelineScrollPaneVBox) {
        this.timelineScrollPaneVBox = timelineScrollPaneVBox;
    }
    
    
}
