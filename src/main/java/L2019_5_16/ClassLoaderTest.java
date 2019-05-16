package L2019_5_16;

/**
 * Created by DanLongChen on 2019/5/16
 **/

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 查看双亲委派模型
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws IOException {
        /**
         * 获取系统类加载器(也可以通过当前的类来获取当前类的类加载器)
         */
        ClassLoader classLoader=ClassLoader.getSystemClassLoader();//获取系统类加载器
        ClassLoader classLoaderX=ClassLoaderTest.class.getClassLoader();//获取当前类的类加载器
        /**
         * 这说明String类是由启动类加载器进行加载的
         */
        System.out.println("String的类加载器为:"+String.class.getClassLoader());
        /**
         * 获取线程的上下文加载器（这个加载器由创建线程的那个类提供，也就是由线程创建者提供）
         */
        ClassLoader classLoader1=Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader1);
        String resourceName="L2019_5_16\\ClassLoaderTest.class";
        Enumeration<URL> enumeration=classLoader1.getResources(resourceName);
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
        while (null != classLoader){
            /**
             * 当当前类的父类加载器是BootStrap类加载器的时候，就返回null
             */
            classLoader=classLoader.getParent();
            System.out.println(classLoader);
        }

    }
}
