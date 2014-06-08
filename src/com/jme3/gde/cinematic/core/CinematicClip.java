/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.gde.cinematic.core;

/**
 *
 * @author MAYANK
 */
public class CinematicClip{
    
    private int duration=30;
    private String name;
    private Layer root;
    
    public CinematicClip(String name)
    {
        this.name = name;
    }
    public CinematicClip(String name,Layer root)
    {
        this.name = name;
        this.root = root;
    }
    public CinematicClip(String name,Layer root,int duration)
    {
        this.name = name;
        this.root = root;
        this.duration = duration;
    }
    public Layer getRoot() {
        return root;
    }

    public void setRoot(Layer root) {
        this.root = root;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
}
