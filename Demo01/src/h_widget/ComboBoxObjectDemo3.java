package h_widget;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * ComboBoxObjectDemo3 class
 * 对象类型下拉选，自定义下拉选项样式
 */
public class ComboBoxObjectDemo3 extends Application {


    @Override
    public void start(Stage primaryStage) {


        AnchorPane root = new AnchorPane();

        ComboBox<City> combo = new ComboBox<>();

        List<City> cities = buildList();
        combo.getItems().addAll(cities);
        combo.setPrefWidth(150);



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


        combo.setCellFactory(new Callback<ListView<City>, ListCell<City>>() {

            /**
             * 此方法与setConverter无关系
             * @param param
             * @return
             */
            @Override
            public ListCell<City> call(ListView<City> param) {
                ListCell<City> cell = new ListCell<>(){
                    @Override
                    protected void updateItem(City item, boolean empty) {
                        //调用super不能删掉，上面是有自己的实现的
                        super.updateItem(item, empty);
                        if(!empty){
                            /**
                             * javaFx内部可能是如此实现的：获取setConverter设置的Converter,然后调用其toString方法，将对象类型转换为字符串
                             *  如果要想重写下拉项的样式，则重写下拉项的布局
                             */
                            //String string = combo.getConverter().toString(item);
                            //this.setGraphic(new Label(string));
                            //如果只是文本，可以使用setText
                            //this.setText(string);

                            //自定义下拉项布局
                            HBox hBox = new HBox();



                            VBox vBox1 = new VBox();
                            vBox1.setAlignment(Pos.CENTER);
                            ImageView imageView = new ImageView("list.png");
                            vBox1.getChildren().add(imageView);




                            VBox vBox = new VBox();
                            vBox.getChildren().add(new Label(item.getId()));
                            vBox.getChildren().add(new Label(item.getName()));
                            if(item.getDesc() != null && item.getDesc().trim().length() != 0){
                                vBox.getChildren().add(new Label(item.getDesc()));
                            }
                            hBox.getChildren().addAll(vBox1,vBox);
                            this.setGraphic(hBox);
                        }

                    }
                };

                return cell;
            }
        });











        root.getChildren().addAll(combo);

        AnchorPane.setLeftAnchor(combo, 50.0);
        AnchorPane.setTopAnchor(combo,100.0);




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
