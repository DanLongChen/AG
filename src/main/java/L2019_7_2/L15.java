package L2019_7_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DanLongChen on 2019/7/2
 * 三数和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        //可以将这个问题进行拆解，先拿出第一个数，然后再求后面两个数加起来==-第一个数，也就是转化为2Sum的问题
        if(nums==null || nums.length==0){
            return result;
        }
        //首先进行排序，这样子更加好做
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int target=-nums[i];
            if(nums[i]>0){
                break;//因为第一个已经大于0，那么后面就没有搜索的必要了
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;//表示两个数一样，后面一个数没有搜索的必要，因为下面的循环会把所有两数和为target的都搜索出来，没有必要再搜索两次这个target
            }
            int start=i+1,end=nums.length-1;//定义用于寻找两个剩余元素的指针
            while(start<end){
                if(nums[start]+nums[end]==target){
                    result.add(new ArrayList(Arrays.asList(nums[i],nums[start],nums[end])));
                    while(start<end && nums[start]==nums[start+1]){
                        start++;
                    }
                    while(start<end && nums[end]==nums[end-1]){
                        end--;
                    }
                    start++;
                    end--;
                }else{
                    if(nums[start]+nums[end]>target){
                        end--;
                    }else{
                        start++;
                    }
                }


            }
        }
        return result;
    }
}
