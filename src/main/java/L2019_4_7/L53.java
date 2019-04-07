package L2019_4_7;

import java.util.Arrays;

/**求最大连续子序列
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 * Created by Paser on 2019/4/7.
 */
public class L53 {
    public int maxSubArray(int[] nums) {
        /**
         * 使用简单动态规划(这个好像用来做非连续的)
         */
        int[] X=new int[nums.length];//代表到第i个的时候的最大值
        X[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            X[i]=Math.max(nums[i],X[i-1]+nums[i]);//代表的是从i开始，或者是加到i的情况
        }
        System.out.println(Arrays.toString(X));
        int max=X[0];
        for (int i=1;i<X.length;i++){
            if(X[i]>max){
                max=X[i];
            }
        }
        return max;
    }
    public int maxSubArray2(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int max=nums[0];
        for (int i=0;i<nums.length;i++){
            int temp=nums[i];
            /**
             * 比较单个数的大小
             */
            if(temp>max)
                max=temp;
            for (int j=i+1;j<nums.length;j++){
                temp+=nums[j];
                if(temp>max){
                    max=temp;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new L53().maxSubArray(nums));
    }
}
