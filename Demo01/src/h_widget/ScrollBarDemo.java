package h_widget;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * ScrollBarDemo class
 *
 * @author axin
 * @date 2023/11/13
 */
public class ScrollBarDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        AnchorPane root = new AnchorPane();
        ScrollBar hbar = new ScrollBar();
        ScrollBar vbar = new ScrollBar();
        vbar.setOrientation(Orientation.VERTICAL);


        AnchorPane.setRightAnchor(vbar,0.0);
        AnchorPane.setBottomAnchor(hbar,0.0);

        Button button = new Button("拖动滚动条观察我");
        //设置滚动条的默认位置
        //hbar.setValue(50);
        //vbar.setValue(50);

        //设置每次鼠标单击滚动条箭头时移动的像素值
        hbar.setUnitIncrement(50);
        vbar.setUnitIncrement(50);

        //设置每次鼠标单击滚动条空白位置时移动的像素值
        hbar.setBlockIncrement(50);
        vbar.setBlockIncrement(50);

        //设置滚动条块的长度
        hbar.setVisibleAmount(50);

        hbar.valueProperty().addListener((observable, oldValue, newValue) -> {

            double boxWidth = root.getWidth() - button.getWidth() - vbar.getWidth();
            double ratio = boxWidth / 100;
            button.setTranslateX(ratio * newValue.doubleValue());

            /**
             * 默认hbar 的最大为100
             * 可以设置滚动条的最大宽高为控制盒子的宽度，这样就不用百分比计算了
             *
             * hbar.setMax(root.getWidth() - vbar.getWidth());
             */
            //button.setTranslateX(newValue.doubleValue());
        });

        vbar.valueProperty().addListener((observable, oldValue, newValue) -> {
            double boxHeight = root.getHeight() - button.getHeight() - hbar.getHeight();
            double ratio = boxHeight / 100;
            button.setTranslateY(ratio * newValue.doubleValue());
        });




        //单击按钮动态更新滚动条
        button.setOnAction(event -> {
            vbar.increment();
            hbar.increment();

            //vbar.decrement();
            //hbar.decrement();
        });



        root.getChildren().addAll(hbar,vbar,button);

        //当窗口改变大小时。动态控制滚动条的宽高
        root.widthProperty().addListener((observable, oldValue, newValue) -> {
            hbar.setPrefWidth(root.getWidth() - vbar.getWidth());
        });
        root.heightProperty().addListener((observable, oldValue, newValue) -> {
            vbar.setPrefHeight(root.getHeight() - hbar.getHeight());
        });

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();
        //hbar.setTranslateY(root.getHeight() - hbar.getHeight());
        //vbar.setTranslateX(root.getWidth() - vbar.getWidth());
        //vbar.setTranslateY(-hbar.getHeight());
        hbar.setPrefWidth(root.getWidth() - vbar.getWidth());
        vbar.setPrefHeight(root.getHeight() - hbar.getHeight());

        /**
         * 默认hbar 的最大为100
         * 可以设置滚动条的最大宽高为控制盒子的宽度，这样就不用百分比计算了
         */
        //hbar.setMax(root.getWidth() - vbar.getWidth());





    }
}
