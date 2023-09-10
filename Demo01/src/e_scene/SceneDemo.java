package e_scene;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Demo class
 *
 * Bounds 是整个屏幕信息，VisualBounds是除任务栏以外区域信息
 *
 * @author axin
 * @date 2023/9/10
 */
public class SceneDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //多显示器时获取屏幕列表
        ObservableList<Screen> screens = Screen.getScreens();
        System.out.println("screens size = " + screens.size());

        //获取主屏幕列表
        Screen screen = Screen.getPrimary();

        //获取屏幕DPI
        double dpiValue = screen.getDpi();
        System.out.println("dei = " + dpiValue);

        //获取屏幕宽高及坐标信息
        System.out.println("Bounds ====================================");

        Rectangle2D rec1 = screen.getBounds();

        double minX = rec1.getMinX();
        double minY = rec1.getMinY();
        double maxX = rec1.getMaxX();
        double maxY = rec1.getMaxY();
        double width = rec1.getWidth();
        double height = rec1.getHeight();

        System.out.println("Left Top Point = (" +minX + "," + minY + ")");
        System.out.println("Right Bottom Point = (" +maxX + "," + maxY + ")");
        System.out.println("width = " + width + ", height = " + height);

        System.out.println("VisualBounds ====================================");

        Rectangle2D rec2 = screen.getVisualBounds();

        double visMinX = rec2.getMinX();
        double visMinY = rec2.getMinY();
        double visMaxX = rec2.getMaxX();
        double visMaxY = rec2.getMaxY();
        double visWidth = rec2.getWidth();
        double visHeight = rec2.getHeight();

        System.out.println("Visual Left Top Point = (" +visMinX + "," + visMinY + ")");
        System.out.println("Visual Right Bottom Point = (" +visMaxX + "," + visMaxY + ")");
        System.out.println("Visual Width = " + visWidth + ", Visual Height = " + visHeight);




        primaryStage.show();
        Platform.exit();
    }
}
