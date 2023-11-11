package h_widget;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * ChoiceBoxDemo class
 * 下拉列表 - 引用类型数据
 *
 * @author axin
 * @date 2023/9/24
 */
public class ChoiceBoxObjectDemo extends Application {



    @Override
    public void start(Stage primaryStage) {

        AnchorPane root = new AnchorPane();
        root.setPadding(new Insets(10));

        ChoiceBox<City> choice = new ChoiceBox<>();
        choice.setPrefWidth(100);

        //转换下拉选展示的值
        choice.setConverter(new StringConverter<City>() {
            @Override
            public String toString(City object) {
                if(object != null){
                    //转称City对象，将对象的属性设置为下拉选列表
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

        List<City> cities = buildList();

        boolean b = choice.getItems().addAll(cities);



        root.getChildren().addAll(choice);

        AnchorPane.setTopAnchor(choice,10.0);
        AnchorPane.setLeftAnchor(choice,10.0);

        //设置选中值
        //choice.setValue("天津");

        choice.getSelectionModel().select(2);



        //监听选中值
         choice.valueProperty().addListener((observable, oldValue, newValue) -> {
             System.out.println("valueProperty = " + newValue.getName());
         });



        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

        //默认显示下拉选，要在show方法后
        //choice.show();


    }

    private List<City> buildList(){

        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City("1","北京","北京市"));
        cities.add(new City("2","天津","天津市"));
        cities.add(new City("3","上海","上海市"));
        cities.add(new City("4","重庆","重庆市"));
        cities.add(new City("5","雄安","雄安市"));


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

