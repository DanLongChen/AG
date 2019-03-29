package BingFa;

import java.io.IOException;
import java.io.PipedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Paser on 2019/2/26.
 */
public class Schedule {
    private static Exchanger<String> exchanger=new Exchanger<>();
    private static ExecutorService executorService=Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        for(int i=0;i<10;i++){
            System.out.println(list.get(i));
        }
    }


}
class test implements Runnable{
    private PipedReader in;
    public test(PipedReader in){
        this.in=in;
    }
    @Override
    public void run() {
        int receive=0;
        try {
            while((receive=in.read())!=-1){
                System.out.println((char)receive);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



