package L2019_4_2;

import java.util.Arrays;

/**删除排序数组的重复元素（返回删除之后的长度，可用的额外空间为O(1)）
 * Created by DanLongChen on 2019/4/2
 **/
public class L26 {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int last=nums[0];
        /**
         * 针对排序的情况，相同的数字会在一块儿
         */
        int length=1;//表示下一个数字放入的位置
        for(int n:nums){
            if(last!=n){
                nums[length++]=n;
                last=n;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums={1,1,2,3,3,4,4};
        System.out.println(new L26().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
