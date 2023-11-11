package h_widget;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.Comparator;

/**
 * ChoiceBoxDemo class
 * 动态更新下拉选对象属性中的值
 *
 * @author axin
 * @date 2023/9/24
 */
public class ChoiceBoxObjectDemo3 extends Application {



    @Override
    public void start(Stage primaryStage) {

        AnchorPane root = new AnchorPane();


        ChoiceBox<City> choice2 = new ChoiceBox<>();
        choice2.setPrefWidth(200);

        Button button = new Button("更新选中对象的属性");
        Button button2 = new Button("更新下标为2的对象的属性");



        //转换下拉选展示的值
        choice2.setConverter(new StringConverter<City>() {
            @Override
            public String toString(City object) {
                if(object != null){
                    return object.getId() + " - " + object.getName();
                }
                return null;
            }

            @Override
            public City fromString(String string) {
                //在ChoiceBox中使用时，未发现此方法的用途
                return null;
            }
        });

        //城市
        ObservableList<City> cities = buildCity();

        choice2.getItems().setAll(cities);


        root.getChildren().addAll(choice2, button,button2);

        AnchorPane.setTopAnchor(choice2,10.0);
        AnchorPane.setLeftAnchor(choice2,50.0);

        AnchorPane.setTopAnchor(button,10.0);
        AnchorPane.setLeftAnchor(button,300.0);

        AnchorPane.setTopAnchor(button2,10.0);
        AnchorPane.setLeftAnchor(button2,450.0);

        button.setOnAction(event -> {
            City selectedItem = choice2.getSelectionModel().getSelectedItem();
            if(selectedItem != null){
                selectedItem.setName("我被更改了");
                int selectedIndex = choice2.getSelectionModel().getSelectedIndex();
                choice2.getItems().set(selectedIndex,selectedItem);
                choice2.getSelectionModel().select(selectedIndex);
            }

        });
        button2.setOnAction(event -> {
            int targetIndex = 2;
            City city = choice2.getItems().get(targetIndex);
            city.setName("我被指定更改了");

            //getSelectedIndex要在set(targetIndex,city)前面，因为set后，会清空已选择的
            int selectedIndex = choice2.getSelectionModel().getSelectedIndex();
            System.out.println("selectedIndex:" + selectedIndex);
            choice2.getItems().set(targetIndex,city);

            if(selectedIndex == targetIndex){
                //如果更改下标的对象是已经选择的，理重新选择一下
                choice2.getSelectionModel().select(selectedIndex);
            }



        });

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();



    }

    private ObservableList<City> buildCity(){

        //SimpleListProperty<City> cities = new SimpleListProperty<>();
        ObservableList<City> cities = FXCollections.observableArrayList();

        cities.add(new City("14","北京","直辖市"));
        cities.add(new City("13","天津","直辖市"));
        cities.add(new City("12","上海","直辖市"));
        cities.add(new City("11","重庆","直辖市"));




        return cities;

    }



    private class City{
        private String id;
        private String name;
        private String desc;

        public City(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public City(String id, String name, String desc) {
            this.id = id;
            this.name = name;
            this.desc = desc;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

}

