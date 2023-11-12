package h_widget;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * DatePicter class
 *
 * JavaFx仅支持日期选择
 * 如果要选择时间，参考其他第三方库
 * https://blog.csdn.net/You_YuDeQieLan/article/details/133071810
 * https://github.com/taipeiben/DateTimePicker
 *
 * @author axin
 * @date 2023/11/12
 */
public class DatePicterDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();
        root.setPadding(new Insets(100));

        DatePicker dp = new DatePicker();
        dp.setEditable(false);



        root.getChildren().add(dp);



        dp.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate object) {
                if(object != null){
                    String format = object.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    return format;
                }
                return null;
            }

            @Override
            public LocalDate fromString(String string) {
                return null;
            }
        });

        dp.valueProperty().addListener((observable, oldValue, newValue) -> {
            String format = newValue.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println(format);

        });
        dp.setDayCellFactory(new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(DatePicker param) {
                DateCell dateCell = new DateCell(){
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item,empty);
                        if(!empty){
                            DayOfWeek dayOfWeek = item.getDayOfWeek();
                            if(dayOfWeek.getValue() == 6){
                                //替换整个单元格内容
                                this.setText("加班日");
                            }
                            if(dayOfWeek.getValue() == 7){
                                this.setGraphic(new Label("休息日"));
                            }

                        }

                    }
                };
                return dateCell;
            }
        });



        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }
}
