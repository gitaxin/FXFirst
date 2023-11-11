package h_widget;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * ComboBoxDemo class
 * 1.对象类型的下拉值
 * 2.ComboBox为自定义对象类型下拉选时，动态更新下拉对象属性的值
 *
 * @author axin
 * @date 2023/10/22
 */
public class ComboBoxObjectDemo extends Application {


    @Override
    public void start(Stage primaryStage) {


        AnchorPane root = new AnchorPane();

        ComboBox<City> combo = new ComboBox<>();

        List<City> cities = buildList();
        combo.getItems().addAll(cities);
        combo.setPrefWidth(150);

        combo.setVisibleRowCount(3);

        //combo.setValue(new City());

        //与choice的区别，可编辑
        combo.setEditable(false);

        combo.setPromptText("请输入关键字");
        //当无下拉数据时，展示一个默认的提示语
        combo.setPlaceholder(new Label("无选项"));




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
             * 失去焦点时，用户在combo中输入了数据，就算是没有输入也会调用此方法
             * @param string
             * @return
             */
            @Override
            public City fromString(String string) {
                System.out.println(string);
                if(string.trim().length() > 0){
                    return new City("0",string);
                }
                return null;
            }
        });

        //演示失去焦点时，获取用户在combo中输入的数据
        Button button = new Button("让combo失去焦点");
        Button btnUpdate = new Button("修改下拉选对象的值（当combo可编辑时会存在冲突，测试该功能时请将combo的Editable属性设置为false）");
        root.getChildren().addAll(combo,button,btnUpdate);

        AnchorPane.setLeftAnchor(combo, 50.0);
        AnchorPane.setTopAnchor(combo,100.0);

        AnchorPane.setLeftAnchor(button, 250.0);
        AnchorPane.setTopAnchor(button,100.0);

        AnchorPane.setLeftAnchor(btnUpdate, 450.0);
        AnchorPane.setTopAnchor(btnUpdate,100.0);

        combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<City>() {
            @Override
            public void changed(ObservableValue<? extends City> observable, City oldValue, City newValue) {
                System.out.println("ChangeListener = "+ newValue);
            }
        });

        btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int selectedIndex = combo.getSelectionModel().getSelectedIndex();
                System.out.println("selectedIndex:" + selectedIndex);
                if(selectedIndex >= 0){
                    combo.getItems().get(selectedIndex).setName("我被修改了");
                    //清空已选择的，再重新选择一下，就会更新修改的属性
                    combo.getSelectionModel().clearSelection();
                    combo.getSelectionModel().select(selectedIndex);
                }




            }
        });




        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
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
