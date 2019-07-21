package L2019_7_21;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Paser on 2019/7/21.
 * 零钱兑换
 */
public class L322 {
    public int coinChange(int[] coins, int amount) {
        //贪心法：先对coins进行排序，然后每次都从大的先选（但是不能得出正确结论）
        Arrays.sort(coins);
        int result=0;
        for(int i=coins.length-1;i>=0;i--){
            if(amount-coins[i]>=0){
                amount-=coins[i];
                result++;
                System.out.println(coins[i]);
                i++;
            }
        }
        if(amount==0){
            return result;
        }else{
            return -1;
        }
    }
    public int coinChange1(int[] coins, int amount) {
        //贪心法由于太贪心的原因会造成解无法解出
        //那么可以使用DP，
        if (coins==null || coins.length==0){
            return -1;
        }
        int[] dp=new int[amount+1];//用于记录到达i的金额需要多少个coin
        for (int i=1;i<=amount;i++){
            int cost=Integer.MAX_VALUE;
            for (int j=0;j<coins.length;j++){
                if(i-coins[j]>=0 && dp[i-coins[j]]!=Integer.MAX_VALUE){
                    cost=Math.min(cost,dp[i-coins[j]]+1);
                }
            }
            dp[i]=cost;
        }
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }else{
            return dp[amount];
        }

    }

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        System.out.println(new L322().coinChange1(coins,amount));
    }
}
