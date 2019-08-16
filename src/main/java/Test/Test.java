package Test;


import java.lang.reflect.Proxy;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by DanLongChen on 2019/5/31
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(handler(12354));
    }
    public static int handler(int num ){
        int result = 0;
        int i = num;
        while (i !=0 )
        {
            i = i/10*10;
            result = result * 10 + num - i;
            i = i /10;
            num = num/10;
        }
        return result;
    }

    static double jishuPI(double z) {
        double sum = 2;
        int n = 1;
        int m = 3;
        double t = 2;
        while (t > z) {
            t = t * n / m;
            sum = sum + t;
            n++;
            m += 2;


        }
        return sum;
    }

    public static void play() {
        Lock lock = new ReentrantLock(false);
        lock.lock();
    }


}

class User {
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