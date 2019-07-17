package L2019_7_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DanLongChen on 2019/7/17
 **/
public class raoquanpaidui {
    public static void main(String[] args) {
        int[] nums={100,103,98,105};
        List<Integer> result=new raoquanpaidui().handler(nums);
        int max=0;
        for (int i=0;i<result.size()-1;i++){
            max=Math.max(max,Math.abs(result.get(i+1)-result.get(i)));
        }
        max=Math.max(max,Math.abs(result.get(0)-result.get(result.size()-1)));
        System.out.println(max);

    }
    public List<Integer> handler(int[] nums){
        /**
         * 先排序，然后以第一个值为中心，把剩下的值先插入左边，然后再插入右边
         */
        Arrays.sort(nums);
        List<Integer> result=new ArrayList<>();
        result.add(nums[0]);
        boolean flag=false;
        for(int i=1;i<nums.length;i++){
            //剩下的数字先插入左边然后再插入右边
            if(flag==false){
                result.add(0,nums[i]);
                flag=true;
            }else{
                result.add(nums[i]);
                flag=false;
            }
        }
        return result;
    }
}
