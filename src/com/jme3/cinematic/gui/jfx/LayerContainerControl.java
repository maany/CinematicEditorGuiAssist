/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.cinematic.gui.jfx;

import com.jme3.gde.cinematic.CinematicEditorManager;
import com.jme3.gde.cinematic.core.CinematicClip;
import com.jme3.gde.cinematic.core.Layer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 *
 * @author MAYANK
 */
public class LayerContainerControl extends AnchorPane{
    @FXML
    TableView layerContainer ;
    Layer root;//TODO remove, only testing
    TableColumn<Layer,Boolean> childVisibility,enabled;
    TableColumn<Layer,String> layerName;
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
                if (p.getValue().getLaf().isCollapsed()) {
                    return new SimpleBooleanProperty(false);
                } else {
                    return new SimpleBooleanProperty(true);
                }
            
            }
        
        });
        layerContainer.getColumns().add(enabled);
        
        layerName  = new TableColumn<>();
        layerName.setMinWidth(USE_PREF_SIZE);
        layerName.setPrefWidth(180);
        layerName.setText("Layer Name");
        layerName.setId("layerName");
        layerName.setCellFactory(new Callback<TableColumn<Layer,String>,TableCell<Layer,String>>(){

            @Override
            public TableCell<Layer, String> call(TableColumn<Layer, String> p) {
               return null;
            }
        
        });
        TableColumn column = (TableColumn)layerContainer.getColumns().get(0);
        
        System.out.println(column.getMinWidth());
        column.setGraphic(new ToggleButton());
        column.setCellFactory(new Callback() {

            @Override
            public Object call(Object p) {
                return new ChildVisibilityCell(root.getChildren().get(0));
            }
        });
        initTestRoot();
        seedTable();
    }
    private void initTestRoot() {
        CinematicClip clip = new CinematicClip("MyClip");
        CinematicEditorManager.getInstance().setCurrentClip(clip);
        root = new Layer("MyClip-root",null);
        clip.setRoot(root);
        Layer child = new Layer("Child",root);
        Layer sibling = new Layer("Sibling",root);
        Layer grandChild = new Layer("GrandChild",child);
        Layer grandChildCousin = new Layer("GrandChildCousin",sibling);
        
       // scrollBarH.setVisible(false);

    }

    private void seedTable() {
        ObservableList<Layer> data = FXCollections.observableArrayList(root);
        for(Layer child:root.getChildren())
            data.add(child);
        
        layerContainer.setItems(data);
        for(Layer layer:root.getChildren())
            data.add(layer);
    }
    
    public ScrollBar getVScrollBar(){
        ScrollBar  scrollBarV = (ScrollBar) layerContainer.lookup(".scroll-bar:vertical");
        return scrollBarV;
    }
}
