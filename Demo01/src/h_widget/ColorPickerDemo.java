package h_widget;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * ColorPickerDemo class
 *
 * @author axin
 * @date 2023/11/12
 */
public class ColorPickerDemo extends Application {


    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();
        //root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(100));


        //ColorPicker cp = new ColorPicker();
        //设置默认颜色
        ColorPicker cp = new ColorPicker(Color.valueOf("#ff0000"));

        cp.setOnAction(event -> {
            Color value = cp.getValue();
            double red = value.getRed();
            double green = value.getGreen();
            double blue = value.getBlue();
            String format = String.format("""
                    red:%s
                    green:%s
                    green:%s
                    """, red, green, blue);
            String format2 = String.format("""
                    red:%s
                    green:%s
                    green:%s
                    """, red*255, green*255, blue*255);


            String hex = value.toString().replace("0x","");
            System.out.println(format);
            System.out.println(format2);
            System.out.println(hex);

            root.setStyle(String.format("""
                   -fx-background-color:#%s;
                    """, hex));
        });

        cp.valueProperty().addListener((observable, oldValue, newValue) -> {
            String string = newValue.toString();
            System.out.println("Hex: #" + string);

        });




        root.getChildren().add(cp);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

    }
}
