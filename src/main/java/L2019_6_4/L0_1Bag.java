package L2019_6_4;

import java.util.Arrays;

/**
 * Created by DanLongChen on 2019/6/4
 **/
public class L0_1Bag {
    public static void main(String[] args) {
        /**
         * 求最大的hot值
         */
        int totalValue=1000;
        int[] price={0,200,600,100,180,300,450};
        int[] hot={0,6,10,3,4,5,8};
        int n=price.length;
        int[][] dp=new int[n+1][totalValue+1];
        for (int i=1;i<price.length;i++){
            for (int j=1;j<=totalValue;j++){
                if (j<price[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-price[i]]+hot[i]);
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[price.length-1][1000]);
    }
}
