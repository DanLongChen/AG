package L2019_4_3;


/**整数除法，不适用*,/，mod
 * Created by DanLongChen on 2019/4/3
 **/
public class L29 {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        if(divisor==1){
            return dividend;
        }
        if(divisor==-1){
            return -dividend;
        }
        boolean flag=false;
        if(dividend>0 && divisor>0 || dividend<0 && divisor<0){
            flag=true;
        }else{
            flag=false;
        }
        int result=0;
        int a=Math.abs(dividend);
        int b=Math.abs(divisor);
        while(a>b){
            a-=b;
            result++;
        }
        if(flag){
            return result;
        }else{
            return -result;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new L29().divide(-2147483648,-1));
    }
}
