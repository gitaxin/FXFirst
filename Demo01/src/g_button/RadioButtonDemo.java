package g_button;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * RadioButton class
 *
 * @author axin
 * @date 2023/9/24
 */
public class RadioButtonDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        HBox root = new HBox();
        root.setSpacing(20);
        root.setPadding(new Insets(40));


        ToggleGroup tg = new ToggleGroup();
        RadioButton r1 = new RadioButton("男");
        RadioButton r2 = new RadioButton("女");
        RadioButton r3 = new RadioButton("未知");
        //将单选项放到一个组中，只能同时选中一个
        tg.getToggles().addAll(r1,r2,r3);

        root.getChildren().addAll(r1,r2,r3);

        //设置默认选中
        tg.selectToggle(r3);

        //监听选择属性改变
        r1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("r1 selectedProperty newValue = " + newValue);
        });

        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                if(oldValue != null){
                    RadioButton radio = (RadioButton) oldValue;
                    System.out.println("selectedToggle = " + radio.getText() + ", isSelected = " + radio.isSelected());
                }

                  if(newValue != null){
                      RadioButton radio = (RadioButton) newValue;
                      System.out.println("selectedToggle = " + radio.getText() + ", isSelected = " + radio.isSelected());
                  }

            }
        });






        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }
}
