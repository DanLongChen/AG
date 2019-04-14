package L2019_4_14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**给定一个可能包含重复项的nums，求其子集（不能包含重复的）
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * Created by DanLongChen on 2019/4/14
 **/
public class L90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        handler(result,new ArrayList<Integer>(),nums,0);
        return result;
    }
    public void handler(List<List<Integer>> result,List<Integer> temp,int[] nums,int position){
        if (temp.size()<=nums.length){
            result.add(new ArrayList(temp));
        }
        for (int i=position;i<nums.length;i++){

            /**
             * 处理有两个数相同的情况
             */
            if (i>position && nums[i]==nums[i-1]){//在第二个相同的时候直接跳过
                continue;
            }
            temp.add(nums[i]);
            handler(result,temp,nums,i+1);
            /**
             * 回溯
             */
            temp.remove(temp.size()-1);//回溯的时候可能会出现（1,2）回溯完之后变成（1），然后再把第二个2添加=》(1,2)
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,2};
        List<List<Integer>> result=new ArrayList<>();
        result=new L90().subsetsWithDup(nums);
        System.out.println(result);
    }
}
