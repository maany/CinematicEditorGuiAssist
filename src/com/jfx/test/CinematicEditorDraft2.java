/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfx.test;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author MAYANK
 */
public class CinematicEditorDraft2 extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("CinematicEditorDraft2.fxml"));
        Scene scene = new Scene(parent,600,600);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("CinematicEditorDraft2");
    }
    public static void main(String args[])
    {
        launch(args);
    }
}
