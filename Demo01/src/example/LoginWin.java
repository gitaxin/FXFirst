package example;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * LoginWin class
 *
 * @author axin
 * @date 2023/9/23
 */
public class LoginWin extends Application {

    private class MyWindow {
        private final Stage stage = new Stage();

        public MyWindow() {

            BorderPane borderPane = new BorderPane();
            Text text = new Text("登录成功!");
            borderPane.setCenter(text);

            Scene scene = new Scene(borderPane);

            stage.setScene(scene);
            stage.setWidth(600);
            stage.setHeight(500);
            stage.setTitle("hello javafx");
            stage.show();

        }
    }


    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();
        root.setStyle("-fx-background-color: #fff5ee");

        Font font = Font.font(16);


        Label l_username = new Label("用户名:");
        l_username.setFont(font);

        Label l_password = new Label("密码:");
        l_password.setFont(font);

        TextField t_username = new TextField();
        //用于测试登录，实际使用时应该存在于数据库
        t_username.setUserData("admin");
        t_username.setTooltip(new Tooltip("请输入用户名"));


        //setUserData内部其实是用Properties存了一个Key为UserData对象的键值对，查看源码可知
        //t_username.getProperties().put("key","value");
        //t_username.getProperties().get("key");

        t_username.getProperties().addListener(new MapChangeListener<Object, Object>() {
            @Override
            public void onChanged(Change<?, ?> change) {
                System.out.println(change.getKey() + "=" + change.getMap().get(change.getKey()));
            }
        });


        PasswordField p_password = new PasswordField();
        //用于测试登录，实际使用时应该存在于数据库
        p_password.setUserData("123456");
        p_password.setTooltip(new Tooltip("请输入密码"));


        Text t_hint = new Text();
        //t_hint.setFill(Paint.valueOf("#ff0000"));
        t_hint.setFill(Color.RED);

        Button b_reset = new Button("重置");
        b_reset.setFont(font);


        Button b_login = new Button("登录");
        b_login.setFont(font);

        root.add(l_username,0,0);
        root.add(t_username,1,0);

        root.add(l_password,0,1);
        root.add(p_password,1,1);

        root.add(b_reset,0,2);
        root.add(b_login,1,2);

        root.add(t_hint,0,3);

        root.getRowConstraints().addAll(new RowConstraints(40),new RowConstraints(40),new RowConstraints(40));
        root.getColumnConstraints().addAll(new ColumnConstraints(60),new ColumnConstraints(250));

        //root.setHgap(5);
        root.setVgap(15);

        root.setAlignment(Pos.CENTER);

        //root.getCellBounds(1,2).
        GridPane.setMargin(b_login,new Insets(0,0,0,180));

        t_username.setOnKeyPressed(event -> {
            String name = event.getCode().getName();
            if("Enter".equals(name)){
                b_login.fire();
            }
        });
        p_password.setOnKeyPressed(event -> {
            String name = event.getCode().getName();
            if("Enter".equals(name)){
                b_login.fire();
            }
        });

        b_reset.setOnAction(event -> {
            t_username.setText("");
            p_password.setText("");
            //保存重置次数
            String countKey = "count";
            ObservableMap<Object, Object> properties = t_username.getProperties();
            Object count = properties.get(countKey);
            if(count == null){
                count = 0;
            }
            int ncount = Integer.parseInt(count.toString());
            ncount++;
            t_username.getProperties().put(countKey,ncount);

        });

        b_login.setOnAction(event -> {


            String dataUsername = t_username.getUserData().toString();
            String dataPassword = p_password.getUserData().toString();

            String username = t_username.getText().trim();
            String password = p_password.getText().trim();
            if(dataUsername.equals(username) && dataPassword.equals(password)){
                System.out.println("登录成功！");
                primaryStage.close();
                new MyWindow();


            }else{
                System.out.println("登录失败！");

                ///动画
                //登录窗口闪一下
                FadeTransition fade = new FadeTransition();
                fade.setDuration(Duration.millis(80));
                fade.setNode(root);
                fade.setFromValue(0);
                fade.setToValue(1);
                fade.play();
                t_hint.setText("登录失败！");
            }


        });


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setTitle("登录");
        primaryStage.show();

    }
}


