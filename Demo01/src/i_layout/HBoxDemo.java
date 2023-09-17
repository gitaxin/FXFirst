package i_layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * HBoxDemo class
 * 水平布局
 *
 * @author axin
 * @date 2023/9/17
 */
public class HBoxDemo extends Application {


    @Override
    public void start(Stage primaryStage) {


        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: gray");

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn2");
        Button btn3 = new Button("btn3");
        Button btn4 = new Button("btn4");
        Button btn5 = new Button("btn5");
        Button btn6 = new Button("btn6");
        Button btn7 = new Button("btn7");
        Button btn8 = new Button("btn8");
        Button btn9 = new Button("btn9");
        Button btn10 = new Button("btn10");
        Button btn11 = new Button("btn11");

        HBox hBox = new HBox();
        hBox.setPrefWidth(200);
        hBox.setPrefHeight(200);
        //设置容器内边距
        hBox.setPadding(new Insets(10));
        //设置元素的间隔
        hBox.setSpacing(10);
        //设置外边距
        HBox.setMargin(btn1,new Insets(10));
        //设置对齐方式
        hBox.setAlignment(Pos.CENTER);


        hBox.setStyle("-fx-background-color: blue");
        //超出容器宽高后，会一部分容器的宽高
        hBox.getChildren().addAll(btn1,btn2,btn3,btn4,btn5);


        root.getChildren().addAll(hBox);



    }
}
