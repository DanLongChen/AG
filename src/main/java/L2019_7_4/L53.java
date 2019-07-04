package L2019_7_4;

/**
 * Created by DanLongChen on 2019/7/4
 * 最大子序列和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L53 {
    public int maxSubArray(int[] nums) {
        /**
         * 直接使用动态规划；DP[i]表示0~i中间的一个子序列的最大值
         * 方程：DP[i]=DP[i-1]+nums[i]  if(DP[i-1]>0)  如果前一个>0，则加上前一个DP（当前加上前一个是有增益的）
         *      DP[i]=nums[i]                          否则从当前i开始计算子序列
         */
        if(nums==null || nums.length==0){
            return 0;
        }
        int[] dp=new int[nums.length];
        int max=nums[0];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]>0){
                dp[i]=dp[i-1]+nums[i];
            }else{
                dp[i]=nums[i];
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
