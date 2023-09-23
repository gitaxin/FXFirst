package h_widget;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * MenuButtonDemo class
 *
 * @author axin
 * @date 2023/9/23
 */
public class MenuButtonDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        HBox hBox = new HBox();
        root.setTop(hBox);

        //样式一
        MenuButton menuButton = new MenuButton("删除");
        MenuItem deleteAll = new MenuItem("删除所有");
        MenuItem deleteChecked = new MenuItem("删除选中");
        //设置快捷键
        deleteChecked.setAccelerator(KeyCombination.valueOf("ctrl+d"));
        menuButton.getItems().addAll(deleteAll,deleteChecked);


        SplitMenuButton splitMenuButton = new SplitMenuButton();
        splitMenuButton.setText("请单击右侧箭头");
        splitMenuButton.getItems().addAll(new MenuItem("删除"),new MenuItem("删除所有"));

        hBox.getChildren().addAll(menuButton, splitMenuButton);


        for (MenuItem item : menuButton.getItems()) {
            //单击触发
            item.setOnAction(event -> {
                Object source = event.getSource();
                 MenuItem eventMenuItem = (MenuItem)source;
                System.out.println("OnAction = " + eventMenuItem.getText());

            });

            //快捷键触发
            item.setOnMenuValidation(event -> {
                Object source = event.getSource();
                MenuItem eventMenuItem = (MenuItem)source;
                System.out.println("MenuValidation = " + eventMenuItem.getText());
            });
        }


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }
}
