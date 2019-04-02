package L2019_4_1;

import java.util.Arrays;

/**删除重复的元素
 * Created by DanLongChen on 2019/4/1
 **/
public class L27 {
    public int removeElement(int[] nums, int val) {
        int length=nums.length;
        for (int i=0;i<nums.length;){
            if(nums[i]==val){//遇到对应的数字的时候，后面的数字会往前移动，这个时候可能到达对应i位置的数也是要找的数字，所以i不能移动
                length--;
                for (int j=i;j<nums.length;j++){
                    if(j<nums.length-1){
                        nums[j]=nums[j+1];
                    }
                    if(j==nums.length-1){
                        nums[j]=Integer.MAX_VALUE;
                    }
                }
            }else{
                i++;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        int[] nums={1,2,2,3,3,};
        System.out.println(new L27().removeElement(nums,2));
        System.out.println(Arrays.toString(nums));
    }
}
