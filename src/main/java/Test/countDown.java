package Test;

import java.util.Hashtable;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by DanLongChen on 2019/8/21
 **/
public class countDown {
    private static ExecutorService pool= Executors.newFixedThreadPool(2);
    private static Exchanger exchanger=new Exchanger();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String a="I am A";
                try {
                    String temp=(String) exchanger.exchange(a);
                    System.out.println("A receive:"+temp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String a="I am B";
                try {
                    String temp=(String) exchanger.exchange(a);
                    System.out.println("B receive:"+temp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
