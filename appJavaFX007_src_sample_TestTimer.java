package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SETICOV on 08.07.2016.
 */
public class TestTimer extends Application {
    Stage windows;
    Timer timer;
    String str;
    Timeline timeline;
    static int i;
    int inter=0;
    List<Double> list= new ArrayList<>();
    LineChart<Double,Double> chartPLC;
    @Override
    public void start(Stage primaryStage) throws Exception {
        windows = primaryStage;
        windows.setTitle("Test");
        Button btn = new Button("Start");
        timeline = new Timeline();


        btn.setOnAction(event -> {
list.add(0.0);list.add(3.0);list.add(5.0);list.add(4.0);
            ObservableList<XYChart.Series<Double, Double>> observableList = FXCollections.observableArrayList();
            LineChart.Series<Double, Double> series1 = new LineChart.Series<>();
            series1.setName("Test");
//
            for (double randomValue : list) {
                inter++;
                series1.getData().add(new XYChart.Data<Double, Double>(Double.valueOf(inter), randomValue));
            }
            //   txtLable.setText(String.valueOf(100));
            observableList.add(series1);
            chartPLC.setData(observableList);
            System.out.println(inter);


        });

        VBox vbox=new VBox();
        vbox.getChildren().addAll(btn,chartPLC);
        Scene scene=new Scene(vbox,700,500);
        windows.setScene(scene);
        windows.show();
    }
}