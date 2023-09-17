package i_layout;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



/**
 * AnchorPaneDemo3 class
 *
 * @author axin
 * @date 2023/9/17
 */
public class AnchorPaneDemo3 extends Application {


    @Override
    public void start(Stage primaryStage) {

        AnchorPane p1 = new AnchorPane();
        p1.setStyle("-fx-background-color: gray");

        Scene scene = new Scene(p1);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();


        AnchorPane p2 = new AnchorPane();
        p2.setStyle("-fx-background-color: #AAE360");
        p1.getChildren().addAll(p2);

        Button btn = new Button("btn");
        p2.getChildren().add(btn);

        AnchorPane.setLeftAnchor(p2,0.0);
        AnchorPane.setTopAnchor(p2,0.0);
        AnchorPane.setRightAnchor(p2,p1.getWidth() / 2);
        AnchorPane.setBottomAnchor(p2,p1.getHeight() / 2);

        //可设置容器的宽高
        //p2.setPrefWidth(100);
        //p2.setPrefHeight(100);


        AnchorPane.setRightAnchor(btn,0.0);
        AnchorPane.setBottomAnchor(btn,0.0);

        //失去父容器的管理，页面中将看不见,虽然不受管理，但是元素数量并没有减少，其他元素会挤占，相当于CSS中display:none
        //btn.setManaged(false);
        //btn还存在父容器中，只是不可见,页面中元素位置还是存在,相当于 CSS 中visibility: hidden;
        btn.setVisible(true);
        //btn的透明度
        btn.setOpacity(1);


        //窗体改变时，变更p2的边距
        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                AnchorPane.setRightAnchor(p2,p1.getWidth() / 2);
            }
        });

        primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                //不使用newValue是因为此值含窗体的标题栏的高度
                AnchorPane.setBottomAnchor(p2,p1.getHeight() / 2);
            }
        });





    }
}
