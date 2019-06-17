package T2019_6_15;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by DanLongChen on 2019/6/15
 **/
public class ScheduleThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService pool= Executors.newScheduledThreadPool(10);
        for (int i=0;i<20;i++){
            ((ScheduledExecutorService) pool).scheduleWithFixedDelay(new Timer(String.valueOf(i)),0,100,TimeUnit.MILLISECONDS);
        }
        while (!pool.isTerminated()){}
        System.out.println("shotdown");
    }
}
class Timer implements Runnable{
    private String name;
    public Timer(String name){
        this.name=name;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private String now(){
        return new Date(System.currentTimeMillis()).toString();
    }
}
