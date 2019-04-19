package L2019_4_18;

import java.sql.SQLOutput;

/**
 * Created by DanLongChen on 2019/4/19
 **/
public class Test {
    private int a=1;
    public void play(){
        final int b=2;
        int c=3;
//        c=4;//其实是一个语法糖，JVM底层会把这个c加上final，改变的话会报错
        class inner{
            public void haha(){
                System.out.println(a+c);
            }
        }
        new inner().haha();
    }

    public static void main(String[] args) {
        new Test().play();
    }
}
