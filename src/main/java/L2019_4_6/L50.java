package L2019_4_6;

import java.util.Arrays;

/**
 * 模拟POW
 * Created by Paser on 2019/4/6.
 */
public class L50 {
    public double myPow(double x, int n) {
        double result = 1.0;
        if (n == 0 || x == 0) {
            return result;
        }
        /**
         * 要获取原先x的小数点位数
         */
//        String string = String.valueOf(x);
//        System.out.println(string);
        /**
         * n>0的情况
         */
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;

    }
    public double myPow2(double x, int n) {
        /**
         * 将n分解为二进制 11=2^3+2^1+2^0;
         * x^11=x^(2^3+2^1+2^0)=x^8*x^2*x^1=(x^4)^2*(x^2)*(x^1)
         */
        double result=1.0;
        if(n==0 || x==0){
            return result;
        }
        if(n<0){
            x=1/x;
            System.out.println(x);
            n=-n;
        }
        char[] binaries=Integer.toBinaryString(n).toCharArray();
        System.out.println(Arrays.toString(binaries));
        for (int i=binaries.length-1;i>=0;i--){
            if (binaries[i]=='1'){
                result*=x;
            }
            /**
             * 代表x^2
             */
            x*=x;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new L50().myPow2(2.00000, 2));
    }
}
