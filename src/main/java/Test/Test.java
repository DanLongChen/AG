package Test;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by DanLongChen on 2019/5/31
 **/
public class Test {
    public static List<Integer> list=new CopyOnWriteArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                list.add(1);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                list.add(2);
            }
        }).start();
//        System.out.println(Thread.currentThread());
        Thread.currentThread().yield();
        System.out.println(list);
    }
}
