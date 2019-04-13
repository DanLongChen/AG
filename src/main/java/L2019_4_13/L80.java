package L2019_4_13;

import java.util.Arrays;

/**删除nums中的重复项，使得nums中的重复元素最多只有2个（使用的额外空间为O(1)）
 * Created by DanLongChen on 2019/4/13
 **/
public class L80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if(nums.length==1 || nums.length==2){
            return nums.length;
        }
        /**
         * 初步想法是给每一类元素配置一个计数器，当计数器超过2的时候就执行删除操作（先标记，再删除）
         */
        int num=0;
        int temp=nums[0];//用于记录nums中的数
        /**
         * 首先进行标记
         */
        for (int i=0;i<nums.length;i++){
            if (temp==nums[i]){
                num++;
            }else {
                temp=nums[i];
                num=1;
            }

            if (num>2){
                nums[i]=Integer.MAX_VALUE;
            }
        }
        System.out.println(Arrays.toString(nums));
        /**
         * 进行清除
         */
        int index=0;
        int length=nums.length;
        while (index<nums.length){
            if (nums[index]!=Integer.MAX_VALUE){
                index++;
            }else{
                if (index==nums.length-1){
                    index++;
                    length--;
                    continue;
                }
                for (int i=index;i<nums.length-1;i++){
                    nums[i]=nums[i+1];
                }
                length--;
            }
        }
        return length;

    }

    public static void main(String[] args) {
        int[] nums={1,1,1,1};
        int length=new L80().removeDuplicates(nums);
        System.out.println(length);
        System.out.println(Arrays.toString(nums));
    }
}
