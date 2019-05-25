package L2019_5_25;

/**
 * Created by DanLongChen on 2019/5/25
 **/

import java.util.Arrays;

/**
 * 给定一个数组，其中只有一个数只出现1次，找到那个数并且输出
 */
public class L136 {
    public int singleNumber(int[] nums) {
        int result=0;
        for (int i=0;i<nums.length;i++){
            result^=nums[i];
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums={4,1,2,1,2};
        new L136().singleNumber(nums);
    }
}
