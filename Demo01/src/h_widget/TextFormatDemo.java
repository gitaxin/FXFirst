package h_widget;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.function.UnaryOperator;

/**
 * TextFormatDemo class
 *
 * @author axin
 * @date 2023/9/24
 */
public class TextFormatDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        TextField textField = new TextField();
        TextArea textArea = new TextArea();
        Button btnWrite = new Button("写入");
        Button btnCommit = new Button("提交");






        //第一种方法：限制数据输入的有效性
        textField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                String text = change.getText();

                System.out.println(text);
                //限制只允许输入数字
                if(text.matches("\\d")){
                    return change;
                }
                return null;
            }
        }));


        //当调用commitValue时，才会执行此Format
        //API已有很多预置的Converter，可查看API文档或源码
        textArea.setTextFormatter(new TextFormatter<String>(new StringConverter<String>() {

            /**
             * 当调用commitValue时，才会执行此对象
             * 数据首先经过fromString, 将fromString的返回值再传入toString，toString的返回值现更新界面
             * @param object
             * @return
             */
            @Override
            public String toString(String object) {
                System.out.println("toString = " + object);
                return object;
            }

            @Override
            public String fromString(String string) {
                System.out.println("fromString = " + string);
                if(string != null){
                    if(string.contains("abc")){
                        String str = string.replace("abc", "123");
                        return str;
                    }
                }
                return string;
            }
        }));

        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            textArea.commitValue();
        });




        btnWrite.setOnAction(event -> textArea.setText("123"));
        btnCommit.setOnAction(event -> textArea.commitValue());





        root.getChildren().addAll(textField,textArea,btnWrite,btnCommit);




        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

        //设置光标焦点
        textArea.requestFocus();


    }
}
