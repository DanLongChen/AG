package L2019_8_2;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/2
 * 表达式求值
 **/
public class wy2019_7_5 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        int c=input.nextInt();
        int sum1=a+b*c;
        int sum2=a*(b+c);
        int sum3=a*b*c;
        int sum4=(a+b)*c;
        int result=Math.max(Math.max(sum1,sum2),Math.max(sum3,sum4));
        System.out.println(result);
    }
}
