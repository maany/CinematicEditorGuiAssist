/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.cinematic.gui.jfx;

import com.jme3.gde.cinematic.core.Layer;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author MAYANK
 */
public class ChildVisibilityCell extends TableCell<Layer,Boolean>{
    private Button button;
    

    ChildVisibilityCell() {
        button = new Button();
        this.setAlignment(Pos.CENTER);
        button.setAlignment(Pos.CENTER);
        
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                int index = getTableRow().getIndex();
                Layer layer = getTableView().getItems().get(index);
                if (layer.getLaf().isCollapsed() == true) {
                    layer.getLaf().setCollapsed(false);
                    System.out.println("current layer : " + layer.getName() + " was collapsed. Showing its children"  );
                    getTableView().getItems().addAll(index+1,layer.getChildren());
                } else {
                    layer.getLaf().setCollapsed(true);
                    System.out.println("Curent layer : " + layer.getName() + " was not collapsed. Hiding its children");
                    System.out.println("Removing from " + (index+1) + " to " + (layer.getChildren().size()+index));
                    //for(int i=index+1;i<index+1+layer.getChildren())
                    getTableView().getItems().remove(index+1,index + layer.getChildren().size()+1);
                }

            }
             });
             
    }
    
    
/**
 * item gives value of isCollapsed property of LayerLAF for current layer
 * @param item
 * @param empty 
 */
    @Override
    public void updateItem(Boolean item, boolean empty) {
        if (empty) {
            setGraphic(null);
        }
        if (!empty) {
            setGraphic(button);
            // initialize
            if (!item.booleanValue() == true) {
                //  getTableView().getItems().addAll(getTableRow().getIndex() + 1, getTableView().getItems().get(getTableRow().getIndex()).getChildren());
            }
            System.out.println("Rendering");
            // event handler



        }
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
   
    
}
