/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.cinematic.gui.jfx;

import com.jme3.gde.cinematic.core.Layer;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.ToggleButton;

/**
 *
 * @author MAYANK
 */
public class ChildVisibilityCell extends TableCell{
    private ToggleButton button;
    private Layer owner;
    public ChildVisibilityCell(Layer owner){
        this.owner = owner;
        button = new ToggleButton();
        this.setAlignment(Pos.CENTER);
        button.setAlignment(Pos.CENTER);
        setGraphic(button);
    }

    public ToggleButton getButton() {
        return button;
    }

    public void setButton(ToggleButton button) {
        this.button = button;
    }
    
}
