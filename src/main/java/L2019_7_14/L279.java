package L2019_7_14;

/**
 * Created by DanLongChen on 2019/7/14
 *
 * 完全平方数
 **/
public class L279 {
    public int numSquares(int n) {
        if(n==0){
            return 0;
        }
        int[] dp=new int[n+1];//代表组成第i个数需要的最少平方数
        dp[0]=0;
        dp[1]=1;
        for(int i=1;i<=n;i++){
            dp[i]=i;//首先假设当前的值由i个1组成
            for(int j=1;i-j*j>=0;j++){//然后看看是否可以由其他的平方来优化
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);//如果有，那么从之前这个最优值到当前这个值只需要再一步
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new L279().numSquares(12));
    }
}
