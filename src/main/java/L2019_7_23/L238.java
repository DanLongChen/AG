package L2019_7_23;

import java.util.Arrays;

/**
 * Created by DanLongChen on 2019/7/23
 * 除自身之外数组的乘积
 **/
public class L238 {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null || nums.length==0){
            return nums;
        }
        int[] res=new int[nums.length];
        int left=1;
        for(int i=0;i<nums.length;i++){
            res[i]=left;
            left*=nums[i];//用于表示除i之外的左边数的乘积
        }
        int right=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i]=res[i]*right;
            right*=nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(Arrays.toString(new L238().productExceptSelf(nums)));
    }
}
