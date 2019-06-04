package L2019_6_4;

import java.util.Arrays;

/**
 * Created by DanLongChen on 2019/6/4
 * 冒泡排序（从第0个开始，与后面的比较，大的就往后移动）
 **/
public class MaoPao {
    public void sort(int[] nums){
        for (int i=0;i<nums.length-1;i++){//表示需要多少趟（排到倒数第二个就可以，倒数第一个的数自然就出来了）
            for (int j=0;j<nums.length-i-1;j++){//需要比较的范围，因为一趟之后有一个最大的值被放在最后，这个最大的数就不用比较了（当0的时候，需要比较到）
                if (nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={5,4,3,2,1};
        new MaoPao().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
