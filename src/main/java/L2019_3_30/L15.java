package L2019_3_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**三个数之和为0
 * Created by Paser on 2019/3/30.
 */
public class L15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> temp=new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }
}
