package L2019_4_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**   4sums
 * Created by Paser on 2019/4/5.
 */
public class L18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        if (nums.length<4){
            return result;
        }
        for (int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    for(int h=k+1;h<nums.length;h++){
                        if(nums[i]+nums[j]+nums[k]+nums[h]==target){
                            List<Integer> temp=new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[h]));
                            result.add(temp);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={1, 0, -1, 0, -2, 2};
        System.out.println(new L18().fourSum(nums,0));
    }
}
