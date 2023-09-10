package c_stage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Demo class
 *
 * @author axin
 * @date 2023/9/10
 */
public class StageDemo3 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //primaryStage.setTitle("窗口类型");
        //
        //primaryStage.show();

        //s1 和 s5  常用
        //默认样式
        Stage s1 = new Stage();
        s1.setTitle("s1");
        s1.initStyle(StageStyle.DECORATED);
        s1.show();

        //透明窗口，鼠标不可穿透
        //Stage s2 = new Stage();
        //s2.setTitle("s2");
        //s2.initStyle(StageStyle.TRANSPARENT);
        //s2.show();

        //好像也是不透明的，和s2类似，目前发现唯一区别好像是在鼠标悬浮在任务中时展示的预览不同
        //Stage s3 = new Stage();
        //s3.setTitle("s3");
        //s3.initStyle(StageStyle.UNDECORATED);
        //s3.show();

        //无标题栏样式，但测试没有变化，不知是哪里设置的问题，和s1没有啥区别
        Stage s4 = new Stage();
        s4.setTitle("s4");
        s4.initStyle(StageStyle.UNIFIED);
        s4.show();

        //右上角只有关闭按钮
        Stage s5 = new Stage();
        s5.setTitle("s5");
        s5.initStyle(StageStyle.UTILITY);
        s5.show();


        //退出
        Platform.exit();

    }
}
