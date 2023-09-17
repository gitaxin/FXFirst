package h_widget;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * WidgetDemo class
 *
 * @author axin
 * @date 2023/9/16
 */
public class WidgetDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

        Label label = new Label();
        label.setText("账号：");
        label.setFont(Font.font(20));
        label.setLayoutX(20);
        label.setLayoutY(100);

        Label label2 = new Label();
        label2.setText("密码：");
        label2.setFont(Font.font(20));
        label2.setLayoutX(20);
        label2.setLayoutY(140);

        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String name = event.getButton().name();
                System.out.println(event.getEventType().getName() + ":" + name);


            }
        });


        //文本框
        TextField text = new TextField();
        //text.setText("默认值");

        text.setLayoutX(100);
        text.setLayoutY(100);

        text.setPrefWidth(500);
        text.setFont(Font.font(18));

        //鼠标悬浮到输入框上提示
        Tooltip tip = new Tooltip("请输入账号");
        tip.setFont(Font.font(20));
        text.setTooltip(tip);

        text.setPromptText("最多10个字");
        //失去焦点
        text.setFocusTraversable(false);


        //监听内容变化，控制最多输入10个字
        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
                if(newValue.length() > 10){
                    text.setText(oldValue);
                }
            }
        });

        text.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("选择的文本：" + newValue);
            }
        });

        //文本输入框按Enter时执行
        text.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(event.getEventType().getName() + "Enter");
            }
        });

        //密码框
        PasswordField ptext = new PasswordField();
        ptext.setLayoutX(100);
        ptext.setLayoutY(140);
        ptext.setPrefWidth(500);
        ptext.setFont(Font.font(20));
        ptext.setPromptText("请输入密码");





        root.getChildren().addAll(label,label2,text,ptext);


    }
}
