/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.gde.cinematic.core;

import com.jme3.gde.cinematic.gui.GuiManager;
import com.jme3.gde.cinematic.gui.LayerLAF;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author MAYANK
 */
public class Layer {
    private int depth=0;
    private String name;
    private List<Layer> children;
    private Layer parent; // for child to parent link
    private List<Layer> descendants;
    private LayerLAF laf; // look and feel
    private List<Integer> index;
    private boolean showChildren = false;
  
    /**
     * Use for creating a Child
     * @param name
     * @param parent 
     */
   
    
    public Layer(String name,Layer parent) {
        this.name = name;
        this.parent = parent;
        children = new ArrayList<>();
        descendants = new ArrayList<>();
        laf = GuiManager.DEFAULT_LAYER_LAF;
        
        if(parent!=null)
        {
            depth = parent.getDepth()+1;
            parent.addChild(this);
        }
        else
        {
            depth=0;
            
        }
    }

    public Layer(String name,Layer parent,Color color,boolean collapsed) {
        this(name,parent);
        laf = new LayerLAF(color,collapsed);
    }
    /**
     * Avoid direct usage. Used by constructor to establish parent to child link.
     * @param child 
     */
    public void addChild(Layer child)
    {
        children.add(child);
    }
    
    public boolean hasChildren()
    {
        if(children.size()>0)
            return true;
        else
            return false;
    }
    /**
     * layer.findAllDescendents(Layer) seems not right, but it is needed as this is recursive function.
     * @param layer
     * @return 
     */
    public List<Layer> findAllDescendants () {
        if(this.hasChildren())
            for(Layer child:this.getChildren())
            {
                if(!descendants.contains(this))
                    descendants.add(this);
                child.findAllDescendants();
            }
        else
            descendants.add(this);
        return getDescendants();
    }
      
    public List<Layer> findAllVisibleDescendants () {
        if(this.hasChildren())
            for(Layer child:this.getChildren())
            {
                if(this.getLaf().isCollapsed()) {
                    if(!descendants.contains(this) )
                    descendants.add(this);
                    
                }
                else {
                    if(!descendants.contains(this) )
                    descendants.add(this);
                    child.findAllDescendants();
                }
            }
        else
            descendants.add(this);
        return getDescendants();
    }
    /*
     * Getters and Setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Layer> getChildren() {
        return children;
    }

    public void setChildren(List<Layer> children) {
        this.children = children;
    }
    public Layer getParent() {
        return parent;
    }

    public void setParent(Layer parent) {
        this.parent = parent;
    }
    
    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public List<Layer> getDescendants() {
        return descendants;
    }

    public void setDescendants(List<Layer> descendants) {
        this.descendants = descendants;
    }

    public LayerLAF getLaf() {
        return laf;
    }

    public void setLaf(LayerLAF laf) {
        this.laf = laf;
    }

   
}
