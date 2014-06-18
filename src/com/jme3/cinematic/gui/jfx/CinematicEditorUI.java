/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.cinematic.gui.jfx;




import com.jme3.gde.cinematic.CinematicEditorManager;
import com.jme3.gde.cinematic.core.CinematicClip;
import com.jme3.gde.cinematic.core.Layer;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author MAYANK
 */
public class CinematicEditorUI extends AnchorPane{
    @FXML
    private TimelineControl timeline ;
    @FXML
    private LayerContainerControl layerContainer ;
    private ScrollBar vbar;
    private ScrollPane timelineScrollPane;
    private VBox timelineScrollPaneVBox;
    private TableView layerContainerTableView;
    private Layer root;
    public static final double ROW_HEIGHT = 30.0; // if changed here, change it in layer_container.css as well
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
    public void initTestRoot() {
        CinematicClip clip = new CinematicClip("MyClip");
        CinematicEditorManager.getInstance().setCurrentClip(clip);
        root = new Layer("MyClip-root",null);
        clip.setRoot(root);
        Layer child = new Layer("Child",root);
        for(int i=1;i<=10;i++){
            child = new Layer("Child" + i,root);
         }
        Layer sibling = new Layer("Sibling",root);
        Layer grandChild = new Layer("GrandChild",child);
        Layer grandChildCousin = new Layer("GrandChildCousin",sibling);
    }
    
    public void initCinematicEditorUI() {
        timeline.initTimeline();
        layerContainer.initLayerContainer();
        initControls();
        syncHeight();
        syncVerticalScrolling();
        //syncContent();
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
    
    private void initControls() {
        vbar = layerContainer.getVScrollBar();
        timelineScrollPane = timeline.getTimelineScrollPane();
        timelineScrollPaneVBox = timeline.getTimelineScrollPaneVBox();
    }
/**
 * Links the heights of the timeline and layerContainer and keeps them in sync when layers are added or removed. 
 * This is required for synchronized vertical scrolling
 */
    private void syncHeight() {
        layerContainerTableView = layerContainer.getLayerContainer();
        double size = layerContainerTableView.getItems().size()*CinematicEditorUI.ROW_HEIGHT;
        timelineScrollPaneVBox.setPrefHeight(size);
    }
    /**
     * Links the vertical scrollbars of the layerContainer with the vertical scrollbar of the timeline
     * as we need only 1 scrollbar for vertical scrolling of both components. If the heights are same for 
     * layerContainer and timeline, then scrolling will be synchronized.
     */
    private void syncVerticalScrolling() {
        timelineScrollPane.vmaxProperty().bindBidirectional(vbar.maxProperty());
        timelineScrollPane.vminProperty().bindBidirectional(vbar.minProperty());
        timelineScrollPane.vvalueProperty().bindBidirectional(vbar.valueProperty());
        
    }

    private void addNewLayer(Layer layer){
    
    }
    /**
     * creates the layer view of an existing layer. The layer view consists of a layerContainer part and a timeline part.
     * @param layer the layer for which the layer view is to be created
     */
    private void addLayerView(int index,Layer layer) {
         layerContainer.addLayerView(index,layer);
         timeline.addLayerView(index,layer);
    }
    
    public void removeLayerView(Layer layer) {
        
    }
    public void showChildren(Layer parent) {
        
    }
    public void hideChildren(Layer parent){
        
    }
    /**
     * Based on the root it creates layers in the editor
     * @param root 
     */
    public void initView(Layer root) {
        int index = 0;
        this.root = root;
        this.addLayerView(index,root);
        if (!root.getLaf().isCollapsed()) {
            for (Layer child : root.getChildren()) {
                index++;
                addLayerView(index,child);
            }
        }
    }
    /**
     * Finds all visibile layers and shows them in the editor in proper heirarchy
     */
    public void syncView() {
        int index=0;
        for(Layer layer:(List<Layer>)layerContainerTableView.getItems())
        {
            removeLayerView(layer);
        }
        for(Layer layer:root.findAllVisibleDescendants()){
            addLayerView(index,layer);
            index++;
        }
            
    }
    public Layer getRoot() {
        return root;
    }

    public void setRoot(Layer root) {
        this.root = root;
    }

    
    
}
