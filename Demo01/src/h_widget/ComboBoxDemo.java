package h_widget;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * ComboBoxDemo class
 *
 * ComboBoxDemo 的基本使用
 *
 * @author axin
 * @date 2023/10/22
 */
public class ComboBoxDemo extends Application {


    @Override
    public void start(Stage primaryStage) {


        AnchorPane root = new AnchorPane();

        ComboBox<String> combo = new ComboBox<>();
        combo.setPrefWidth(150);
        combo.getItems().addAll("iem1","item2","item3","item4","item5");
        //与choice的区别，可编辑
        combo.setEditable(true);

        combo.setPromptText("请输入关键字");
        //当无下拉数据时，展示一个默认的提示语
        combo.setPlaceholder(new Label("无数据"));



        Button button = new Button("让combo失去焦点");
        root.getChildren().addAll(combo,button);

        AnchorPane.setLeftAnchor(combo, 50.0);
        AnchorPane.setTopAnchor(combo,100.0);

        AnchorPane.setLeftAnchor(button, 250.0);
        AnchorPane.setTopAnchor(button,100.0);

        combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("ChangeListener = "+ newValue);
            }
        });

        combo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("setOnAction");
            }
        });



        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }
}
