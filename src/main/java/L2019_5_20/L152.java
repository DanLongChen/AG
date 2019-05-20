package L2019_5_20;

/**
 * Created by DanLongChen on 2019/5/20
 **/

import java.util.Arrays;

/**
 * 给定一个数组，求这个数组的子数组，使其乘积最大
 */
public class L152 {
    public static void main(String[] args) {
        int[] nums={-2,3,-4};
        System.out.println(new L152().DP(nums));
    }
    public int maxProduct(int[] nums) {
        /**
         * 暴力
         */
        int[] result=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            int max=nums[i];//用于记录以i为开头的sunArray中的最大值(首先以第一个当做初始最大值)
            int temp=nums[i];//用于记录连乘结果
            for (int j=i+1;j<nums.length;j++){
                max=Math.max(max,temp*nums[j]);
                temp=temp*nums[j];
            }
            result[i]=max;
        }
        Arrays.sort(result);
        return result[result.length-1];
        /**
         * 使用DP,DP[i]表示在nums的第i个位置，最大的乘积
         */


    }
    public int DP(int[] nums){
        int[] dpMax=new int[nums.length];//这里也可以不用数组，直接用一个数记录dp[i-1]
        int[] dpMin=new int[nums.length];//解决负负得正的情况，可能当时是最小值，再乘上一个负数之后就变为最大值
        dpMax[0]=nums[0];
        dpMin[0]=nums[0];
        int max=dpMax[0];
        for (int i=1;i<nums.length;i++){//从1开始计数，dp[i]=Math.max(nums[i],dp[i-1]*nums[i])
            dpMin[i]=Math.min(Math.min(nums[i],dpMax[i-1]*nums[i]),dpMin[i-1]*nums[i]);
            dpMax[i]=Math.max(Math.max(nums[i],dpMax[i-1]*nums[i]),dpMin[i-1]*nums[i]);
            max=Math.max(dpMax[i],max);
        }
        return max;
    }
}
