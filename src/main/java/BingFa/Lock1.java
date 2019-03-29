package BingFa;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Paser on 2019/2/26.
 */
public class Lock1 extends Thread{
    private ReentrantLock lock;
    public Lock1(ReentrantLock lock){
        this.lock=lock;
    }
    @Override
    public void run() {
        try {
            lock.lock();
            if(lock.isHeldByCurrentThread()){
                System.out.println(Thread.currentThread().getName()+"get the Lock");
                lock.unlock();
            }else{
                lock.tryLock(10, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
