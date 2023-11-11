package h_widget;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;


/**
 * ComboBoxDemo2 class
 * 自定义下拉项样式,String类型
 */
public class ComboBoxDemo2 extends Application {


    @Override
    public void start(Stage primaryStage) {


        AnchorPane root = new AnchorPane();

        ComboBox<String> combo = new ComboBox<>();
        combo.setPrefWidth(150);
        combo.getItems().addAll("iem1","item2","item3","item4","item5");


        root.getChildren().addAll(combo);
        combo.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {

                MyListCell<String> listCell = new MyListCell<>();

                return listCell;
            }
        });

        AnchorPane.setLeftAnchor(combo, 50.0);
        AnchorPane.setTopAnchor(combo,100.0);




        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }


    class MyListCell<T> extends ListCell<String>{
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if(!empty){
                HBox hBox = new HBox();
                hBox.setAlignment(Pos.CENTER_LEFT);
                CheckBox checkBox = new CheckBox();
                Label label = new Label(item);
                hBox.getChildren().addAll(checkBox,label);

                this.setGraphic(hBox);
            }


        }
    }
}
