package L2019_4_7;

import java.util.Arrays;

/**跳跃游戏，初始在0的位置，数组中的每一个数字代表能跳跃的长度，判断能否到数组最后
 * Input: [2,3,1,1,4]
 Output: true
 Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Created by Paser on 2019/4/7.
 */
public class L55 {
    public boolean canJump(int[] nums) {
        if (nums.length==1){
            return true;
        }
        /**
         * 使用DP计算从当前点最远能跳到的距离 D[i+1]=Math.max(D[i],(i+1+nums[i+1]));选择D[i]的时候表示前一个点的最远距离要大于从当前点起跳
         */
        /**
         * 用于表示第i个格子最远可以到达的目的(看最后一个能否到达)
         */
        int[] D=new int[nums.length];
        D[0]=nums[0];
        for (int i=1;i<nums.length;i++){
            /**
             * 表示i-1步应不能到达
             */
            if (D[i-1]<i){
                return false;
            }
            D[i]=Math.max(D[i-1],i+nums[i]);
        }
        /**
         * 表示可以到达倒数第二个
         */
        System.out.println(Arrays.toString(D));
        /**
         * 长度下标从0开始记，所以长度要-1（nums.length-1）
         */
        if(D[nums.length-1]>=nums.length-1){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {
        int[] nums={2,0,0};
        System.out.println(new L55().canJump(nums));
    }
}
