package h_widget;

import i_layout.VBoxDemo;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * SpinnerDemo class
 * 选择器
 *
 * @author axin
 * @date 2023/11/12
 */
public class SpinnerDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        Spinner spinner = new Spinner<Integer>(0,10,0,1);

        spinner.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println("valueProperty changed: " + newValue);
            }
        });

        ObservableList<String> strList = FXCollections.observableArrayList();
        strList.addAll("A","B","C","D");
        Spinner<String> stringSpinner = new Spinner<String>(strList);


        ObservableList<City> cities = buildList();
        Spinner<City> citySpinner = new Spinner<City>();

        //citySpinner.setEditable(true);

        //使用默认的ValueFactory
        //使用默认的ValueFactory时，创建Spinner时，需使用空的Spinner构造方法，否则默认值显示的是对象地址
        //SpinnerValueFactory.ListSpinnerValueFactory<City> defaultValueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<>(cities);
        //defaultValueFactory.setConverter(new MyStringConverter<City>());
        //citySpinner.setValueFactory(defaultValueFactory);


        //自定义ValueFactory，可自定义递进和递减的逻辑，如循环
        MyValueFactory myValueFactory = new MyValueFactory(cities);
        myValueFactory.setConverter(new MyStringConverter<City>());
        citySpinner.setValueFactory(myValueFactory);

        //设置默认值,需要在setConverter和setValueFactory方法后
        myValueFactory.setValue(cities.get(0));





        root.getChildren().addAll(spinner,stringSpinner,citySpinner);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }

    private ObservableList<City> buildList(){

        ObservableList<City> cities = FXCollections.observableArrayList();
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

    class MyStringConverter<City> extends StringConverter<SpinnerDemo.City>{
        @Override
        public String toString(SpinnerDemo.City object) {
            System.out.println("toString");
            if(object != null){
                return object.getId() + " - " + object.getName();
            }
            return null;
        }

        //可编辑时有效
        @Override
        public SpinnerDemo.City fromString(String string) {
            if(string.trim().length() != 0){
                return new SpinnerDemo.City("0",string);
            }
            return null;
        }
    }


    class MyValueFactory extends SpinnerValueFactory<City> {

        private ObservableList<City> list;

        private int index = -1;

        public MyValueFactory(ObservableList<City> list) {
            this.list = list;
        }

        /**
         *  递减
         *  steps 每次递减的数量
         */
        @Override
        public void decrement(int steps) {
            System.out.println("decrement: " + steps);
            index -= steps;
            if(index - steps < 0){
                index = 0;
            }
            City city = list.get(index);
            setValue(city);



        }

        /**
         * 递增
         * @param steps  steps 每次步进的数量
         */
        @Override
        public void increment(int steps) {
            System.out.println("increment: " + steps);
            index += steps;
            if(index > list.size() - 1){
                index = list.size() - 1;
            }
            City city = list.get(index);
            setValue(city);
        }




    }
}
