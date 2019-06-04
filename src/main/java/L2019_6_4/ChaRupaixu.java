package L2019_6_4;

import java.util.Arrays;

/**
 * Created by DanLongChen on 2019/6/4
 * 插入排序(前面的是已经排好序的，然后到第i个，与之前的比，选择合适的插入位置)
 **/
public class ChaRupaixu {
    public void sort(int[] nums){
        int length=nums.length;
        for (int i=1;i<nums.length;i++){//取出第i个下标的数，然后与前面的进行比较
            for (int j=i;j>0;j--){
                if (nums[j]<nums[j-1]){
                    int temp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={5,4,3,2,1};
        new ChaRupaixu().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
