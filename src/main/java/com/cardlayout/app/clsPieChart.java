/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cardlayout.app;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author narayan.punekar@yahoo.com
 */
public class clsPieChart extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("Product Backlog");
        stage.setWidth(500);
        stage.setHeight(500);

        int iSolvedCnt = 9;
        int iSolvedNum  = 6;
        double dSolvedCnt = (100*iSolvedCnt)/(iSolvedCnt+iSolvedNum);
        double dSolvedNum = (100*iSolvedNum)/(iSolvedCnt+iSolvedNum);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("SolvedCnt", dSolvedCnt),
                new PieChart.Data("SolvedNum", dSolvedNum));

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Product Backlog");
        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");

        for (final PieChart.Data data : chart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                        @Override public void handle(MouseEvent e) {
                            caption.setTranslateX(e.getSceneX());
                            caption.setTranslateY(e.getSceneY());
                            caption.setText(String.valueOf(data.getPieValue()) 
                                + "%");
                        }
                    });
        }
                
        ((Group) scene.getRoot()).getChildren().addAll(chart, caption);
        stage.setScene(scene);
        //scene.getStylesheets().add("piechartsample/Chart.css");
        stage.show();
    }

    public void start() throws Exception {
        launch();
    }

}
