package b;

import javafx.application.Application;

/**
 * Demo class
 *
 * @author axin
 * @date 2023/9/9
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main() = " + Thread.currentThread().getName());
        Application.launch(LifeCircle.class,args);
    }
}
