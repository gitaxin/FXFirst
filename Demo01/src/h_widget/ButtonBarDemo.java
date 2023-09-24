package h_widget;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * ButtonBarDemo class
 *
 * @author axin
 * @date 2023/9/24
 */
public class ButtonBarDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        ButtonBar buttonBar = new ButtonBar();
        Button button1 = new Button("新增");
        Button button2 = new Button("修改");
        Button button3 = new Button("查询");



        ///根据平台ButtonOrder传入的平台不同，按照标签排列的顺序也不同, 如果不设置标签，不会自动排序
        ButtonBar.setButtonData(button1, ButtonBar.ButtonData.APPLY);
        ButtonBar.setButtonData(button2, ButtonBar.ButtonData.FINISH);
        ButtonBar.setButtonData(button3, ButtonBar.ButtonData.NO);
        //buttonBar.setButtonOrder(ButtonBar.BUTTON_ORDER_WINDOWS);

        buttonBar.getButtons().addAll(button1,button2,button3);

        button1.setPrefWidth(200);
        //当设置为true时，所有按钮所占空间都按最宽的按钮的空间显示
        ButtonBar.setButtonUniformSize(button1,false);

        for (Node node : buttonBar.getButtons()) {
            Button btn = (Button) node;
            btn.setOnAction(event -> {
                Button source = (Button) event.getSource();
                System.out.println("OnAction = " + source.getText());

                ButtonBar.ButtonData buttonData = ButtonBar.getButtonData(source);
                if(buttonData != null){
                    String typeCode = buttonData.getTypeCode();
                    System.out.println("buttonData = " + buttonData);
                }


            });

        }

        root.setTop(buttonBar);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }
}
