package dj2019_8_5;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/6
 **/
public class d1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int T=input.nextInt();
        while(input.hasNext()){
            int number=input.nextInt();
            int days=input.nextInt();
            int[] v=new int[number];//成就
            int[] c=new int[number];//所需天数
            for(int i=0;i<number;i++){
                v[i]=input.nextInt();
                c[i]=input.nextInt();
            }
            int n=c.length;
            int[][] dp=new int[n+1][days+1];
            for(int i=1;i<=n;i++){
                for(int j=1;j<=days;j++){
                    dp[i][j]=dp[i-1][j];
                    if(c[i-1]<=j){
                        if(dp[i-1][j-c[i-1]]+v[i-1]>dp[i-1][j]){
                            dp[i][j]=dp[i-1][j-c[i-1]]+v[i-1];
                        }
                    }
                }
            }
            System.out.println(dp[n][days]);
            /**
             * 01背包计算当前输入case的最大值
             */

            if(T==0){
                break;
            }
            T--;
        }
    }
//    public static int value(int[] c,int[] v,int days){
//        int n=c.length;
//        int[][] dp=new int[n+1][days+1];
//        for(int i=1;i<=n;i++){
//            for(int j=1;j<=days;j++){
//                dp[i][j]=dp[i-1][j];
//                if(c[i-1]<=j){
//                    if(dp[i-1][j-c[i-1]]+v[i-1]>dp[i-1][j]){
//                        dp[i][j]=dp[i-1][j-c[i-1]]+v[i-1];
//                    }
//                }
//            }
//        }
//        return dp[n][days];
//    }
}
