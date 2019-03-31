package L2019_3_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**三个数之和为0
 * Created by Paser on 2019/3/30.
 */
public class L15 {
    public List<List<Integer>> threeSum(int[] nums) {
        /**
         * 总体思想就是将三个数先拆解，先选定一个数，0-这个数形成target，然后再找剩下的两个数形成target，首先需要对这个数组进行排序，方便操作
         */
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int first=nums[i];
            if(first>0){//第一个数已经大于0，后面的数因为是经过排序的，所以不会凑成一个为0的三个数
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){//遇到了相同的数字（前面的数可能是一样的，如-1，-1）
                continue;
            }
            int target=0-first;
            int left=i+1,right=nums.length-1;
            while(left<right){
                if(nums[left]+nums[right]==target){
                    List<Integer> list=new ArrayList<>(Arrays.asList(first,nums[left],nums[right]));
                    result.add(list);
                    /**
                     * 检测重复项,最后会到达重复数的最后一个，这个时候需要跳过这个数
                     */
                    while (left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while (left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else{
                    if(nums[left]+nums[right]>target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }

        }
        return result;
    }
}
