package L2019_7_16;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanLongChen on 2019/7/16
 * 子集
 *
 **/
public class L78 {
    public List<List<Integer>> subsets(int[] nums) {
        /**
         * 使用递归+回溯
         */
        List<List<Integer>> result=new ArrayList<>();
        handler(nums,result,new ArrayList<>(),0);
        return result;
    }
    private void handler(int[] nums,List<List<Integer>> result,List<Integer> list, int position){
        if(list.size()<=nums.length){
            result.add(new ArrayList<>(list));
        }
        for(int i=position;i<nums.length;i++){
            list.add(nums[i]);
            handler(nums,result,list,i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(new L78().subsets(nums));
    }
}
