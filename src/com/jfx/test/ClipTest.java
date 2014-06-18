/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfx.test;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author MAYANK
 */
public class ClipTest extends Application{
    Parent parent;
    @Override
    public void start(Stage stage) throws Exception {
        parent = FXMLLoader.load(getClass().getResource("ClipTest.fxml"));
        Scene scene  = new Scene(parent,200,200);
        stage.setScene(scene);
        stage.show();
        runClipTest();
    }
    public void runClipTest(){
        Rectangle rectangle = new Rectangle(0, 0,200,200);
        ((AnchorPane)parent).setClip(rectangle);
        ObservableList<Node> childrenUnmodifiable = parent.getChildrenUnmodifiable();
    }
    public static void main(String args[]){
        launch(args);
    }
}
