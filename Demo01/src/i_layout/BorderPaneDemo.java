package i_layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * BorderPane class
 * 方位布局
 *
 * @author axin
 * @date 2023/9/17
 */
public class BorderPaneDemo extends Application {


    @Override
    public void start(Stage primaryStage) {



        AnchorPane top = new AnchorPane();
        top.setStyle("-fx-background-color: #499C54");
        //宽高可能不起作用，因为方位布局有自己的默认布局方式
        top.setPrefWidth(100);
        top.setPrefHeight(100);

        AnchorPane left = new AnchorPane();
        left.setStyle("-fx-background-color: #A87643");
        left.setPrefWidth(100);
        left.setPrefHeight(100);

        AnchorPane right = new AnchorPane();
        right.setStyle("-fx-background-color: #F6F206");
        right.setPrefWidth(100);
        right.setPrefHeight(100);

        AnchorPane bottom = new AnchorPane();
        bottom.setStyle("-fx-background-color: #9DEC1B");
        bottom.setPrefWidth(100);
        bottom.setPrefHeight(100);

        AnchorPane center = new AnchorPane();
        center.setStyle("-fx-background-color: #AD6C79");
        center.setPrefWidth(100);
        center.setPrefHeight(100);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(top);
        borderPane.setLeft(left);
        borderPane.setRight(right);
        borderPane.setBottom(bottom);
        borderPane.setCenter(center);

        //设置内外距
        borderPane.setPadding(new Insets(10));

        //设置某个子元素的外边距
        BorderPane.setMargin(center,new Insets(10));

        //设置某个子元素的对齐方式
        //因为已经占据了所有宽高，可能看不到效果，如果想要看到效果，设置宽度
        BorderPane.setAlignment(top, Pos.CENTER);

        Button btn = new Button("center");
        center.getChildren().add(btn);



        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();




    }
}
