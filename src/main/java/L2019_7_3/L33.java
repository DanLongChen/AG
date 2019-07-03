package L2019_7_3;

/**
 * Created by DanLongChen on 2019/7/3
 * 搜索旋转之后的排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L33 {
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        System.out.println(new L33().search(nums,4));
    }
    public int search(int[] nums, int target) {
        //判断第一个数是否>最后一个数，如果是的话说明其是旋转数组，否则说明数组是以第0个进行旋转的，效果和没有旋转是一样的
        //找到分界点，然后进行二分查找
        if(nums==null || nums.length==0){
            return -1;
        }
        if(nums[0]>nums[nums.length-1]){
            int index=0;
            while(index<nums.length-1 && nums[index]<nums[index+1]){
                index++;
            }
            int result1=handler(nums,0,index,target);
            int result2=handler(nums,index+1,nums.length-1,target);
            if(result1!=-1){
                return result1;
            }else{
                if(result2!=-1){
                    return result2;
                }
            }
        }else{
            return handler(nums,0,nums.length-1,target);
        }
        return -1;
    }
    private int handler(int[] nums,int start,int end,int target){
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
}
