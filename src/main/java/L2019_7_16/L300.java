package L2019_7_16;

/**
 * Created by DanLongChen on 2019/7/16
 * 最长上升子序列
 *
 **/
public class L300 {
    public int lengthOfLIS(int[] nums) {
        /**
         * 使用DP，先从第一个元素开始找，判断当前元素I的时候，从前面开始搜索，若当前元素>前面的某个元素，那么temp值就=dp【i】+1，dp[j]=Math.max(dp[i+1],temp)
         */
        if(nums==null || nums.length==0){
            return 0;
        }
        int[] dp=new int[nums.length];
        dp[0]=1;
        int result=1;
        for(int i=1;i<nums.length;i++){
            int maxLength=0;
            for(int j=0;j<=i;j++){
                if(nums[i]>nums[j]){
                    maxLength=Math.max(maxLength,dp[j]);
                }
            }
            dp[i]=maxLength+1;
            result=Math.max(result,dp[i]);
        }
        return result;
    }
}
