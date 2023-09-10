package d_platform;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * Demo class
 *
 * @author axin
 * @date 2023/9/10
 */
public class PlatformDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //可在其中更新UI线程内的组件
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                System.out.println("runLater ThreadName = " + name);
                System.out.println("abc");

                int i = 1;
                while (i <= 10){
                    System.out.println( "i = " + i);
                    i ++;
                }
            }
        });
        String name = Thread.currentThread().getName();
        System.out.println("start ThreadName = " + name);

        System.out.println("start end");

    }
}
