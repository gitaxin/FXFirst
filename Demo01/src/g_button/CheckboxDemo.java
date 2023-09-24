package g_button;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Checkbox class
 *
 * @author axin
 * @date 2023/9/24
 */
public class CheckboxDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        HBox root = new HBox();
        root.setSpacing(20);
        root.setPadding(new Insets(40));



        CheckBox c1 = new CheckBox("听歌");
        CheckBox c2 = new CheckBox("看电影");
        CheckBox c3 = new CheckBox("打游戏");
        CheckBox c4 = new CheckBox("烫头");

        List<CheckBox> checkBoxes = Arrays.asList(c1, c2, c3, c4);

        //设置默认选中
        c2.setSelected(true);
        //设置不确定状态
        c4.setIndeterminate(true);
        //禁用选择
        c3.setDisable(true);

        root.getChildren().addAll(checkBoxes);



        //监听选择属性改变
        c1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("c1 selectedProperty newValue = " + newValue);
        });

        //监听选中事件
        for (CheckBox checkBox : checkBoxes) {
            checkBox.setOnAction(event -> {
                CheckBox checkbox = (CheckBox) event.getSource();
                System.out.println("OnAction = " + checkbox.getText() + ", isSelected = " + checkbox.isSelected() + ", 不确定状态 = " + checkbox.isIndeterminate());

            });
        }





        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }
}
