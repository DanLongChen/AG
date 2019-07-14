package L2019_7_14;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Paser on 2019/7/14.
 * 和为K的子数组
 */
public class L560 {
    public static void main(String[] args) {
        int[] nums={1,1,1};
        System.out.println(new L560().subarraySum(nums,2));
    }
    public int subarraySum(int[] nums, int k) {
        /**
         * 不能使用滑动窗口，使用Map记录前i个元素的和，看看当前的和-K所产生的差值是否出现在HashMap中，若出现则说明当前的子序列可以组成K
         */
        if(nums==null || nums.length==0){
            return 0;
        }
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int result=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int temp=sum-k;
            System.out.println(temp);
            if(map.containsKey(temp)){
                result+=map.get(temp);
            }
            map.put(i,map.getOrDefault(sum,0)+1);//表示为sum的序列的个数
            System.out.println(map);
        }
        return result;
    }
}
