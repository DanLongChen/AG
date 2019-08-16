package L2019_8_2;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/2
 * 瞌睡
 **/
public class wy2019_7_2 {
    public static void main(String[] args) {
        //使用长度为k的滑动窗口做dp
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int k=input.nextInt();
        int[] a=new int[n];
        int[] t = new int[n];
        for(int i=0;i<n;i++){
            a[i]=input.nextInt();
        }
        int now=0;
        for(int i=0;i<n;i++){
            int temp=input.nextInt();
            if(temp==1){
                now+=a[i];
            }
            t[i]=temp;
        }
        /**
         * 下面是使用滑动窗口进行最优化
         */
        int result=now;
        for(int i=0;i<n;){
            if(t[i]==0){
                now+=a[i];
            }
            if(++i>=k){
                result=Math.max(now,result);
                if(t[i-k]==0){
                    now-=a[i-k];
                }

            }

        }
        System.out.println(result);
    }
}