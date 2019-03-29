package BingFa;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Paser on 2019/2/26.
 */
public class Main {
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock(true);
        Thread thread1=new Thread(new Lock(lock),"THREAD1");
        Thread thread2=new Thread(new Lock1(lock),"THREAD2");
        thread1.start();
        thread2.start();
    }
}
