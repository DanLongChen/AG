package pufa;

/**
 * Created by DanLongChen on 2019/8/17
 **/
public class zifuchuanweizhi {
    public static void main(String[] args) {
        String a="123";
        String b="1112345";
        if(b.contains(a)){
            if(a.length()==b.length()){
                System.out.println(0);
            }else{
                System.out.println(b.indexOf(a));
            }
        }else{
            System.out.println(-1);
        }
    }
}
