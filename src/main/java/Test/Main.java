package Test;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;
import sun.security.util.AuthResources_it;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.*;

/**
 *
 * Created by Paser on 2019/2/27.
 */
public class Main {

    public static void main(String[] args) {
        WeakHashMap<Object,lala> weakHashMap=new WeakHashMap<>();
        weakHashMap.put("123",new lala("123"));
        System.out.println(weakHashMap.size());
        System.gc();
        System.gc();
        System.out.println(weakHashMap.size());


    }

}
class lala{
    String name;

    public lala(String name) {
        this.name = name;
    }
    public void play(){
        System.out.println(name+"  "+"play");
    }
}



