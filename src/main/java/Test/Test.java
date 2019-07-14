package Test;



import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by DanLongChen on 2019/5/31
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        List<User> list = new ArrayList<>();
        List<User> list1=new LinkedList<>();
        long now1=System.currentTimeMillis();
        for(int i=0;i<50000000;i++){
            list.add(new User());
        }

        System.out.println("time1:"+(System.currentTimeMillis()-now1));
        long now2=System.currentTimeMillis();
        for(int i=0;i<50000000;i++){
            list1.add(new User());
        }
        System.out.println("time2:"+(System.currentTimeMillis()-now2));
        Hashtable hashtable=new Hashtable();
        for (int i=0;i<10;i++){
            hashtable.put(i,new User());
        }
    }
    public static void play(){
        Lock lock=new ReentrantLock(false);
        lock.lock();
    }


}
class User{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}