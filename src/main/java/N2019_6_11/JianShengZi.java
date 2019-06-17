package N2019_6_11;

import L2019_3_26.MaxSubArray;

/**
 * Created by DanLongChen on 2019/6/11
 * 剪绳子问题：给定一个长度一定的绳子，剪成若干段，求其乘积的最大值
 **/
public class JianShengZi {
    public int DP(int length){
        if(length==0 || length==1 || length==2 || length==3){
            return length;
        }
        int[] dp=new int[length+1];
        dp[0]=0;//这些都是不剪来得好
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        int max=0;
        for (int i=4;i<=length;i++){//i表示长度
            max=0;
            for (int j=1;j<=i;j++){
                if(dp[j]*dp[i-j]>max){
                    max=dp[i-j]*dp[j];
                }
            }
            dp[i]=max;
        }
        return dp[length];
    }

    public static void main(String[] args) {
        System.out.println(new JianShengZi().DP(8));
    }
}
