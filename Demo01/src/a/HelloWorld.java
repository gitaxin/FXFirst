package a;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * 程序入口：第一种方式
 *
 * Idea中运行：
 * 如果未添加module-info.java 文件，需要在Run-Configurations中添加VM Options
 *
 *  --module-path E:\MyRepository\JavaFX\javafx-sdk-17.0.8\lib
 *  --add-modules javafx.controls,javafx.fxml
 *
 * @author axin
 * @date 2023/9/9
 */
public class HelloWorld extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello world!");
        primaryStage.show();

    }
}
