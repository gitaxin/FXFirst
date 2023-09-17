package j_scheduled;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.text.Text;

/**
 * MyScheduledService class
 *
 * @author axin
 * @date 2023/9/17
 */
public class MyScheduledService extends ScheduledService<Integer> {

    private Text text;

    public MyScheduledService() {
    }

    public MyScheduledService(Text text) {
        this.text = text;
    }

    @Override
    protected Task<Integer> createTask() {
        return new Task<Integer>() {
            /**
             * 在此方法中更新组件，此方法是UI线程
             * @param value
             */
            @Override
            protected void updateValue(Integer value) {

                System.out.println("updateValue() Thread name = " + Thread.currentThread().getName() + ", value = "+ value);
                text.setText(value.toString());

            }

            @Override
            protected Integer call() throws Exception {
                System.out.println("call() Thread name = " + Thread.currentThread().getName());

                String t = text.getText();
                if(t == null || t.length() == 0){
                    t = "0";
                }
                int n = Integer.parseInt(t);
                return ++n;
            }
        };
    }
}
