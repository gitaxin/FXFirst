package g_button;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.stage.Stage;

import javax.sound.midi.Soundbank;

/**
 * ButtonDemo3 class
 * 快捷键演示
 *
 * @author axin
 * @date 2023/9/16
 */
public class KeyCombinationDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        Button btn = new Button("快捷键演示");
        btn.setId("123");
        btn.setLayoutX(100);
        btn.setLayoutY(100);
        btn.setPrefWidth(100);
        btn.setPrefHeight(100);

        Group root = new Group();
        root.getChildren().addAll(btn);

        Scene scene = new Scene(root);

        //如果要使用第一种、第二种方式注册快捷键，快捷键会触发此事件
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(((Button)event.getSource()).getId());
            }
        });

        //第一种win10中不起作用
        //KeyCombination kc1 = new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN);
        //Mnemonic mnemonic1 = new Mnemonic(btn, kc1);
        //scene.addMnemonic(mnemonic1);
        //
        ////第二种win10中不起作用
        //KeyCombination kc2 = new KeyCharacterCombination("C", KeyCombination.CONTROL_DOWN);
        //Mnemonic mnemonic2 = new Mnemonic(btn, kc2);
        //scene.addMnemonic(mnemonic2);
        //
        ////第三种起作用
        //KeyCombination kc3 = new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN);
        //scene.getAccelerators().put(kc3, new Runnable() {
        //    @Override
        //    public void run() {
        //        System.out.println("action");
        //        //打印线程名称可知，还是UI线程，可直接在此更改UI元素
        //        System.out.println(Thread.currentThread().getName());
        //
        //
        //    }
        //});

        //第四种,有某些键会失效，未深入研究原因，可能是平台原因，可能是快捷键被占用 例如ctrl+shift+p不起作用，可能是ctrl+shift都不起作用
        KeyCombination kc4 = KeyCombination.valueOf("ctrl+alt+p");
        Mnemonic mnemonic4 = new Mnemonic(btn, kc4);
        scene.addMnemonic(mnemonic4);

        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.setTitle("快捷键演示");
        primaryStage.show();

    }
}
