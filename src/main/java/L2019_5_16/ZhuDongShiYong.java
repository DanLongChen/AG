package L2019_5_16;

/**
 * Created by DanLongChen on 2019/5/16
 **/

/**
 * 验证加载并不一定引起初始化
 */
public class ZhuDongShiYong {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader=ClassLoader.getSystemClassLoader();
        Class<?> classZ=classLoader.loadClass("L2019_5_16.Z");
        /**
         * 加载并不一定引起初始化，但是初始化之前一定会进行加载
         */
        System.out.println(classZ);
        classZ=Class.forName("L2019_5_16.Z");
        System.out.println(classZ);
    }
}
class Z{
    static{
        System.out.println("Zz");
    }
}
