package Test;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;
import sun.security.util.AuthResources_it;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * Created by Paser on 2019/2/27.
 */
public class Main {

    public static void main(String[] args) {
        ConcurrentHashMap<String,String> hashMap=new ConcurrentHashMap<>();
        hashMap.put("123",null);
        hashMap.get("123");
        myClass readl=new myClass();
        father proxy= (father) Proxy.newProxyInstance(readl.getClass().getClassLoader(),readl.getClass().getInterfaces(),new myInvokation(readl));
        proxy.play();
    }
}
class myInvokation implements InvocationHandler{
    private Object object;
    public myInvokation(Object object){
        this.object=object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("This is Proxy add");
        return method.invoke(object,args);
    }
}
interface father{//一定要声明接口
    void play();
}
class myClass implements father{
    public String name="MyName";
    @Override
    public void play(){
        System.out.println(name);
    }
}




