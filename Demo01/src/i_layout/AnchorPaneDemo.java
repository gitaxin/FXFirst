package i_layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * AnchorPane class
 *
 * AnchorPane 布局容器可以设置 子元素边框距离容器的距离
 *
 * @author axin
 * @date 2023/9/17
 */
public class AnchorPaneDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        AnchorPane ap = new AnchorPane();
        ap.setOnMouseClicked(event -> System.out.println(event.getEventType().getName()));
        ap.setStyle("-fx-background-color: #AAE360");



        Button btn1 = new Button("使用AnchorPane设置位置后的按钮");
        Button btn2 = new Button("btn2");

        //设置布局容器内的元素 上边框 或下边框距离容器的距离，类似安卓中的match_parent

        AnchorPane.setTopAnchor(btn1,100.0);
        AnchorPane.setBottomAnchor(btn1,100.0);
        AnchorPane.setLeftAnchor(btn1,100.0);
        AnchorPane.setRightAnchor(btn1,100.0);

        //可以设置容器的内边距
        ap.setPadding(new Insets(10.0));
        AnchorPane.setTopAnchor(btn2,0.0);
        AnchorPane.setLeftAnchor(btn2,0.0);



        //当使用AnchorPane容器设置了位置后，元素设置的X或Y将将不起作用
        //btn1.setLayoutX(100);
        //btn1.setLayoutY(100);

        ap.getChildren().addAll(btn1,btn2);

        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();


    }
}
