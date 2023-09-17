package i_layout;

import com.sun.glass.ui.Screen;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * DialogPaneDemo class
 *
 * @author axin
 * @date 2023/9/17
 */
public class DialogPaneDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        AnchorPane root = new AnchorPane();
        root.setStyle("-fx-background-color: blue");

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

        Button btn1 = new Button("对话框");
        root.getChildren().add(btn1);
        AnchorPane.setTopAnchor(btn1,100.0);
        AnchorPane.setLeftAnchor(btn1,100.0);

        btn1.setOnAction(event -> {
            DialogPane dialog = new DialogPane();

            dialog.setPadding(new Insets(20));

            Scene sc = new Scene(dialog);

            dialog.setHeaderText("标题");

            dialog.setContentText("内容");

            dialog.setGraphic(new ImageView("love.png"));

            dialog.getButtonTypes().add(ButtonType.APPLY);
            dialog.getButtonTypes().add(ButtonType.CANCEL);
            dialog.getButtonTypes().add(ButtonType.OK);


            Button ok  = (Button)dialog.lookupButton(ButtonType.OK);
            Button cancel = (Button)dialog.lookupButton(ButtonType.CANCEL);

            dialog.setExpandableContent(new Text("扩展内容"));
            //设置是否展示扩展内容
            dialog.setExpanded(false);




            Stage stage = new Stage();
            stage.setScene(sc);
            stage.setTitle("对话框");
            stage.initOwner(primaryStage);
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);

            ok.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    stage.close();
                }
            });
            cancel.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    stage.close();
                }
            });


            stage.show();

        });


    }
}
