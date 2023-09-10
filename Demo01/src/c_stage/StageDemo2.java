package c_stage;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Demo class
 *
 * @author axin
 * @date 2023/9/10
 */
public class StageDemo2 extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("进一步了解stage");

        //设置不透明度 0-窗口不可见
        //primaryStage.setOpacity(0.5);

        //设置窗口总是在最上层
        //primaryStage.setAlwaysOnTop(true);


        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        //设置窗口显示坐标位置
        primaryStage.setX(50);
        primaryStage.setY(50);

        primaryStage.xProperty().addListener((observable,oldValue,newValue)->{
            System.out.println("x = " + newValue);
        });
        primaryStage.yProperty().addListener((observable,oldValue,newValue)->{
            System.out.println("y = " + newValue);
        });


        primaryStage.show();
    }
}
