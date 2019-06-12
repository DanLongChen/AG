package N2019_6_12;

/**
 * Created by DanLongChen on 2019/6/12
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 **/
public class shuzhidezhengshucifang {
    public double Power(double base, int exponent) {
        if(base==0){
            return 0;
        }
        double result=1;
        if(exponent==0){
            return 1;
        }
        if(exponent>0){
            base=base;
        }else{
            base=1/base;
        }
        if((Math.abs(exponent)&1)==1){
            for(int i=1;i<=(Math.abs(exponent)-1)>>1;i++){
                result*=base;
            }
            return result*result*base;
        }else{
            for(int i=1;i<=Math.abs(exponent)>>1;i++){
                result*=base;
            }
            return result*result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new shuzhidezhengshucifang().Power(2,3));
    }
}
