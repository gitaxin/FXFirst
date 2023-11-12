package h_widget;

import com.sun.javafx.scene.control.InputField;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.skin.PaginationSkin;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * PaginationDemo class
 * 分页选择器
 *
 * @author axin
 * @date 2023/11/12
 */
public class PaginationDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();
        root.setPadding(new Insets(100));
        Pagination page = new Pagination();
        page.setPrefHeight(100);
        page.setStyle("""
               -fx-background-color:#ffffff;
                """);
        //设置总页数
        page.setPageCount(50);
        //未知总页数，默认
        //page.setPageCount(Pagination.INDETERMINATE);

        //设置每组显示的最大页码按钮数
        page.setMaxPageIndicatorCount(5);

        //设置当前第几页，下标从0开始
        page.setCurrentPageIndex(3);

        //设置分页器样式为圆点
        //page.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);


        page.currentPageIndexProperty().addListener((observable, oldValue, newValue) -> {

            System.out.println("curreng page is " + newValue);
        });

        page.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                return new Label(pageIndex + 1 + "");


            }
        });


        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        TextField text = new TextField();
        text.setPrefWidth(50);
        Button button = new Button("Go");
        boolean b = hBox.getChildren().addAll(page,text, button);

        button.setOnAction(event -> {
            int num = Integer.parseInt(text.getText());
            page.setCurrentPageIndex(num  - 1);
        });

        root.getChildren().addAll(hBox);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }
}
