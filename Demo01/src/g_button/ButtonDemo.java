package g_button;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * ButtonDemo class
 *
 * @author axin
 * @date 2023/9/16
 */
public class ButtonDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        Button btn = new Button("btn");
        //btn.setText("btn");
        btn.setLayoutX(100);
        btn.setLayoutY(100);

        btn.setFont(new Font("微软雅黑",50));
        //btn.setFont(Font.font("微软雅黑",20));
        //按钮字体颜色
        btn.setTextFill(Paint.valueOf("#ffffff"));

        //按钮边框
        btn.setBorder(new Border(new BorderStroke(Paint.valueOf("#000000"),BorderStrokeStyle.DASHED,new CornerRadii(20),new BorderWidths(10))));

        //按钮背景色
        Background bg = new Background(
                //颜色
                new BackgroundFill(Paint.valueOf("#AD6C79"),
                 //圆角
                new CornerRadii(20),
                 //背景距离元素的边距，可以理解为外边距
                new Insets(20)));

        btn.setBackground(bg);



        //javafx css 官网
        //https://openjfx.io/javadoc/17/javafx.graphics/javafx/scene/doc-files/cssref.html

        //CSS 设置样式
        Button btn2 = new Button();
        btn2.setId("123");
        btn2.setText("btn2");
        btn2.setLayoutX(300);
        btn2.setLayoutY(100);
        btn2.setPrefWidth(100);
        btn2.setPrefHeight(100);

        btn2.setStyle("""
            
            -fx-background-color:#AD6C79;
            -fx-background-radius:20;
            -fx-text-fill: #ffffff;
            -fx-font-size: 20;
            -fx-border-color: #000000;
            -fx-border-radius: 20;
            -fx-border-style: dashed;
            -fx-border-width: 4;
            -fx-background-insets: 10;
            
            """);

        //监听按钮事件
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("event=" + event.getEventType());
                Object source = event.getSource();
                System.out.println("source=" + source);
                Button btn = (Button)source;
                System.out.println("btn=" + btn.getText());
                String id = btn.getId();
                System.out.println("id=" + id);
            }
        });


        Group group = new Group();
        group.getChildren().addAll(btn,btn2);

        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }
}
