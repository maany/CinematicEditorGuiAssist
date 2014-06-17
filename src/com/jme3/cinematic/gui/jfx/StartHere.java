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
public class StartHere extends Application{
    CinematicEditorUI cinematicEditor; 
    @Override
    public void start(Stage stage) throws Exception {
        cinematicEditor = new CinematicEditorUI();
        Scene scene = new Scene(cinematicEditor,660,440);
        stage.setScene(scene);
        stage.show();
        cinematicEditor.initCinematicEditorUI();
    }
    public static void main(String args[]) {
        launch(args);
    }
}
