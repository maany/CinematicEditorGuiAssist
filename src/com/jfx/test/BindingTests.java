/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfx.test;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author MAYANK
 */
public class BindingTests extends Application{

    ScrollBar vbar ;
    AnchorPane root;
    Label val;
    ScrollPane layerContainer;
    @Override
    public void start(Stage stage) throws Exception {
        vbar = new ScrollBar();
        vbar.setMax(100);
        vbar.setMin(0);
        vbar.setPrefSize(10,100);
        vbar.setOrientation(Orientation.VERTICAL);
        
        
        root = new AnchorPane();
        Scene scene = new Scene(root,600,600);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("BindingTest");
        
        val = new Label();
        val.setText("HOLA");
        root.getChildren().addAll(val,vbar);
        val.setLayoutX(20);
        
        layerContainer = new ScrollPane();
        layerContainer.setPrefSize(100,200);
        layerContainer.setLayoutX(100);
        layerContainer.setLayoutY(200);
        layerContainer.hbarPolicyProperty().set(ScrollPane.ScrollBarPolicy.ALWAYS);
        root.getChildren().add(layerContainer);
        //doBindingTest();
        doSecondTest();
    }
    public static void main(String args[])
    {
        launch(args);
    }

    private void doBindingTest() {
        DoubleProperty vpos = new SimpleDoubleProperty();
        vpos.setValue(0);
        
        vpos.bind(vbar.valueProperty());
        val.textProperty().bind(vpos.asString());
    }

    private void doSecondTest() {
        DoubleProperty vpos = new SimpleDoubleProperty();
        vpos.setValue(0);
        layerContainer.layoutYProperty().unbind();
        layerContainer.layoutYProperty().bind(vpos);
    }
}
