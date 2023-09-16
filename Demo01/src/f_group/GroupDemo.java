package f_group;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Demo class
 *
 * @author axin
 * @date 2023/9/16
 */
public class GroupDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        Button add = new Button("add");


        Button btn1 = new Button("b1");
        Button btn2 = new Button("b2");
        Button btn3 = new Button("b3");

        btn1.setPrefWidth(50);
        btn1.setPrefHeight(50);

        btn2.setPrefWidth(50);
        btn2.setPrefHeight(50);

        btn3.setPrefWidth(50);
        btn3.setPrefHeight(50);

        //绝对定位
        btn1.setLayoutX(100);
        btn1.setLayoutY(100);

        btn2.setLayoutX(200);
        btn2.setLayoutY(100);

        btn3.setLayoutX(300);
        btn3.setLayoutY(100);

        add.setLayoutX(200);
        add.setLayoutY(200);

        //将指定组件设置为一个组，便于管理
        Group group = new Group();
        group.getChildren().addAll(btn1,btn2,btn3,add);

        //移除第1个元素
        //group.getChildren().remove(0);
        //清除所有元素
        //group.getChildren().clear();


        //默认是true，如果设置为false，会隐藏
        //group.setAutoSizeChildren(false);

        //设置透明，会影响所有子元素
        //group.setOpacity(0.5);

        //指定位置是否有组件，只会检测组件左上角的点
        boolean contains = group.contains(100, 100);
        System.out.println("指定位置是否有组件：" + contains);

        //获取所有子组件
        Object[] objects = group.getChildren().toArray();
        System.out.println("group中共有多少组件:" + objects.length);
        //统一设置所有子组件
        for (Object object : objects) {
            Button btn = (Button)object;
            btn.setPrefWidth(100);
        }

        //监听元素增加或减少
        group.getChildren().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> c) {
                System.out.println("当前子组件 size=" + c.getList().size());
            }
        });

        Scene scene = new Scene(group);

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button btn = new Button("我是新的按钮");
                double width = scene.getWidth();
                double height = scene.getHeight();
                Random random = new Random();
                double xr = random.nextDouble();
                double yr = random.nextDouble();

                btn.setLayoutX(xr * width);
                btn.setLayoutY(yr * height);
                group.getChildren().add(btn);

            }
        });



        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();
    }
}
