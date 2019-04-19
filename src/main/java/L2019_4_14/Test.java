package L2019_4_14;

/**
 * Created by DanLongChen on 2019/4/17
 **/
interface Test {
      default void a(){
         System.out.println("hello");
     }
     static void b(){
         System.out.println("static");
     }
}
