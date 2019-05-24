package L2019_5_23;

/**
 * Created by DanLongChen on 2019/5/23
 **/

/**
 * 您将获得一个非负整数列表，a1，a2，...，an和目标，S。现在您有2个符号+和 - 。对于每个整数，您应该从+和 - 中选择一个作为其新符号。 找出分配符号的多少种方法，使整数之和等于目标S.
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 */
public class L494 {
    public static void main(String[] args) {
        int[] nums={1,1,1,1,1};
        int S=3;
        System.out.println(new L494().findTargetSumWays(nums,S));
    }
    public int findTargetSumWays(int[] nums, int S) {
        /**
         * 递归，当然可以用DP
         */
        return handler(nums,0,S);
    }
    public int handler(int [] nums,int index,int S){
        if (index==nums.length){
            if (S==0){
                return 1;
            }else{
                return 0;
            }
        }
        return handler(nums,index+1,S-nums[index])+handler(nums,index+1,S+nums[index]);

    }
    public int DP(int[] nums, int S) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum < S || (sum + S) % 2 != 0){
            return 0;
        }
        sum = (sum + S) / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int num : nums){
            for (int i = sum; i >= num; i--){
                dp[i] += dp[i - num];
            }
        }
        return dp[sum];
    }
}
