/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.gde.cinematic.core;

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
        if(parent!=null)
        {
            depth = parent.getDepth()+1;
            parent.addChild(this);
        }
        else
            depth=0;
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
    public List<Layer> findAllDescendants (Layer layer) {
        if(layer.hasChildren())
            for(Layer child:layer.getChildren())
            {
                if(!descendants.contains(layer))
                    descendants.add(layer);
                findAllDescendants(child);
            }
        else
            descendants.add(layer);
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
    
}
