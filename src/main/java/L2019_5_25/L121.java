package L2019_5_25;

/**
 * Created by DanLongChen on 2019/5/25
 **/

/**
 * 最好的时间买入和卖出股票（在买入之前不能卖出），使得利润最大，并且输出利润
 */
public class L121 {
    public static void main(String[] args) {
        int[] nums={7,1,5,3,6,4};
        System.out.println(new L121().DP(nums));
    }
    public int maxProfit(int[] prices) {
        /**
         * 也就是找两个index的最大差值，首先尝试暴力(运行时间有点长)
         */
        int max=0;
        for (int i=0;i<prices.length;i++){
            int buy=prices[i];
            for (int j=i+1;j<prices.length;j++){
                int sell=prices[j];
                if (sell-buy>max){
                    max=sell-buy;
                }
            }
        }
        return max;
    }
    public int DP(int[] prices){
        /**
         * 首先记录最小的买入价格，然后判断在当前点卖出是否是最优的
         */
        if (prices.length==0){
            return 0;
        }
        int buyPrice=prices[0];
        int result=0;
        for (int i=1;i<prices.length;i++){
            buyPrice=Math.min(buyPrice,prices[i]);//这样肯定保证这个最低价是卖之前的价格
            result=Math.max(result,prices[i]-buyPrice);
        }
        return result;
    }
}
