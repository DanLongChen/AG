package N2019_6_19;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/6/19
 * 偶串
 **/
public class ouchuan {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String s=input.nextLine();
        System.out.println(handler(s));

    }
    public static int handler(String s){
        for (int i=s.length()-1;i>0;i--){
            if (isString(s.substring(0,i)))
                return i;
        }
        return 1;
    }
    public static boolean isString(String s){
        String a=s.substring(0,s.length()/2);
        String b=s.substring(s.length()/2,s.length());
        return a.equals(b);
    }
}
