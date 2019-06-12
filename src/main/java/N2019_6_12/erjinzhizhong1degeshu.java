package N2019_6_12;

import sun.font.TrueTypeFont;

/**
 * Created by DanLongChen on 2019/6/12
 * 二进制中1的个数
 **/
public class erjinzhizhong1degeshu {
    public int NumberOf1(int n) {
        int result=0;
        int flag=1;
        while(flag!=0){//这里会出现越界，然后会变为0
            if ((n&flag)!=0){
                result++;
            }
            flag<<=1;
        }
        return result;
    }
    public int NumberOf12(int n) {
        int result=0;
        while (n!=0){
            result++;
            n=(n-1) & n;//利用减法来消除对应位上的1
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new erjinzhizhong1degeshu().NumberOf12(3));
//        double a=0.1110101,b=0.919191;
//        if(Math.abs(a-b)<1e-15){
//            System.out.println(true);
//        }
        System.out.println(4%3==(4&2));
    }
}
