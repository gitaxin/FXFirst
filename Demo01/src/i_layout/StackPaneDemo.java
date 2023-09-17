package i_layout;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.function.Consumer;

/**
 * StackPaneDemo class
 * 栈布局
 *
 * @author axin
 * @date 2023/9/17
 */
public class StackPaneDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();



        BorderPane ap1 = new BorderPane();
        ap1.setStyle("-fx-background-color: #499C54");
        ap1.setPrefWidth(400);
        ap1.setPrefHeight(400);


        BorderPane ap2 = new BorderPane();
        ap2.setStyle("-fx-background-color: #A87643");
        ap2.setPrefWidth(300);
        ap2.setPrefHeight(300);


        BorderPane ap3 = new BorderPane();
        ap3.setStyle("-fx-background-color: #F6F206");
        ap3.setPrefWidth(200);
        ap3.setPrefHeight(200);


        BorderPane ap4 = new BorderPane();
        ap4.setStyle("-fx-background-color: #9DEC1B");
        ap4.setPrefWidth(100);
        ap4.setPrefHeight(100);


        BorderPane ap5 = new BorderPane();
        ap5.setStyle("-fx-background-color: #AD6C79");
        ap5.setPrefWidth(50);
        ap5.setPrefHeight(50);


        //最后放入的在最上面显示
        root.getChildren().addAll(ap1,ap2,ap3,ap4,ap5);

        ObservableList<Node> children = root.getChildren();

        //每隔一秒切换一张
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                            Node node = children.remove(children.size() - 1);
                            children.add(0,node);
                        }
                    });
                }
            }
        }).start();




        //root.toBack();






    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Platform.exit();
    }
}
