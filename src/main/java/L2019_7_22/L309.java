package L2019_7_22;

/**
 * Created by DanLongChen on 2019/7/22
 * 买卖股票最佳时机
 **/
public class L309 {
    public int maxProfit(int[] prices) {
        //使用dp，0代表未持有，1代表持有
        if(prices==null || prices.length==0 || prices.length==1){
            return 0;
        }
        int length=prices.length;
        int[][] dp=new int[length][2];//后面的2表示当前天的状态（持有或者没有持有）
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[1][0]=Math.max(dp[0][0],dp[0][1]+prices[1]);
        dp[1][1]=Math.max(dp[0][1],dp[0][0]-prices[1]);
        int result=dp[1][0];
        for(int i=2;i<length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
            result=Math.max(result,dp[i][0]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices={1,2,3,0,2};
        System.out.println(new L309().maxProfit(prices));
    }
}
