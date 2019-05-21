package Test;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;
import sun.security.util.AuthResources_it;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Paser on 2019/2/27.
 */
public class Main {

    public static void main(String[] args) {
        Granpa p1=new Father();
        Granpa p2=new Son();
        p1.play();
        p2.play();
    }
    public void test(Granpa p){
        System.out.println("Granpa");
    }
    public void test(Father p){
        System.out.println("Granpa");
    }
    public void test(Son p){
        System.out.println("Granpa");
    }
}
class Granpa{
    public void play(){
        System.out.println("Granpa");
    }
}
class Father extends Granpa{
    @Override
    public void play() {
        System.out.println("Father");
    }
}
class Son extends Father{
    @Override
    public void play() {
        System.out.println("Son");
    }
}


