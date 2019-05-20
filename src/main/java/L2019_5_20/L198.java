package L2019_5_20;

/**
 * Created by DanLongChen on 2019/5/20
 **/

import java.awt.font.NumericShaper;

/**
 * 抢劫房子，相邻的房子有报警系统如果抢劫相邻的房子就会触发警报，求最大可抢劫的钱的数量而不触发警报
 */
public class L198 {
    public static void main(String[] args) {
        int[] nums={2,1,1,2};
        System.out.println(new L198().rob(nums));
    }
    public int rob(int[] nums) {
        int rob=0;//表示在当前的房子抢（也可以用于记录上一个房子的情况）
        int norob=0;//表示在当前房子不抢
        for(int i=0;i<nums.length;i++){
            int currob=norob+nums[i];//当前房子抢的话，上一个房子肯定要不抢
            norob=Math.max(rob,norob);//当前房子不抢，则上一个房子可以抢，也可以不抢
            rob=currob;
        }
        return Math.max(rob,norob);
    }
}
