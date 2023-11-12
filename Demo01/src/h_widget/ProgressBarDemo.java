package h_widget;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.DecimalFormat;

/**
 * ProgressBarDemo class
 *
 * @author axin
 * @date 2023/11/12
 */
public class ProgressBarDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        //root.setPadding(new Insets(100));

        ProgressIndicator pi = new ProgressIndicator(0.3);
        //pi.setPrefWidth(100);
        //pi.setPrefHeight(100);
        pi.setMinWidth(200);
        pi.setMinHeight(200);
        //pi.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);

        ProgressBar progressBar = new ProgressBar(0.3);
        progressBar.setPrefWidth(300);
        progressBar.setPrefHeight(30);
        //无限进度样式
        //progressBar.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);


        progressBar.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("progress changed: " + newValue);
            }
        });

        //使用多任务更新slider值
        ProgressBarTask myTask = new ProgressBarTask(progressBar);
        myTask.setDelay(Duration.millis(0));
        myTask.setPeriod(Duration.millis(1000));
        myTask.start();

        myTask.valueProperty().addListener(new ChangeListener<Double>() {
            @Override
            public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
                if(newValue != null){
                    System.out.println("value is changed: " + newValue);
                    pi.setProgress(newValue);
                    progressBar.setProgress(newValue);

                }
            }
        });


        root.getChildren().addAll(pi,progressBar);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }


    class ProgressBarTask extends ScheduledService<Double>{

        private DecimalFormat df = new DecimalFormat("0.00");
        private ProgressBar pb;

        public ProgressBarTask(ProgressBar pb) {
            this.pb = pb;
        }

        @Override
        protected Task<Double> createTask() {

            Task task = new Task<Double>(){
                @Override
                protected Double call() throws Exception {
                    double progress = pb.getProgress();
                    progress += 0.1;
                    if(progress > 1){
                        progress = 0;
                    }
                    String format = df.format(progress);
                    return Double.parseDouble(format);

                }
            };

            return task;
        }
    }
}
