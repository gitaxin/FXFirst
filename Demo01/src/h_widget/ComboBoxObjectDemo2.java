package h_widget;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * ComboBoxDemo class
 * 对象类型的下拉值-模糊搜索
 *
 * @author axin
 * @date 2023/10/22
 */
public class ComboBoxObjectDemo2 extends Application {


    @Override
    public void start(Stage primaryStage) {


        AnchorPane root = new AnchorPane();

        ComboBox<City> combo = new ComboBox<>();

        List<City> cities = buildList();
        combo.getItems().addAll(cities);
        combo.setPrefWidth(150);

        //combo.setVisibleRowCount(3);

        //combo.setValue(new City());

        //与choice的区别，可编辑
        combo.setEditable(true);

        combo.setPromptText("请输入关键字");
        //当无下拉数据时，展示一个默认的提示语
        combo.setPlaceholder(new Label("无选项"));

        //获取combo的文本框对象，对值变化进行监听
        TextField textField = combo.editorProperty().get();



        //转换下拉选展示的值
        combo.setConverter(new StringConverter<City>() {
            @Override
            public String toString(City object) {
                if(object != null){
                    //转称City对象，将对象的属性设置为下拉选列表
                    return object.getId() + " - " + object.getName();
                }
                return null;
            }

            /**
             * 接收用户输入的值
             * @param string
             * @return
             */
            @Override
            public City fromString(String string) {
               return null;
            }
        });


        root.getChildren().addAll(combo);

        AnchorPane.setLeftAnchor(combo, 50.0);
        AnchorPane.setTopAnchor(combo,100.0);


        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if(newValue.trim().length() == 0){
                    combo.getItems().clear();
                    combo.getItems().addAll(cities);
                    combo.show();
                    return;
                }
                List<City> newList = cities.stream().filter(new Predicate<City>() {
                    @Override
                    public boolean test(City city) {
                        return city.getName().contains(newValue);

                    }
                }).collect(Collectors.toList());

                if(newList.isEmpty()){
                    combo.getItems().clear();
                    combo.show();
                    return;
                }
                combo.getItems().addAll(newList);

            }
        });


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.setTitle("演示模糊搜索");
        primaryStage.show();

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
