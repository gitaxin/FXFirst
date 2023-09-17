package i_layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 * GridPaneDemo class
 *
 * @author axin
 * @date 2023/9/17
 */
public class GridPaneDemo extends Application {


    @Override
    public void start(Stage primaryStage) {



        GridPane root = new GridPane();
        root.setStyle("-fx-background-color: blue");


        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn2");
        Button btn3 = new Button("btn333333");
        Button btn4 = new Button("btn4");
        Button btn5 = new Button("btn5");
        Button btn6 = new Button("btn6666666666");
        Button btn7 = new Button("btn7");
        Button btn8 = new Button("btn8");
        Button btn9 = new Button("btn9");
        Button btn10 = new Button("btn10");
        Button btn11 = new Button("btn11");

        Button btn12 = new Button("第2种方式添加");

        Button btn13 = new Button("第3种方式添加");


        //第1种方式添加元素到grid
        root.add(btn1,0,0);
        root.add(btn2,1,0);
        root.add(btn3,2,0);
        root.add(btn4,3,0);
        root.add(btn5,0,1);
        root.add(btn6,1,1);
        root.add(btn7,2,1);
        root.add(btn8,3,1);
        root.add(btn9,0,2);
        root.add(btn10,1,2);
        root.add(btn11,2,2);

        //第2种方式添加元素到grid
        GridPane.setConstraints(btn12,3,2);
        root.getChildren().add(btn12);


        //第3种方式添加元素到grid
        GridPane.setColumnIndex(btn13,0);
        GridPane.setRowIndex(btn13,3);
        root.getChildren().add(btn13);





        root.setPadding(new Insets(10));

        //对某个元素设置外边距
        GridPane.setMargin(btn1,new Insets(10));

        //设置对齐方式
        //root.setAlignment(Pos.CENTER);

        //设置元素水平间距
        root.setHgap(10);
        //设置元素垂直间距
        root.setVgap(10);

        //设置列宽
       root.getColumnConstraints().add(new ColumnConstraints(100));
       //设置行高
       root.getRowConstraints().addAll(new RowConstraints(100),new RowConstraints(100));



        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(400);
        primaryStage.show();

    }
}
