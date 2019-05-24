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
    public Object instance=null;
    private static final int size=1024*1024;
    private byte[] bytes=new byte[size];
    public static void main(String[] args) {
        Main main1=new Main();
        Main main2=new Main();
        main1.instance=main2;
        main2.instance=main1;
        main1=null;
        main2=null;
        System.gc();
    }
}




