package L2019_5_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DanLongChen on 2019/5/22
 **/

/**
 * 从长度为n的数组中，找出没有在1~n范围内的数，其中数组中的元素可能出现重复，要求不使用额外空间，时间复杂度为O(n)
 */
public class L448 {
    public static void main(String[] args) {
        int[] nums={1,1};
        System.out.println(new L448().findDisappearedNumbers1(nums));
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        int[] hash = new int[length];

        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < length;i++){
            hash[nums[i] - 1]++;
        }
        for(int i = 0; i < length;i++){
            if(hash[i] == 0){
                result.add(i + 1);
            }
        }
        return result;
    }
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        /**
         * 使用正负标记法（首先标记哪些位置上的数已经有了）
         */
        for (int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            if(nums[index]>0){//如果没有标记过则进行标记，已经标记过的不需要再次标记
                nums[index]=-nums[index];
            }
        }
        List<Integer> result=new ArrayList<>();
        for (int i=0;i<nums.length;i++)
        {
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}
