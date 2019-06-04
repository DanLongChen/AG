package L2019_6_4;

import java.util.Arrays;

/**
 * Created by DanLongChen on 2019/6/4
 * 选择排序（前面的是排好序的，然后从后面的选择一个最小值或者最大值，放入到当前的位置）
 **/
public class XuanzePaixu {
    public void sort(int[] nums){
        int minIndex=0;
        for (int i=0;i<nums.length;i++){
            minIndex=i;//在i~n之间找一个最小值，假设第一个为最小值
            for (int j=i;j<nums.length;j++){//在剩余的里面再找一个最小的，放入到当前的位置
                if (nums[j]<nums[minIndex]){
                    minIndex=j;
                }
            }
            if (minIndex!=i){
                int temp=nums[i];
                nums[i]=nums[minIndex];
                nums[minIndex]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={5,4,3,2,1};
        new XuanzePaixu().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
