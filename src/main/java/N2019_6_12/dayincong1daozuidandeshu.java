package N2019_6_12;

import java.util.Arrays;

/**
 * Created by DanLongChen on 2019/6/12
 * 打印从1到最大n的数
 * 题目:输入数字n,按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999
 **/
public class dayincong1daozuidandeshu {
    public void printToMaxOfDigst(int n){
        //这个就是1~9在n个位上的全排列问题，使用递归
        if(n==0){
            return;
        }
        char[] num= new char[n];
        Arrays.fill(num,'0');
        handler(num,n,0);
    }
    public void handler(char[] num,int n,int index){
        if(index==n){
            return;
        }
        for(int i=0;i<=9;i++){
            num[index]=(char)('0'+i);
            if(index==n-1){
                System.out.println(String.valueOf(num));
            }
            handler(num,n,index+1);
        }
    }

    public static void main(String[] args) {
        new dayincong1daozuidandeshu().printToMaxOfDigst(3);
    }
}
