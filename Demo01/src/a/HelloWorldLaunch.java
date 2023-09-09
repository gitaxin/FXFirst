package a;

import javafx.application.Application;

/**
 * 程序入口：第2种方式
 * 将Main方法与Launch类分开写，这样不需添加VM Options
 * 也无需添加 module-info.java文件
 *
 * @author axin
 * @date 2023/9/9
 */
public class HelloWorldLaunch {

    public static void main(String[] args) {
        Application.launch(HelloWorld.class,args);
    }
}
