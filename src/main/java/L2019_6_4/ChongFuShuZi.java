package L2019_6_4;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by DanLongChen on 2019/6/4
 * 查找数组中的重复数字
 **/
public class ChongFuShuZi {
    public static void main(String[] args) {
        int[] nums={2,3,1,0,2,5,3};
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                System.out.println(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
    }
}
