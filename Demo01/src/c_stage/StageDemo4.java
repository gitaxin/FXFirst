package c_stage;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Demo class
 *
 * @author axin
 * @date 2023/9/10
 */
public class StageDemo4 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("模态化窗口展示");
        //primaryStage.show();

        Stage s1 = new Stage();
        s1.setTitle("s1");

        s1.show();

        //透明窗口，鼠标不可穿透
        Stage s2 = new Stage();
        s2.setTitle("s2");

        s2.initOwner(s1);//当关闭s1窗口时，s2也会自动关闭
        s2.show();


        Stage s3 = new Stage();
        s3.setTitle("s3");
        //模态窗口，当前窗口关闭后才可以激活其他窗口
        s3.initModality(Modality.APPLICATION_MODAL);
        s3.show();


    }
}
