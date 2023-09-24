package example;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * FindAndReplace class
 *
 * @author axin
 * @date 2023/9/24
 */
public class FindAndSort extends Application {

    //保存上次查询的位置，下次继续从此处往后查
    int lastIndex = -1;

    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(5);
        TextField textField = new TextField();

        Button btnFind = new Button("查找");
        Button btnSort = new Button("排序");

        HBox top = new HBox();
        top.setSpacing(10);
        top.getChildren().addAll(textField,btnFind,btnSort);
        root.getChildren().add(top);

        HBox content = new HBox();
        TextArea textArea = new TextArea();
        content.getChildren().add(textArea);
        root.getChildren().add(content);

        //查找
        btnFind.setOnAction(event -> {
            textArea.getParagraphs().forEach(new Consumer<CharSequence>() {
                @Override
                public void accept(CharSequence charSequence) {
                    String keyword = textField.getText();
                    if(keyword == null || keyword.trim().length() == 0){
                        return;
                    }
                    if(charSequence.isEmpty()){
                        return;
                    }
                    System.out.println(lastIndex);
                    lastIndex ++;
                    lastIndex = charSequence.toString().indexOf(keyword,lastIndex);

                    if(lastIndex >= 0){
                        //按位置选择指定长度
                        textArea.selectRange(lastIndex,lastIndex + keyword.length());
                        textArea.requestFocus();
                    }else{
                        System.out.println("无查询结果！");

                    }
                }
            });

        });

        //排序
        btnSort.setOnAction(event -> {
            String text = textArea.getText();
            if(text != null && text.trim().length() > 0){
                char[] chars = text.toCharArray();
                List<String> list = new ArrayList<>();
                for (char c : chars) {
                    list.add(String.valueOf(c));
                }
                String newString = list.stream().sorted((o1,o2) -> o1.compareTo(o2)).collect(Collectors.joining());
                textArea.setText(newString);
            }
        });






        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(400);
        primaryStage.show();

    }
}
