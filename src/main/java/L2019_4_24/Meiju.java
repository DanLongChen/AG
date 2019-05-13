package L2019_4_24;

import java.util.FormatFlagsConversionMismatchException;
import java.util.Objects;

/**
 * Created by DanLongChen on 2019/5/5
 **/
public class Meiju {
    public static void main(String[] args) {
        myEnum a=myEnum.A;
        a.doIt();
        for (myEnum myEnum:myEnum.values()){
            myEnum.play();
        }
        System.out.println(a.ordinal());
        Class<?> z=a.getClass();
        z.getEnumConstants();
    }
}
enum myEnum implements sb{
    A(1){
        @Override
        void doIt() {
            System.out.println("doIt A");
        }
    },B(2){
        @Override
        void doIt() {
            System.out.println("doIt B");
        }
    },C(3){
        @Override
        void doIt() {
            System.out.println("doIt C");
        }
    };
    private final int anInt;
    private myEnum(int a){
        this.anInt= Objects.requireNonNull(a);//用于检查传入的参数为非空
    }

    @Override
    public void play() {
        System.out.println("My int is "+anInt);
    }
    abstract void doIt();
}
interface sb{
    void play();
}
