package L2019_5_21;

/**
 * Created by DanLongChen on 2019/5/21
 **/

import java.util.Arrays;

/**
 * 编写一个方法，将所有的0都移动到数组的末尾，并且保持其他元素的相对位置
 */
public class L283 {
    public static void main(String[] args) {
        int[] nums={0,1,0,0,12};
        new L283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void moveZeroes(int[] nums) {
        int length=nums.length;
        for (int i=0;i<length;){
            if (nums[i]==0){
                for (int j=i;j<nums.length-1;j++){
                    nums[j]=nums[j+1];
                }
                nums[nums.length-1]=0;
                length--;
            }else{
                i++;
            }
        }
    }
}
