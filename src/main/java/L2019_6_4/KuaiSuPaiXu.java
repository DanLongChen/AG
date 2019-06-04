package L2019_6_4;

import java.util.Arrays;

/**
 * Created by DanLongChen on 2019/6/4
 * 快速排序，主要思想就是找一个基准值(一般是第一个)，然后从后往前找一个比基准值小的值，与基准值交换，再从前往后找一个比基准值大的值，与基准值交换，知道l==r
 * http://www.sohu.com/a/246785807_684445
 **/
public class KuaiSuPaiXu {
    public void quickSort(int nums[],int l,int r){//第一个数作为基准
        if (l>=r){
            return;
        }
        int jizhun=handler1(nums,l,r);
        quickSort(nums,l,jizhun-1);
        quickSort(nums,jizhun+1,r);
    }
    public int handler(int nums[],int firstIndex,int lastIndex){//使用指针交换法
        int jizhun=nums[firstIndex];
        int left=firstIndex;
        int right=lastIndex;
        while (left!=right){
            while (left<right && nums[right]>jizhun){
                right--;
            }
            while (left<right && nums[left]<=jizhun){
                left++;
            }
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
        /**
         * 最后还需要将基准放在中间
         */
        int temp=nums[left];
        nums[left]=nums[firstIndex];
        nums[firstIndex]=temp;
        return left;
    }
    public int handler1(int[] nums,int firstIndex,int lastIndex){//挖坑法（将基准的那个index作为坑位）
        int jizhun=nums[firstIndex];
        int left=firstIndex;
        int right=lastIndex;
        while (left!=right){
            while (left<right && nums[right]>jizhun){
                right--;
            }
            nums[firstIndex]=nums[right];
            while (left<right && nums[left]<jizhun){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=jizhun;
        return left;
    }

    public static void main(String[] args) {
        int[] nums={5,2,4,3,1};
        new KuaiSuPaiXu().quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
