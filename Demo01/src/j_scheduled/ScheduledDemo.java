package j_scheduled;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * ScheduledDemo class
 * 多任务演示
 *
 * @author axin
 * @date 2023/9/17
 */
public class ScheduledDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

        Button start = new Button("start");
        Button cancel = new Button("cancel");
        Text text = new Text("1");


        root.getChildren().add(start);
        root.getChildren().add(cancel);
        root.getChildren().add(text);

        //创建多任务对象
        MyScheduledService myScheduledService = new MyScheduledService(text);
        //多久后执行，0表示立即执行
        myScheduledService.setDelay(Duration.millis(0));
        //设置执行周期,每一秒执行一次
        myScheduledService.setPeriod(Duration.millis(1000));


        start.setOnAction(event -> {
            myScheduledService.start();
        });
        cancel.setOnAction(event -> {
            myScheduledService.cancel();
            myScheduledService.reset();
        });

    }
}
