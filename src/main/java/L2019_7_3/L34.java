package L2019_7_3;

import java.util.Arrays;

/**
 * Created by DanLongChen on 2019/7/3
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L34 {
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        System.out.println(Arrays.toString(new L34().searchRange(nums,8)));
    }
    public int[] searchRange(int[] nums, int target) {
        //二分范围查找,先用二分查找，找到后返回index然后往index两端扩散进行查找
        int result=binarySearch(nums,0,nums.length-1,target);
        if(result==-1){
            return new int[]{-1,-1};
        }else{//向两边散开进行查找
            int left=result,right=result;
            boolean flag1=false,flag2=false;
            while(left>=0 || right<nums.length){
                if(left-1>=0 && nums[left-1]==target){
                    left--;
                }else{
                    flag1=true;
                }
                if(right+1<nums.length && nums[right+1]==target){
                    right++;
                }else{
                    flag2=true;
                }
                if(flag1 && flag2){
                    break;
                }
            }
            return new int[]{left,right};
        }
    }
    private int binarySearch(int[] nums,int start,int end,int target){
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
