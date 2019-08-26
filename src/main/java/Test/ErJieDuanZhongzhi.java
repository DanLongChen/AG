package Test;


import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by DanLongChen on 2019/8/20
 **/
public class ErJieDuanZhongzhi {
    public static void main(String[] args) throws InterruptedException {
//        Runtime.getRuntime().addShutdownHook(new Thread(){
//            @Override
//            public void run() {
//                System.out.println("shutdown");
//            }
//        });
//        AAA test=new AAA();
//        Thread reader=new Thread(new Reader(test));
//        Thread writer=new Thread(new Writer(test));
//        reader.start();
//        writer.start();
//        reader.join();
//        writer.join();
        System.out.println(Runtime.getRuntime().availableProcessors());
        Lock lock=new ReentrantLock();
        lock.lockInterruptibly();
        lock.tryLock();
    }

}
class Reader implements Runnable{
    private AAA aaa;
    public Reader(AAA aa){
        this.aaa=aa;
    }

    @Override
    public void run() {
        while(true){
            aaa.get();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Writer implements Runnable{
    private AAA aaa;
    public Writer(AAA aaa){
        this.aaa=aaa;
    }

    @Override
    public void run() {
        int index=0;
        while(true){
            aaa.add(index++);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class AAA{
    Lock lock=new ReentrantLock(true);
    Condition notFull=lock.newCondition();
    Condition notEmpty=lock.newCondition();
    int[] arr=new int[10];
    int size=0,readIndex=0,writeIndex=0;
    public void add(int num){
        lock.lock();
       try{
           while(size==arr.length){
               notFull.await();
           }
           arr[writeIndex]=num;
           if(++writeIndex==10){
               writeIndex=0;
           }
           System.out.println("add "+num);
           ++size;
           notEmpty.signal();
       }catch (InterruptedException e){

       }finally {
           lock.unlock();
       }
    }
    public void get(){
        lock.lock();
        try{
            while(size==0){
                notEmpty.await();
            }
            System.out.println(arr[readIndex]);
            if(++readIndex==arr.length){
                readIndex=0;
            }
            --size;
            notFull.signal();
        }catch (InterruptedException e){

        }finally{
            lock.unlock();
        }
    }
}
