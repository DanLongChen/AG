package T2019_6_15;

import java.util.concurrent.*;

/**
 * Created by DanLongChen on 2019/6/15
 **/
public class ExecutorTest {
    private static ConcurrentHashMap<String, Future<String>> map=new ConcurrentHashMap<>();
    public static void main(String[] args) {
        ExecutorService pool= Executors.newFixedThreadPool(10);
        if (pool instanceof ThreadPoolExecutor){
            ((ThreadPoolExecutor)pool).setCorePoolSize(20);
        }
        for (int i=0;i<5;i++){
            map.put(String.valueOf(i),pool.submit(new canCall(String.valueOf(i))));
        }
        System.out.println(pool.submit(Executors.callable(new canRun("Lin"))));
        for (int i=0;i<6;i++){
            System.out.println(returnResult(String.valueOf(i)));
        }
        pool.shutdown();

    }
    public static String returnResult(String name){
        while (true){
            Future<String> future=map.get(name);
            if (future==null){
                Callable<String> task=new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return name;
                    }
                };
                FutureTask<String> futureTask=new FutureTask<>(task);
                future=map.putIfAbsent(name,futureTask);
                if(future==null){
                    future=futureTask;
                    futureTask.run();
                }
            }
            try {
                return future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally{
                future.cancel(true);
            }

        }
    }
}
class canCall implements Callable{
    private String name;
    public canCall(String name){
        this.name=name;
    }
    @Override
    public Object call() throws Exception {
        return String.valueOf(name);
    }
}
class canRun implements Runnable{
    private String name;
    public canRun(String name){
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }
}