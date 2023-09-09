package b;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *  生命周期演示
 *
 *  日志打印顺序
 *  main() = main
 *  init() = JavaFX-Launcher
 *  start() = JavaFX Application Thread
 *  stop() = JavaFX Application Thread
 *
 *  main  主线程
 *  JavaFX Application Thread 是UI线程
 *
 * @author axin
 * @date 2023/9/9
 */
public class LifeCircle extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start() = " + Thread.currentThread().getName());
        primaryStage.setTitle("生命周期演示");
        primaryStage.show();

    }

    @Override
    public void init() throws Exception {
        System.out.println("init() = " + Thread.currentThread().getName());
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop() = " + Thread.currentThread().getName());
    }
}
