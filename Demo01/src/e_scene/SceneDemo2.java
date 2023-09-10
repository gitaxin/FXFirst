package e_scene;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;

/**
 * 布局结构
 * 窗口(stage) - 场景(scene) - 布局（group、layout设置组件位置） - 组件(node)
 *
 * 代码编写步骤可以先编写最小组件最后到场景的顺序编写
 * 组件(node) - 布局（group、layout设置组件位置）- 场景(scene) - 窗口(stage)
 *
 * @author axin
 * @date 2023/9/10
 */
public class SceneDemo2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("javafx");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);


        Button btn = new Button("按钮");
        btn.setPrefWidth(100);
        btn.setPrefHeight(40);
        btn.setCursor(Cursor.CLOSED_HAND);
        btn.setCursor(Cursor.HAND);


        Group root = new Group(btn);
        //root.getChildren().add(btn);

        Scene scene = new Scene(root);
        scene.setCursor(Cursor.MOVE);
        String iconUrl = getClass().getClassLoader().getResource("love.png").toExternalForm();
        scene.setCursor(Cursor.cursor(iconUrl));


        //使用默认浏览器打开一个网页
        HostServices hostServices = getHostServices();
        hostServices.showDocument("https://www.baidu.com");


        primaryStage.setScene(scene);

        primaryStage.show();


    }
}
