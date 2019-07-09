package L2019_7_9;

import java.util.Arrays;

/**
 * Created by DanLongChen on 2019/7/9
 * 颜色分类
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L75 {
    public static void main(String[] args) {
        int[] nums={5,2,4,3,1};
        new L75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }
    private void quickSort(int[] nums,int start,int end){
        if(start>=end){
            return;
        }
        int mid=handler1(nums,start,end);
        quickSort(nums,start,mid-1);
        quickSort(nums,mid+1,end);
    }
    private int handler(int[] nums,int start,int end){//指针交换
        int key=nums[start];
        int left=start;
        int right=end;
        while(left!=right){
            while (left<right && nums[right]>=key){
                right--;
            }
            while (left<right && nums[left]<=key){
                left++;
            }
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
        int temp=key;
        nums[start]=nums[left];
        nums[left]=temp;
        return left;
    }
    private int handler1(int[] nums,int start,int end){//挖坑法，将第一个元素作为一个坑位
        int key=nums[start];
        int left=start;
        int right=end;
        while(left!=right){
            while (left<right && nums[right]>=key){
                right--;
            }
            nums[start]=nums[right];
            while(left<right && nums[left]<=key){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=key;
        return left;
    }
}
