package h_widget;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * HyperlinkDemo class
 *
 * @author axin
 * @date 2023/9/23
 */
public class HyperlinkDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        BorderPane borderPane = new BorderPane();
        //可以显示为超链接样式，当单击时会响应一个事件，在事件回调中可以处理一些逻辑
        //形式一
        Hyperlink hyperlink = new Hyperlink("www.baidu.com");
        hyperlink.setFont(Font.font(20));
        //形式二
        Hyperlink hyperlink2 = new Hyperlink("www.baidu.com",new Button("打开网址"));
        hyperlink2.setFont(Font.font(20));

        borderPane.setCenter(hyperlink2);

        //在事件回调中使用默认浏览器打开超链接中的地址
        hyperlink.setOnAction(event -> {
            Hyperlink hl = (Hyperlink)event.getSource();
            HostServices hostServices = getHostServices();
            hostServices.showDocument(hl.getText());

        });
        hyperlink2.setOnAction(event -> {
            Hyperlink hl = (Hyperlink)event.getSource();
            HostServices hostServices = getHostServices();
            hostServices.showDocument(hl.getText());

        });



        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.setTitle("Hyperlink演示");
        primaryStage.show();

    }
}
