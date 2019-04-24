package L2019_4_24;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by DanLongChen on 2019/4/24
 **/
public class Fanshe {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class myfs=Class.forName("L2019_4_24.myFanShe");
        System.out.println(myfs.getName());
        Constructor constructor=myfs.getConstructor(String.class,int.class);
        myFanShe fanShe=(myFanShe) constructor.newInstance("XiaoMing",10);
//        myFanShe o=(myFanShe) myfs.newInstance();
        Field[] fields=myfs.getFields();
        Field name=myfs.getDeclaredField("name");
        name.setAccessible(true);
//        name.set(fanShe, "MYName");
        System.out.println(name.get(fanShe));
        Method method=myfs.getDeclaredMethod("play",int.class);
        method.setAccessible(true);
        method.invoke(fanShe, 100);

    }
}
class myFanShe{
    private String name;
    public int age;

    public myFanShe(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void show(String name){
        System.out.println(name);
    }
    private void play(int age){
        System.out.println(age);
    }
}
