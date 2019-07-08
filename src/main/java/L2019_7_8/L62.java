package L2019_7_8;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by DanLongChen on 2019/7/8
 * 不同路径
 *
 **/
public class L62 {
    public static void main(String[] args) {
        System.out.println(new L62().uniquePaths(3,2));
    }
    public int uniquePaths(int m, int n) {
        /**
         * 使用DP，DP[i][j]表示到i，j有多少种走法，DP[i][j]=DP[i-1][j]+DP[i][j-1] 也就是说可以从上边下来，也可以从左边过来
         */
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<m;j++){
            dp[0][j]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }

}
