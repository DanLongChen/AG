package Test;

/**
 * Created by DanLongChen on 2019/5/17
 **/

/**
 * 当前类加载器
 * 每个类都会使用自己的类加载器（也就是加载自身的类加载器）去加载其他类（指的是所依赖的类），如果ClassX
 * 引用了ClassY，那么ClassX的类加载器就会去加载ClassY（前提是ClassY尚未被加载）。
 *
 * 线程上下文类加载器（JDK1.2引入），类的getContextClassLoader和setContextClassLoader。
 * 分别来获取或者设置线程的类加载器。
 * 如果线程没有通过setContextClassLoader进行设置的话，线程将继承其父线程的上下文类加载器。
 * Java应用程序运行时的初始线程所使用的类加载器是系统类加载器。在线程运行的代码里通过该类加载器加载
 * 类和资源。
 *
 * SPI（Service Provider Interface）服务提供者接口
 * 父ClassLoader可以使用当前线程Thread.currentThread().getContextClassLoader()所指定的classLoader
 * 加载的类。这就改变了父ClassLoader不能使用子ClassLoader加载的类的情况，也就是改变了双亲委派模型。
 *
 * 在双亲委派模型下，类的加载是由下而上的，即下层的类加载器会委派上层类加载器进行加载。但是对于SPI来说，
 * 有些接口是JAVA核心库提供的，而JAVA核心库的加载是由启动类加载器进行加载的，而这些接口的实现却来自于不同的jar包（
 * 厂商提供），JAVA的启动类加载器是不会加载其他来源的Jar包，这样传统的双亲委派模型就无法满足需求。而通过
 * 给当前线程设置上下文类加载器，就可以由设置的上下文类加载器实现对接口实现类的加载。
 */
public class LeiJiaZaiQi {
    public static void main(String[] args) {
//        System.out.println(System.getProperty("sun.boot.class.path"));
//        System.out.println(System.getProperty("java.ext.dirs"));
//        System.out.println(System.getProperty("java.class.path"));
        System.out.println(Thread.currentThread().getContextClassLoader());
        /**
         * Thread类属于核心类，其使用启动类加载器进行加载
         */
        System.out.println(Thread.class.getClassLoader());
    }
}
