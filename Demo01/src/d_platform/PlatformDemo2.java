package d_platform;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * Demo class
 *
 * @author axin
 * @date 2023/9/10
 */
public class PlatformDemo2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //当用户单击右上角退出时，进程并不会关闭，只有调用Platform.exit才会关闭
        //默认为true,右上角退出时，直接退出
        //Platform.setImplicitExit(false);
        //Platform.exit();

        //是否支持3D
        //其他属性查看ConditionalFeature类
        boolean supported3D = Platform.isSupported(ConditionalFeature.SCENE3D);
        boolean supportedFXML = Platform.isSupported(ConditionalFeature.FXML);
        System.out.println("supported3D = " + supported3D);
        System.out.println("supportedFXML = " + supportedFXML);


        primaryStage.show();


    }
}
