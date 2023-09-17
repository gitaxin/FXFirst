package i_layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Effect;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.time.LocalDateTime;

/**
 * TextFlex class
 *
 * @author axin
 * @date 2023/9/17
 */
public class TextFlowDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();


        Text text = new Text("hello JavaFX!");
        text.setFont(Font.font("微软雅黑",20));
        Text text1 = new Text("你好JavaFX!\r\n");
        text1.setFont(Font.font("黑体",20));
        Text text2 = new Text(LocalDateTime.now().toString());

        Text text3 = new Text("javafx textflow layout");

        //设置下划线
        text2.setUnderline(true);

        //鼠标样式
        text2.setCursor(Cursor.HAND);
        //字体颜色
        text2.setFill(Paint.valueOf("#FF0000"));
        text2.setFont(Font.font("仿宋", FontWeight.BOLD,20));

        TextFlow textFlow1 = new TextFlow();
        textFlow1.setPadding(new Insets(20));
        //行距
        textFlow1.setLineSpacing(20);
        //对齐方式
        textFlow1.setTextAlignment(TextAlignment.CENTER);

        textFlow1.getChildren().addAll(text,text1,text2);

        TextFlow textFlow2 = new TextFlow();
        textFlow2.setTextAlignment(TextAlignment.CENTER);
        textFlow2.getChildren().addAll(text3);

        //textFlow2.autosize();
        root.getChildren().addAll(textFlow1,textFlow2);










    }
}
