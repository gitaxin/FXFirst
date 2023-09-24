package h_widget;

import javafx.application.Application;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ChoiceBoxDemo class
 * 下拉列表 - 级联选择器
 *
 * @author axin
 * @date 2023/9/24
 */
public class ChoiceBoxObjectDemo2 extends Application {



    @Override
    public void start(Stage primaryStage) {

        AnchorPane root = new AnchorPane();


        ChoiceBox<String> choice1 = new ChoiceBox<>();
        choice1.setPrefWidth(100);

        ChoiceBox<City> choice2 = new ChoiceBox<>();
        choice2.setPrefWidth(100);

        Button button = new Button("升序下拉列表");



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
        //省份
        ObservableList<City> address = buildList();

        choice1.getItems().addAll("直辖市","省份");

        root.getChildren().addAll(choice1, choice2, button);

        AnchorPane.setTopAnchor(choice1,10.0);
        AnchorPane.setLeftAnchor(choice1,10.0);

        AnchorPane.setTopAnchor(choice2,10.0);
        AnchorPane.setLeftAnchor(choice2,200.0);

        AnchorPane.setTopAnchor(button,10.0);
        AnchorPane.setLeftAnchor(button,320.0);



        //监听选中值
        choice1.valueProperty().addListener((observable, oldValue, newValue) -> {
             System.out.println("valueProperty = " + newValue);
             if("直辖市".equals(newValue)){
                 choice2.setItems(cities);
             }else{
                 choice2.setItems(address);
             }
         });


        button.setOnAction(event -> {
            String value = choice1.getValue();
            System.out.println(value);
            if(value == null || value.trim().length() == 0){
                return;
            }

            if("直辖市".equals(value)){
                //对原集合排序，直接改变原数据源
                cities.sort(new Comparator<City>() {
                    @Override
                    public int compare(City o1, City o2) {
                        return o1.getId().compareTo(o2.getId());
                    }
                });
            }else{

                address.sort(new Comparator<City>() {
                    @Override
                    public int compare(City o1, City o2) {
                        return o1.getId().compareTo(o2.getId());
                    }
                });
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


    private ObservableList<City> buildList(){

        //SimpleListProperty<City> cities = new SimpleListProperty<>();
        ObservableList<City> cities = FXCollections.observableArrayList();

        cities.add(new City("24","河北省","省份"));
        cities.add(new City("23","河南省","省份"));
        cities.add(new City("22","山东省","省份"));
        cities.add(new City("21","山西省","省份"));

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

