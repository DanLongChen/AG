package BingFa;

import javax.print.DocFlavor;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Paser on 2019/2/25.
 */
public class TestThread {
    static ConcurrentHashMap<String,Future<String>> map=new ConcurrentHashMap<>();
    public static void main(String[] args) {
        ExecutorService pool=Executors.newFixedThreadPool(10);
        ((ThreadPoolExecutor)pool).setCorePoolSize(16);
        for(int i=0;i<5;i++){
            map.put(String.valueOf(i),pool.submit(new canCall()));
        }
        System.out.println(pool.submit(Executors.callable(new canNotCall())));
        for(int i=0;i<6;i++){
            System.out.println(getResult(String.valueOf(i)));
        }
        pool.shutdown();
        try {
            pool.awaitTermination(10,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static String getResult(String taskName){
        while (true){
            Future<String> task=map.get(taskName);
            if (task==null){
                Callable<String> call=new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return "new Call";
                    }
                };
                FutureTask<String> temp=new FutureTask<String>(call);
                task=map.putIfAbsent(taskName,temp);
                if(task==null){
                    temp.run();
                    task=temp;
                }

            }
            try {
                return task.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                task.cancel(true);
            }
        }

    }

}
class canCall implements Callable{
    @Override
    public Object call() throws Exception {
        return "call";
    }
}
class canNotCall implements Runnable{
    @Override
    public void run() {
        System.out.println("can not call");
    }
}
