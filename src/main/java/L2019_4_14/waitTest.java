package L2019_4_14;

/**
 * Created by DanLongChen on 2019/4/15
 **/
public abstract class waitTest {
    public static void main(String[] args) throws InterruptedException {
//        Object lock=new Object();
//        lock.wait();
        String str6 = "b";
        String str7 = "a" + str6;
        String str67 = "ab";
        System.out.println("str7 = str67 : "+ (str7 == str67));
        //↑str6为变量，在运行期才会被解析。
        final String str8 = "b";
        String str9 = "a" + str8;
        String str89 = "ab";
        System.out.println("str9 = str89 : "+ (str9 == str89));
    }
}
