/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.gde.cinematic.gui;

import com.jme3.gde.cinematic.core.Layer;
import com.jme3.gde.cinematic.CinematicEditorManager;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author MAYANK
 */
public class GuiManager {
    public static int FRAME_WIDTH = 30;
    public static int LAYER_HEIGTH = 50;
    
    // Z values
    public static final int PARENT_Z_VALUE = 10;
    public static final int CHILD_Z_VALUE = 8;
    public static final int GRAND_CHILD_Z_VALUE = 6;
    public static final int GREAT_GRAND_CHILD_Z_VALUE = 4;
    private static GuiManager instance = null;
    private GuiManager(){}
    public static GuiManager getInstance()
    {
        if(instance == null)
            instance = new GuiManager();
        return instance;
    }
    /**
     * ruturns the JPanel i.e layerSpace to be displayed in the TimelineCanvas 
     * @return 
     */
    public JPanel getLayerSpace(Layer layer)
    {
        JPanel layerSpace = new JPanel();
        // set BoxLayout Horizontal.. or see other layout options
        Dimension size = new Dimension();
        size.setSize(FRAME_WIDTH*CinematicEditorManager.getInstance().getCurrentClip().getDuration(), LAYER_HEIGTH);
        layerSpace.setPreferredSize(size);
        layerSpace.setMaximumSize(size);
        System.out.println("Returning Layer Space : " + layer.getName());
        return layerSpace;
    }
    public List<JPanel> getChildrenLayerSpace(Layer layer)
    {
        List<JPanel> childrenLayerSpace = new ArrayList<>();
        for(Layer child:layer.getChildren())
        {
            System.out.println("Child found : " + child.getName());
            childrenLayerSpace.add(getLayerSpace(child));
        }
        return childrenLayerSpace;
    }
}
