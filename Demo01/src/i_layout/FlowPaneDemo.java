package i_layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FlowPane class
 * 流式布局
 *
 * @author axin
 * @date 2023/9/17
 */
public class FlowPaneDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        FlowPane root = new FlowPane();
        root.setStyle("-fx-background-color: #ffffff");


        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn2");
        Button btn3 = new Button("btn3");
        Button btn4 = new Button("btn4");
        Button btn5 = new Button("btn5");
        Button btn6 = new Button("btn6");
        Button btn7 = new Button("btn7");
        Button btn8 = new Button("btn8");
        Button btn9 = new Button("btn9");
        Button btn10 = new Button("btn10");
        Button btn11 = new Button("btn11");

        //超出容器宽高后，会自动换行
        root.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11);

        root.setPadding(new Insets(10));

        //对某个元素设置外边距
        FlowPane.setMargin(btn1,new Insets(10));

        //设置对齐方式
        root.setAlignment(Pos.CENTER);

        //设置元素水平间距
        root.setHgap(10);
        //设置元素垂直间距
        root.setVgap(10);

        //设置元素排列方向
        //root.setOrientation(Orientation.VERTICAL);


        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();


    }
}
