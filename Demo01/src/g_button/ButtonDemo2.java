package g_button;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * ButtonDemo2 class
 * 鼠标事件演示
 *
 * @author axin
 * @date 2023/9/16
 */
public class ButtonDemo2 extends Application {


    @Override
    public void start(Stage primaryStage) {

        Button btn = new Button("鼠标事件演示",new ImageView("search.png"));
        btn.setLayoutX(100);
        btn.setLayoutY(100);
        btn.setPrefWidth(200);
        btn.setPrefHeight(100);

        //单击
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("鼠标单击");
            }
        });



        //事件助手，可做多击事件处理，可过滤鼠标左键还是右键
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String name = event.getButton().name();

                if(MouseButton.PRIMARY.name().equals(name)){
                    System.out.println("鼠标左键" + event.getClickCount() + "击");
                }else if(MouseButton.SECONDARY.name().equals(name)){
                    System.out.println("鼠标右键" + event.getClickCount() + "击");
                }

            }
        });

        btn.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("按键按下" + event.getCode().name());
                if(event.getCode().name().equals(KeyCode.A.getName())){
                    System.out.println("按下了A");

                }
            }
        });
        btn.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("按键释放" + event.getCode().name());

            }
        });

        Group group = new Group();
        group.getChildren().addAll(btn);

        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }
}
