package L2019_7_16;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DanLongChen on 2019/7/16
 **/
public class wanquanpingfangshu {
    public int numSquares(int n) {
        //使用DP，用从第一个数找，后面的数可以用前面的数进行优化，dp[i]表示值为i的数包含的最少的平方数
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=1;i<=n;i++){
            dp[i]=i;//首先用i个1表示其最小平方数
            for(int j=1;i-j*j>=0;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new wanquanpingfangshu().numSquares(12));
    }
}
