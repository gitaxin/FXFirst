package i_layout;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * AnchorPaneDemo2 class
 *
 * AnchorPane 与 group
 *
 * @author axin
 * @date 2023/9/17
 */
public class AnchorPaneDemo2 extends Application {


    @Override
    public void start(Stage primaryStage) {

        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn2");
        btn2.setLayoutX(50);

        Button btn3 = new Button("btn3");
        Button btn4 = new Button("btn4");
        btn4.setLayoutX(50);

        Group g1 = new Group();
        g1.getChildren().addAll(btn1,btn2);

        //group无法设置样式
        g1.setStyle("""
           
            -fx-border-color: #000000;
            -fx-border-radius: 20;
            -fx-border-style: dashed;
            -fx-border-width: 4;
            
            """);
        Group g2 = new Group();
        g2.getChildren().addAll(btn3,btn4);


        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color: #AAE360");
        ap.getChildren().addAll(g1,g2);

        AnchorPane.setTopAnchor(g1,100.0);
        AnchorPane.setLeftAnchor(g1,100.0);

        AnchorPane.setTopAnchor(g2,200.0);
        AnchorPane.setLeftAnchor(g2,200.0);


        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }
}
