package i_layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * TilePaneDemo class
 *
 * @author axin
 * @date 2023/9/17
 */
public class TilePaneDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        TilePane root = new TilePane();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();


        Button btn1 = new Button("btn1");
        btn1.setPrefHeight(100);
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

        root.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11);

        root.setPadding(new Insets(10));
        root.setHgap(10.0);
        root.setVgap(10.0);

        TilePane.setMargin(btn1,new Insets(50));

    }
}
