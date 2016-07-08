package sample;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.Random;


public class Controller {
 Timer timer;
    Timeline timeline;

    List<RandomValue> list=new ArrayList<>();
    //-------------------------------

    @FXML  Button btnTestStartChart,timerStart,btnStop;
    @FXML  Label txtLable;
    @FXML
    NumberAxis xAxis=new NumberAxis();
    @FXML
   NumberAxis yAxis=new NumberAxis();
   @FXML LineChart<Number,Number> chartPLC=new LineChart<>(xAxis,yAxis);


    //--------------------------------------------


    @FXML
    public void onTestStart(){

        ObservableList<XYChart.Series<Number,Number>> observableList= FXCollections.observableArrayList();
        LineChart.Series<Number,Number> series1=new LineChart.Series<>();
        series1.setName("Test");

        int inter=0;
        for(RandomValue randomValue:list){
inter++;

            series1.getData().add(new XYChart.Data<Number, Number>(inter,randomValue.var2));

        }
        //
      txtLable.setText(String.valueOf(inter));
        //
        observableList.add(series1);
        chartPLC.setData(observableList);
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void startTimer(){
        try {
            timer=new Timer(1000,e -> {
                list.add(new RandomValue( RandomValue.setRandomVAR(),RandomValue.setRandomVAR()));

            });
        }catch (Exception c){}

       timer.start();
    }
    @FXML public void onTimer(){
        startTimer();
startTimer2();

}

    private void startTimer2(){

         timeline=new Timeline(new KeyFrame(Duration.millis(1000),event -> n1000() ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

public void n1000(){
    int inter=0;
    xAxis.setForceZeroInRange(false);

    ObservableList<XYChart.Series<Number,Number>> observableList= FXCollections.observableArrayList();
    LineChart.Series<Number,Number> series1=new LineChart.Series<>();
    series1.setName("Test");
    double var;

    for(RandomValue randomValue:list){
        inter++;
if(inter%5==2)var=-randomValue.var2;
        else var=randomValue.var2;

        series1.getData().add(new XYChart.Data<Number, Number>(inter,var));


    }
    xAxis.setLowerBound(inter-20);
    xAxis.setUpperBound(inter);
    xAxis.setTickUnit(0.5);
    xAxis.setAutoRanging(false);
    chartPLC.setAnimated(false);

    observableList.add(series1);
    chartPLC.setData(observableList);

}
    @FXML
public void stopProgramm(){
        timeline.pause();
//timeline.stop();
    timer.stop();
}

 }

