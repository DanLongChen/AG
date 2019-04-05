package L2019_4_5;

/**实现除法，不使用*，/，mod运算
 * Created by Paser on 2019/4/5.
 */
public class L29 {
    public int divide(int dividend, int divisor) {
        if(divisor==1){
            return dividend;
        }
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        boolean flag=false;//false代表-，true代表+
        if(dividend>0 && divisor>0 || dividend<0&&divisor<0){
            flag=true;
        }
        int result=0;
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        if (a==Integer.MIN_VALUE){

        }
        while (a>=b){
            result++;
            a-=b;
        }
        if(flag){
            return result;
        }else{
            return -result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new L29().divide(-2147483648,2));
    }
}
