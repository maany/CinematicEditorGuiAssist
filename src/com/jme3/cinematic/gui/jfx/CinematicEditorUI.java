/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jme3.cinematic.gui.jfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author MAYANK
 */
public class CinematicEditorUI extends Application{
    TimelineUI timeline ;

    @Override
    public void start(Stage stage) throws Exception {
        timeline = new TimelineUI();
        Scene scene = new Scene(timeline,440,205);
        stage.setScene(scene);
        stage.show();
        timeline.test();
        timeline.getCurrentTime().setValue(10);
    }
    public static void main(String args[])
    {
        launch(args);
    }
}
