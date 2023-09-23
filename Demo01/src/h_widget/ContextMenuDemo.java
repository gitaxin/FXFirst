package h_widget;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * ContextMenuDemo class
 *
 * @author axin
 * @date 2023/9/23
 */
public class ContextMenuDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        HBox hbox = new HBox();
        root.setCenter(hbox);



        ContextMenu contextMenu = new ContextMenu();
        MenuItem item1 = new MenuItem("打开");
        MenuItem item2 = new MenuItem("选择");
        MenuItem item3 = new MenuItem("删除");
        MenuItem item4 = new MenuItem("属性");
        contextMenu.getItems().addAll(item1,item2,item3,item4);

        TextArea text = new TextArea("右键单击显示上下文菜单");
        text.setContextMenu(contextMenu);

        //上下文菜单展示后触发
        text.setOnContextMenuRequested(event -> {
            Object source = event.getSource();
            //获取右键单击的对象，可根据对象动态设置上下文菜单项的显示与隐藏
            TextArea textArea = (TextArea) source;
            //textArea.getContextMenu().getItems().get(0).setVisible(false);
            System.out.println("OnContextMenuRequested : 上下文菜单显示");
        });


        for (MenuItem item : contextMenu.getItems()) {
            //用户单击上下文菜单项后触发
            item.setOnAction(event -> {
                Object source = event.getSource();
                MenuItem menuItem = (MenuItem) source;
                System.out.println("OnAction = " + menuItem.getText());
            });
        }

        hbox.getChildren().addAll(text);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }
}
