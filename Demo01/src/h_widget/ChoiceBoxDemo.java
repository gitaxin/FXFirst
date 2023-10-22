package h_widget;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * ChoiceBoxDemo class
 * 下拉列表
 * 少量选项建议使用
 *
 * @author axin
 * @date 2023/9/24
 */
public class ChoiceBoxDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        AnchorPane root = new AnchorPane();
        root.setPadding(new Insets(10));

        ChoiceBox<String> choice = new ChoiceBox<>();
        choice.setPrefWidth(100);

        boolean b = choice.getItems().addAll("北京", "天津", "上海");
        root.getChildren().addAll(choice);
        AnchorPane.setTopAnchor(choice,10.0);
        AnchorPane.setLeftAnchor(choice,10.0);

        //设置选中值
        choice.setValue("天津");

        choice.getSelectionModel().select(2);
        //选择前一个
        choice.getSelectionModel().selectPrevious();

        //默认显示下拉选，要在show方法后
        //choice.show();

        //监听选中值
         choice.valueProperty().addListener((observable, oldValue, newValue) -> {
             System.out.println("valueProperty = " + newValue);
         });

         //第二种方法监听选中值
         choice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
             @Override
             public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                 System.out.println("selectedItemProperty = " + newValue);
             }
         });





        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

        //默认显示下拉选，要在show方法后
        //choice.show();


    }
}
