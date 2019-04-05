package L2019_4_5;

import java.util.Arrays;

/**在排序好的列表中寻找给定的target的起始和结束下标，Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]
 * Created by Paser on 2019/4/5.
 */
public class L34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result=new int[2];
        result[0]=-1;
        result[1]=-1;
        for (int i=0;i<nums.length;i++){
            if(nums[i]==target){
                result[0]=i;
                break;
            }
        }
        if(result[0]==-1){
            return result;
        }
        for (int i=result[0];i<nums.length;i++){
            if(nums[i]==target){
                result[1]=i;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int[] result=new L34().searchRange(nums,8);
        System.out.println(Arrays.toString(result));
    }
}
