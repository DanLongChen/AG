package Test;

/**
 * Created by DanLongChen on 2019/5/17
 **/

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * 线程上下文类加载器的使用
 * 一般上下文类加载器的使用步骤是：获取--使用--还原
 *
 * ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
 * try{
 *     Thread.currentThread().setContextClassLoader(targetCl);
 *     myMethod();
 * }finally{
 *     Thread.currentThread.setContextClassLoader(classLoader);
 * }
 * myMethod()里面再调用Thread.currentThread().getContextClassLoader()，获取当前线程的上下文类加载器，做一些事情
 * 如果一个类由类加载器A进行加载，那么这个类的依赖类也是由这个类加载器进行加载的
 */
public class ContextClassLoader {
    public static void main(String[] args) {
        ArrayList list=new ArrayList();
         list.add(0);
//        list.add("1");
        System.out.println( list.get(0).getClass());
    }
}
