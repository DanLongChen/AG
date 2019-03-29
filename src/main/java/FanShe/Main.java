package FanShe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Paser on 2019/2/27.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class aclass=Class.forName("FanShe.Test");
        Constructor c=aclass.getDeclaredConstructor(String.class);
        c.setAccessible(true);
        Test test=(Test)c.newInstance("newInstance");
        Field field=aclass.getDeclaredField("name");
        field.setAccessible(true);
        field.set(test,"Lala");
        System.out.println(field.get(test));
        Method method=aclass.getMethod("show",null);
        method.setAccessible(true);
        method.invoke(test,null);
    }
}
