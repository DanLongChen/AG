package Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by DanLongChen on 2019/7/18
 **/
public class ThreadTest {
    private ReentrantLock lock = new ReentrantLock(false);
    private static volatile Thread temp;
    public void testFail() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获得了锁");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadTest fairLock = new ThreadTest();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            fairLock.testFail();
        };

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1);
            temp=new Thread(runnable,String.valueOf(i));
            temp.start();
        }
    }

}
