package L2019_5_16;

import com.sun.deploy.security.SecureStaticVersioning;

import java.io.*;

/**
 * Created by DanLongChen on 2019/5/16
 **/
public class MyClassLoader extends ClassLoader{
    private String classLoaderName;
    private final String LaterOn=".class";
    public MyClassLoader(String classLoaderName){
        super();//父类加载器的默认构造函数是将系统类加载器当做当前类加载器的父类加载器
        this.classLoaderName=classLoaderName;
    }
    public MyClassLoader(ClassLoader parent,String classLoaderName){
        super(parent);//显示指定该类加载器的父类加载器
        this.classLoaderName=classLoaderName;
    }

    /**
     * 用于获取对应的字节码(这里也是可以从网络中获取字节码的)
     * @param name
     * @return
     */
    public byte[] loadClassData(String name){
        InputStream inputStream = null;
        byte[] data=null;
        ByteArrayOutputStream outputStream = null;
        this.classLoaderName=this.classLoaderName.replace(".","/");
        try {
            //inputStream=new FileInputStream(new File(name+this.LaterOn));//这里将会从classPath路径下加载类（在classPath路径下，由于双亲委派模型的存在，会使用系统类加载器去加载类）
            inputStream=new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\"+name.replace(".","\\")+this.LaterOn));//这里将会从classPath路径下加载类（在classPath路径下，由于双亲委派模型的存在，会使用系统类加载器去加载类）
            outputStream=new ByteArrayOutputStream();
            int ch=0;
            while ((ch=inputStream.read())!=-1){
                outputStream.write(ch);
            }
            data=outputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    /**
     * 根据名字寻找类
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass被执行了");//因为加载的时候使用双亲委派模型，所以是由系统类加载器加载的
        byte[] data=loadClassData(name);
        /**
         * 将字节数组转化为Class类的实例
         */
        return this.defineClass(name,data,0,data.length);//从字节码定义类
    }

    public static void test(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        /**
         * loadClass内部又会去调用findClass方法
         */
        Class<?> classZ=classLoader.loadClass("L2019_5_16.ClassLoaderTest");
        Object object=classZ.newInstance();
        System.out.println(object.getClass().getClassLoader());
        object=null;
    }

    public static void main(String[] args) {
        ClassLoader classLoader=new MyClassLoader("MyClassLoader");
        try {
            test(classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        classLoader=null;

        System.gc();
    }
}
