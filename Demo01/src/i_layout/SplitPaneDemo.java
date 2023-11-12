package i_layout;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * SplitPaneDemo class
 *
 * 分割区域拖动大小受到区域子控件最大最小控制minWidth="60.0"；若同时设置layoutY=“51.0” prefWidth="250.0"该分割区域就不能拖动大小
 * @author axin
 * @date 2023/11/12
 */
public class SplitPaneDemo extends Application {


    @Override
    public void start(Stage primaryStage) {


        SplitPane splitPane = new SplitPane();
        //设置为垂直方向
        //splitPane.setOrientation(Orientation.VERTICAL);

        StackPane s1 = new StackPane(new Label("s1"));
        //s1.setMinWidth(50);
        StackPane s2 = new StackPane(new Label("s2"));
        StackPane s3 = new StackPane(new Label("s3"));
        StackPane s4 = new StackPane(new Label("s4"));

        splitPane.getItems().addAll(s1,s2,s3,s4);

        //不起作用
        splitPane.setDividerPositions(0.2,0.5);

        //设置每个区域大小百分比，dividerPositions="0.25, 0.75"(0号区域0.25；1号区域0.5；剩下区域0.25)，后面百分比在前一个之上累加，直到累加到1

        //不起作用
        //splitPane.setDividerPosition(0,0.10f);
        //splitPane.setDividerPosition(1,0.30f);
        //splitPane.setDividerPosition(2,0.60f);
        //splitPane.setDividerPosition(3,1.0f);





        Scene scene = new Scene(splitPane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }
}
