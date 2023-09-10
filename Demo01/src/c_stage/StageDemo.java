package c_stage;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Demo class
 *
 * @author axin
 * @date 2023/9/10
 */
public class StageDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

     /*   Stage stage = new Stage();
        stage.show();*/

        primaryStage.setTitle("Hello JavaFX");

        //在IDEA 中，要新建resources文件夹，并在模块设置中将该文件夹设置为Resources
        primaryStage.getIcons().add(new Image("love.png"));
        //将窗品设置最小化
        //primaryStage.setIconified(true);
        //设置最大化
        //primaryStage.setMaximized(true);

        //设置全屏,全屏与最大化不同，全屏是将窗口标题栏与系统任务栏隐藏掉
        //设置全屏必须设置scene
        //primaryStage.setFullScreen(true);
        //primaryStage.setScene(new Scene(new Group()));

        primaryStage.setWidth(500);
        primaryStage.setHeight(500);

        //禁止鼠标窗口拖动拉伸
        //primaryStage.setResizable(false);

        //设置窗口最大宽高，当拉伸窗口时只允许在此范围内
        //primaryStage.setMaxHeight(800);
        //primaryStage.setMaxWidth(800);

        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(300);

        System.out.println("宽 = " + primaryStage.getWidth());
        System.out.println("高 = " + primaryStage.getHeight());


        //监听宽高变化
        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("width = " + newValue);
            }
        });
        primaryStage.heightProperty().addListener((observable,oldValue,newValue)->{
            System.out.println("height = " + newValue);
        });



        primaryStage.show();

        //关闭窗口
        //primaryStage.close();


    }
}
