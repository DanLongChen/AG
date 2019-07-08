package Test;


import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by DanLongChen on 2019/5/31
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier=new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("finished！");
            }
        });
        for(int i=0;i<5;i++){
            Thread thread=new Thread(new handler(i,cyclicBarrier));
            thread.start();
        }
        cyclicBarrier.reset();
        System.out.println("man finished");
    }

}
class handler implements Runnable{
    private int id;
    private CyclicBarrier cyclicBarrier;
    public handler(int id,CyclicBarrier cyclicBarrier){
        this.id=id;
        this.cyclicBarrier=cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(id+" start");
            cyclicBarrier.await();
            System.out.println(id+" start work");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
