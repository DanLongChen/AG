package L2019_5_23;

/**
 * Created by DanLongChen on 2019/5/23
 **/

import sun.font.TrueTypeFont;

/**
 * 给定仅包含正整数的非空数组，查找是否可以将数组划分为两个子集，使得两个子集中的元素总和相等。
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 */
public class L416 {
    public static void main(String[] args) {
        int[] nums={1,5,11,5};
        System.out.println(new L416().canPartition(nums));
    }
    public boolean canPartition(int[] nums) {
        /**
         * 要是能划分成两个子集，那么nums的和肯定是偶数，那么问题就转化为nums中能否找到集合使得和为Sum(nums)/2
         */
        int sum=0;
        for (int i:nums){
            sum+=i;
        }
        if ((sum & 1) !=0){
            return false;//说明其和为奇数
        }
        int target=sum/2;
        boolean[] DP=new boolean[target+1];//DP[i]原数组中能否有子集组成i,最后只需要返回DP[target]来表示能否组成target
        DP[0]= true;
        /**
         * 对于nums[i],其可以组成(nums[i]~target)中的某一个值，假设这个值为j，那么j-nums[i]如果为true,那么这个j值肯定可以被组成，同时还要查看DP[j](这个j值本身是否被组成过了)
         */
        for (int i:nums){
            for (int j=target;j>=i;j--){
                DP[j]=DP[j] || DP[j-i];
            }
        }
        return DP[target];
    }
}
