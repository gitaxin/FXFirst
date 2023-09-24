package h_widget;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * TabPaneDemo class
 *
 * @author axin
 * @date 2023/9/24
 */
public class TabPaneDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        Button btnNew = new Button("新增Tab");
        root.setTop(btnNew);


        TabPane tabPane = new TabPane();
        Tab tab = new Tab("总账",getNode("总账内容"));
        //设置不可关闭
        tab.setClosable(false);

        Tab tab2 = new Tab("明细账",getNode("明细账内容"));

        //设置icon
        ImageView imageView = new ImageView("list.png");
        imageView.setFitWidth(16);
        imageView.setFitHeight(16);
        tab2.setGraphic(imageView);

        Tab tab3 = new Tab("序时账",getNode("序时账内容"));
        tabPane.getTabs().addAll(tab,tab2,tab3);

        //设置默认选中
        tabPane.getSelectionModel().select(tab2);
        //tabPane.getSelectionModel().select(1);
        //tabPane.getSelectionModel().selectFirst();
        //tabPane.getSelectionModel().selectLast();
        //tabPane.getSelectionModel().selectPrevious();
        //tabPane.getSelectionModel().selectNext();

        //设置所有不允许关闭
        //tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        //设置禁用
        //tabPane.setDisable(true);

        //设置tab标签在哪个方向
        //tabPane.setSide(Side.LEFT);
        //tabPane.setRotateGraphic(false);

        //tabPane切换事件
        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("oldValue = " +oldValue.getText() + ", newValue = " + newValue.getText());
        });

        //当Tab选择状态改变时触发
        for (Tab currTab : tabPane.getTabs()) {
            currTab.setOnSelectionChanged(new EventHandler<Event>() {
                @Override
                public void handle(Event event) {
                    Tab source = (Tab) event.getSource();
                    boolean selected = source.isSelected();
                    System.out.println("OnSelectionChanged = " + source.getText() + " - " + selected);
                }
            });
            currTab.setOnClosed(event -> {
                Tab source = (Tab) event.getSource();
                System.out.println("OnClosed = " + source.getText());
            });

            currTab.setOnCloseRequest(event -> {
                Tab source = (Tab) event.getSource();
                System.out.println("OnCloseRequest = " + source.getText());
                //consume()方法会阻止事件向上冒泡
                //event.consume();
            });
        }







        btnNew.setOnAction(event -> {
            ObservableList<Tab> tabs = tabPane.getTabs();
            Tab nTab = new Tab("new" + tabs.size(),getNode("new" + tabs.size()));
            tabs.add(nTab);
        });

        root.setCenter(tabPane);



        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }

    private Node getNode(String text){
        AnchorPane anchorPane = new AnchorPane();
        TextArea textArea = new TextArea();
        textArea.setText(text);
        anchorPane.setPadding(new Insets(2));
        AnchorPane.setTopAnchor(textArea,0.0);
        AnchorPane.setLeftAnchor(textArea,0.0);
        anchorPane.getChildren().add(textArea);
        return anchorPane;

    }
}
