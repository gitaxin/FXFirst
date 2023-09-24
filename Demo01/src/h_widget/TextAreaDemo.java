package h_widget;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.border.Border;

/**
 * TextAreaDemo class
 *
 * @author axin
 * @date 2023/9/24
 */
public class TextAreaDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        AnchorPane root = new AnchorPane();

        TextArea textArea = new TextArea();
        textArea.setText("Hello TextArea!");
        textArea.setFont(Font.font(18));

        //设置默认展示行数
        textArea.setPrefRowCount(3);
        textArea.setPrefColumnCount(10);
        //超出宽度后换行
        //textArea.setWrapText(true);

        textArea.setPrefWidth(300);
        textArea.setPrefHeight(300);

        //textArea.appendText("end");

        //textArea.deleteText(0,4);
        //textArea.insertText(5,"---------------");

        //textArea.replaceText(0,1,"ab");

        //textArea.selectAll();
        //从光标往后选择1个字符
        //textArea.selectForward();

        //从光标往后选择指定个字符
        //textArea.selectPositionCaret(4);


        //从光标位置，选择到指定光标位置
        //textArea.selectRange(2,1);

        //移动光标到指定位置
        //textArea.positionCaret(5);

        //将光标移到开头
        //textArea.home();

        //从光标位置选择到最后
        //textArea.selectEnd();

        // 从光标位置选择到开头
        // textArea.selectHome();

        //设置不可编辑
        //textArea.setEditable(false);

        //清除
        //textArea.clear();

        //COPY内容,先选择再COPY内容
        //textArea.selectEnd();
        //textArea.copy();

        //演示单击容器 设置光标位置
        root.setOnMouseClicked(event -> {
            textArea.setScrollLeft(20);
        });

        //文本变化监听
        textArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
                if(newValue.trim().length() > 20){
                    textArea.setText(oldValue);
                }
            }
        });

        //选择监听
        textArea.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });

        textArea.scrollLeftProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("scrollLeft = " + newValue);
            }
        });




        int length = textArea.getLength();
        System.out.println(length);

        root.getChildren().add(textArea);

        AnchorPane.setTopAnchor(textArea,0.0);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.setTitle("TextArea演示");
        primaryStage.show();

    }
}
