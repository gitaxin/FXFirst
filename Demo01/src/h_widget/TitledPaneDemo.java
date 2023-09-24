package h_widget;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * TitledPaneDemo class
 * 可折叠组件 TitledPane
 *
 * @author axin
 * @date 2023/9/24
 */
public class TitledPaneDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        VBox vBox = new VBox();
        root.setLeft(vBox);

        TitledPane titledPane1 = new TitledPane();
        //设置不允许折叠
        //titledPane1.setCollapsible(false);
        //设置是否折叠的
        titledPane1.setExpanded(false);
        titledPane1.setText("资金管理");
        VBox subv = new VBox();
        Button button = new Button("收入");
        Button button1 = new Button("支出");
        subv.getChildren().addAll(button,button1);
        titledPane1.setContent(subv);

        TitledPane titledPane2 = new TitledPane();
        //取消展开折叠动画
        titledPane2.setAnimated(false);
        titledPane2.setText("凭证管理");
        VBox subv2 = new VBox();
        Button btn1 = new Button("新增凭证");
        Button btn2 = new Button("凭证列表");
        subv2.getChildren().addAll(btn1,btn2);
        titledPane2.setContent(subv2);


        TitledPane titledPane3 = new TitledPane();
        //设置icon
        ImageView imageView = new ImageView("search.png");
        imageView.setFitHeight(16);
        imageView.setFitWidth(16);
        titledPane3.setGraphic(imageView);
        titledPane3.setText("报表管理");
        VBox subv3 = new VBox();
        Button btn11 = new Button("总账");
        Button btn22 = new Button("明细账");
        Button btn33 = new Button("序时账");
        subv3.getChildren().addAll(btn11,btn22,btn33);
        titledPane3.setContent(subv3);

        vBox.getChildren().addAll(titledPane1,titledPane2,titledPane3);

        //监听展开与折叠
        titledPane1.expandedProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("oldValue = " + oldValue + ", newValue = " + newValue);
        });


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(400);
        primaryStage.setHeight(500);
        primaryStage.show();

    }
}
