package L2019_3_31;

import java.util.Arrays;

/**三个数的和最接近于某个数
 * Created by DanLongChen on 2019/3/31
 **/
public class L16 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }
        int close=Integer.MAX_VALUE;
        int result=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(Math.abs(nums[i]+nums[j]+nums[k]-target)<close){
                        close = Math.abs(nums[i]+nums[j]+nums[k]-target);
                        result=nums[i]+nums[j]+nums[k];
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={-1, 2, 1, -4};
        System.out.println(new L16().threeSumClosest(nums,1));
    }
}
