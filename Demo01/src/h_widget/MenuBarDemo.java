package h_widget;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;

/**
 * MenuBarDemo class
 *
 * @author axin
 * @date 2023/9/23
 */
public class MenuBarDemo extends Application {


    @Override
    public void start(Stage primaryStage) {


        BorderPane root = new BorderPane();
        MenuBar menuBar = new MenuBar();
        root.setTop(menuBar);

        Menu m_file = new Menu("文件");

        ImageView imageView = new ImageView("edit.png");
        imageView.setFitWidth(16);
        imageView.setFitHeight(16);

        Menu m_edit = new Menu("编辑",imageView);

        Menu m_view = new Menu("查看");

        Menu m_tool = new Menu("选项");

        Menu m_help = new Menu("帮助");

        menuBar.getMenus().addAll(m_file,m_edit,m_view,m_tool,m_help);


        MenuItem item_new = new MenuItem("新建");
        //设置带快捷键的菜单
        MenuItem item_open = new MenuItem("打开");
        item_open.setAccelerator(KeyCombination.valueOf("alt+o"));

        //可以设置三级菜单
        Menu item_recent = new Menu("最近");
        MenuItem item_recent1 = new MenuItem("file1");
        MenuItem item_recent2 = new MenuItem("file1");
        item_recent.getItems().addAll(item_recent1,item_recent2);;


        //设置带图标的菜单
        MenuItem item_print = new MenuItem("打印",new ImageView("print.png"));
        item_print.setAccelerator(KeyCombination.valueOf("ctrl+shift+p"));

        MenuItem item_exit = new MenuItem("退出");

        //菜单项分割线
        SeparatorMenuItem separ1 = new SeparatorMenuItem();
        SeparatorMenuItem separ2 = new SeparatorMenuItem();

        m_file.getItems().addAll(item_new,item_open,item_recent,separ1,item_print,separ2,item_exit);

        MenuItem item_cut= new MenuItem("剪切");
        MenuItem item_copy = new MenuItem("复制");
        MenuItem item_paste = new MenuItem("粘贴");
        //设置菜单项不可见
        //item_paste.setVisible(false);
        MenuItem item_delete = new MenuItem("删除");
        //设置菜单项禁用
        item_delete.setDisable(true);

        m_edit.getItems().addAll(item_cut,item_copy,item_paste,item_delete);


        //设置可以单选的菜单项
        ToggleGroup tg = new ToggleGroup();
        RadioMenuItem radio1 = new RadioMenuItem("查看当前");
        //默认先中
        radio1.setSelected(true);
        RadioMenuItem radio2 = new RadioMenuItem("查看所有");
        radio1.setToggleGroup(tg);
        radio2.setToggleGroup(tg);
        m_view.getItems().addAll(radio1,radio2);

        //设置带选中状态的菜单项
        CheckMenuItem checkItemRun = new CheckMenuItem("开机自动运行");
        CheckMenuItem checkItemMin = new CheckMenuItem("启动后最小化到系统托盘");
        m_tool.getItems().addAll(checkItemRun,checkItemMin);


        //自定义菜单项
        CustomMenuItem customMenuItem1 = new CustomMenuItem();
        Button button = new Button("关于");
        customMenuItem1.setContent(button);

        CustomMenuItem customMenuItem2 = new CustomMenuItem();
        HBox hBox = new HBox();
        hBox.getChildren().addAll(new Button("btn1"),new Button("btn2"),new Button("btn3"));
        customMenuItem2.setContent(hBox);

        CustomMenuItem customMenuItem3 = new CustomMenuItem();
        ProgressBar progressBar = new ProgressBar(0.4);
        customMenuItem3.setContent(progressBar);

        m_help.getItems().addAll(customMenuItem1,customMenuItem2,customMenuItem3);


        //ObservableList<Toggle> toggles = tg.getToggles();
        //for (Toggle toggle : toggles) {
        //    RadioMenuItem radio = (RadioMenuItem)toggle;
        //    radio.setOnAction(event -> {
        //        RadioMenuItem source = (RadioMenuItem)event.getSource();
        //        String text = source.getText();
        //        System.out.println("RadioMenuItem = " + text + ", isSelected = " + source.isSelected());
        //
        //    });
        //
        //}

        //给所有菜单项绑定事件
        for (Menu menu : menuBar.getMenus()) {
            for (MenuItem item : menu.getItems()) {
                item.setOnAction(event -> {
                    Object eventSource = event.getSource();
                    if(eventSource instanceof RadioMenuItem source){
                        System.out.println("RadioMenuItem = " + source.getText() + ", isSelected = " + source.isSelected());
                    }else if (eventSource instanceof CheckMenuItem source){
                        System.out.println("CheckMenuItem = " + source.getText() + ", isSelected = " + source.isSelected());
                    }else if (eventSource instanceof CustomMenuItem source){
                        Node node = source.getContent();
                        if(node instanceof Button btn2){
                            System.out.println("CustomMenuItem-Button = " + btn2.getText());
                        }else if(node instanceof ProgressBar prog){
                            System.out.println("CustomMenuItem-ProgressBar Progress = " + prog.getProgress());
                        }else if(node instanceof HBox hbox){
                            for (Node child : hbox.getChildren()) {
                                System.out.println("CustomMenuItem-HBox = " + ((Button)child).getText());
                            }
                        }
                    }else{
                        MenuItem source = (MenuItem)eventSource;
                        System.out.println("MenuItem = " + source.getText());
                    }
                });
            }
        }


        m_file.setOnAction(event -> {
            //当菜单下的菜单项单击时,事件会向上冒泡，此事项也会响应
            Menu menu = (Menu)event.getSource();
            System.out.println("onAction = " + menu.getText());
        });

        //当菜单下拉展示时执行
        m_file.setOnShowing(event -> {
            Menu menu = (Menu)event.getSource();
            System.out.println("showing = " + menu.getText());
        });
        //当菜单下拉展示完执行
        m_file.setOnShown(event -> {
            Menu menu = (Menu)event.getSource();
            System.out.println("shown = " + menu.getText());
        });

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.setTitle("MenuBar演示");
        primaryStage.show();

    }
}
