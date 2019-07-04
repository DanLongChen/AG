package Test;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by DanLongChen on 2019/5/31
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        counter counter = new counter();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(counter);
            thread.start();
//            thread.join();//会使得main线程阻塞，当前线程（Thread-1）执行完毕之后main线程才能继续运行,
//            main线程阻塞会导致for循环不能继续进行也就是不能创建更多的线程，这个时候已经计数完毕了
        }
    }
}

class counter implements Runnable {
    volatile AtomicInteger count = new AtomicInteger(0);

     public synchronized void doCount() {
        if (count.get() < 1000) {
            int temp = count.incrementAndGet();
            System.out.println(Thread.currentThread().getName() + " count:" + temp);
        }
    }

    @Override
    public void run() {
        while (true) {
            doCount();
            if (count.get()>=1000){
                break;
            }
        }
    }
}
