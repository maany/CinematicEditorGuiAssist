/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.gde.cinematic.gui;

import java.awt.Color;

/**
 *
 * @author MAYANK
 */
public class LayerLAF {
    private Color color;
    private boolean collapsed = true;

    public LayerLAF(Color color,boolean collapsed)
    {
        this.color = color;
        this.collapsed = collapsed;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isCollapsed() {
        return collapsed;
    }

    public void setCollapsed(boolean collapsed) {
        this.collapsed = collapsed;
    }
    
}
