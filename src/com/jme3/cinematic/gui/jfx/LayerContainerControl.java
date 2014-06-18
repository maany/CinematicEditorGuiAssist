/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.cinematic.gui.jfx;

import com.jme3.gde.cinematic.CinematicEditorManager;
import com.jme3.gde.cinematic.core.CinematicClip;
import com.jme3.gde.cinematic.core.Layer;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.util.Callback;

/**
 *
 * @author MAYANK
 */
public class LayerContainerControl extends AnchorPane{
    @FXML
    private TableView layerContainer ;
    private Layer root;//TODO remove, only testing
    private TableColumn<Layer,Boolean> childVisibility,enabled;
    private TableColumn<Layer,String> layerName;
    private CinematicEditorUI cinematicEditor;
    public LayerContainerControl(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("layer_container.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        
        try {
            loader.load();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        
    }

    public void initLayerContainer(){
        /* Enabled checkbox Column */
        enabled = new TableColumn<>();
        enabled.setMinWidth(USE_PREF_SIZE);
        enabled.setPrefWidth(20);
        enabled.setGraphic(null); //TODO add a .ico file representing enabled
        enabled.setId("enabled");
        enabled.setCellFactory(new Callback<TableColumn<Layer,Boolean>,TableCell<Layer,Boolean>>(){

            @Override
            public TableCell<Layer, Boolean> call(TableColumn<Layer, Boolean> p) {
                return new EnabledCell();
            }
        
        });
        enabled.setCellValueFactory(new Callback<CellDataFeatures<Layer,Boolean>,ObservableValue<Boolean>>(){

            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<Layer, Boolean> p) {
                if (p.getValue().getLaf().isEnabled()) {
                    return new SimpleBooleanProperty(true);
                } else {
                    return new SimpleBooleanProperty(false);
                }
            
            }
        
        });
        layerContainer.getColumns().add(enabled);
        
        
        /* layerName Column*/
        layerName  = new TableColumn<>();
        layerName.setMinWidth(USE_PREF_SIZE);
        layerName.setPrefWidth(180);
        layerName.setText("Layer Name");
        layerName.setId("layerName");
        layerName.setCellFactory(new Callback<TableColumn<Layer,String>,TableCell<Layer,String>>(){

            @Override
            public TableCell<Layer, String> call(TableColumn<Layer, String> p) {
                 return new LayerNameCell();
            }

            
        
        });
        layerName.setCellValueFactory(new Callback<CellDataFeatures<Layer,String>,ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(final CellDataFeatures<Layer, String> p) {
                String val = p.getValue().getName();
                StringProperty displayName = new SimpleStringProperty(val);
                displayName.addListener(new ChangeListener<String>(){

                    @Override
                    public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                        if(!t1.equals(p.getValue().getName()))
                           p.getValue().setName(t1);
                    }
                
                });
                return displayName;
            }

            
        });
        layerContainer.getColumns().add(layerName);
        
        /*** show children/ childVisibility column ***/
        childVisibility = new TableColumn<>();
        childVisibility.setMinWidth(USE_PREF_SIZE);
        childVisibility.setPrefWidth(20);
        childVisibility.setGraphic(null);// TODO replace with a .ico file
        childVisibility.setCellFactory(new Callback<TableColumn<Layer,Boolean>,TableCell<Layer,Boolean>>(){

            @Override
            public TableCell<Layer, Boolean> call(TableColumn<Layer, Boolean> p) {
                return new ChildVisibilityCell(cinematicEditor);
            }
        
        });
        childVisibility.setCellValueFactory(new Callback<CellDataFeatures<Layer, Boolean>, ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(CellDataFeatures<Layer, Boolean> p) {
                if(p.getValue().getLaf().isCollapsed())
                    return new SimpleBooleanProperty(true);
                else
                    return new SimpleBooleanProperty(false);
            }
        });
        layerContainer.getColumns().add(1,childVisibility);
        //initTestRoot();
       // seedTable();
    }
    private void initTestRoot() {
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
      //  System.out.println("sibling : " + sibling.getLaf().isCollapsed());
        
       // scrollBarH.setVisible(false);

    }

    private void seedTable() {
        ObservableList<Layer> data = FXCollections.observableArrayList(root);
        for(Layer child:root.getChildren())
         ; //  data.add(child);
        
        layerContainer.setItems(data);
        //data.add(root.getChildren().get(0).getChildren().get(0));
        //data.add(root.getChildren().get(1).getChildren().get(0));
            
    }
    /**
     * Adds a layer view in the layerContainer at given index. 
     * @param index
     * @param layer 
     */
    public void addLayerView(int index,Layer layer){
        layerContainer.getItems().add(index, layer);
    }
    /**
     * hides the layer view in the layerContainer
     * @param index 
     */
    public void removeLayerView(int index)
    {
        layerContainer.getItems().remove(index);
    }
   
    public ScrollBar getVScrollBar(){
        ScrollBar  scrollBarV = (ScrollBar) layerContainer.lookup(".scroll-bar:vertical");
        return scrollBarV;
    }

    public TableView getLayerContainer() {
        return layerContainer;
    }

    public void setLayerContainer(TableView layerContainer) {
        this.layerContainer = layerContainer;
    }

    public CinematicEditorUI getCinematicEditor() {
        return cinematicEditor;
    }

    public void setCinematicEditor(CinematicEditorUI cinematicEditor) {
        this.cinematicEditor = cinematicEditor;
    }
    
}
