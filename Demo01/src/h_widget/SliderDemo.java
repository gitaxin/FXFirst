package h_widget;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;

/**
 * SliderDemo class
 * 滑动条
 *
 * @author axin
 * @date 2023/11/12
 */
public class SliderDemo extends Application {


    @Override
    public void start(Stage primaryStage) {


        VBox root = new VBox();
        root.setStyle("""
                    -fx-background-color: #ffffff;
                    """);
        root.setPadding(new Insets(100));

        Slider slider = new Slider(0, 100, 30);
        slider.setPrefWidth(300);

        slider.setShowTickMarks(true);

        slider.setShowTickLabels(true);
        //刻度标记单位
        slider.setMajorTickUnit(5);

        //设置默认值，和构造方法的第3个参数作用相同
        slider.setValue(80);

        //设置为垂直方向
        //slider.setOrientation(Orientation.VERTICAL);

        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                if(object != null){
                    return object + " cm";
                }
                return null;
            }

            @Override
            public Double fromString(String string) {
                return null;
            }
        });

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("newValue:" + newValue);
                //slider.setValueChanging(true);
            }
        });

        slider.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //鼠标按下，开始滑动：true
                //鼠标松开，结束滑动：false
                System.out.println("valueChanging:" + newValue);
            }
        });

        //使用多线程更新slider值
        //new Thread(()->{
        //
        //    for (int i = 0; i < 100; i++) {
        //        double n = i;
        //        try {
        //            Thread.sleep(1000);
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        //        Platform.runLater(()->{
        //            String name = Thread.currentThread().getName();
        //            System.out.println("currentThread:" + name);
        //            slider.setValue(n);
        //        });
        //    }
        //
        //}).start();

        //使用多任务更新slider值
        MyTask myTask = new MyTask(slider);
        myTask.setDelay(Duration.millis(0));
        myTask.setPeriod(Duration.millis(1000));
        myTask.start();

        myTask.valueProperty().addListener(new ChangeListener<Double>() {
            @Override
            public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {

                if(newValue != null){
                    System.out.println("myTask value changed: " + newValue);
                }
            }
        });


        root.getChildren().addAll(slider);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }



    class MyTask extends ScheduledService<Double>{

        private Slider s;

        public MyTask(Slider s) {
            this.s = s;
        }

        @Override
        protected Task<Double> createTask() {
           Task<Double> task = new Task<Double>(){

               @Override
               protected Double call() throws Exception {
                   double value = s.getValue();
                   value ++;
                   if(value > s.getMax()){
                      value = s.getMin();
                   }
                   return value;
               }

               @Override
               protected void updateValue(Double value) {
                   super.updateValue(value);
                   s.setValue(value);
               }
           };

           return task;
        }
    }

}
