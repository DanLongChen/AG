package Test;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by DanLongChen on 2019/5/31
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        counter counter =new counter();
        ReentrantLock lock = new ReentrantLock();
        for(int i=0;i<5;i++){
           Thread thread=new Thread(counter);
           thread.start();
       }
    }
    private static class counter implements Runnable{
        private AtomicInteger point=new AtomicInteger(0);

        synchronized private void doCount(){
            if(point.get()<=100){
                System.out.println(point.getAndIncrement());
            }
        }

        @Override
        public void run() {
            while (true){
                doCount();
                if(point.get()>100){
                    break;
                }
            }
        }
    }
}

