package L2019_7_4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanLongChen on 2019/7/4
 * 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L46 {

    public List<List<Integer>> permute(int[] nums) {
        //递归+回溯，在这里每一个数只能使用一次，下一个遍历的start=i+1
        List<List<Integer>> result=new ArrayList<>();
        handler(result,new ArrayList<Integer>(),nums);
        return result;
    }
    private void handler(List<List<Integer>> result,List<Integer> list,int[] nums){
        if(list.size()==nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){//每一次都从nums中选一个，查看当前选中的这个数是否在list'中，若不在则加入，否则选下一个数
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            handler(result,list,nums);
            list.remove(list.size()-1);
        }
    }
}
