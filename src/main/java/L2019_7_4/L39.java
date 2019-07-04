package L2019_7_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DanLongChen on 2019/7/4
 * 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //使用递归+回溯，因为每一个数都可以用多次，但是不能出现相同的答案，那么需要设置一个start,表示起始的位置，然后从这个位置往下找，这样可以保证不重复
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);//需要新进行排序，这样就可以提前排除一些测试用例
        if(target<candidates[0]){
            return result;
        }
        handler(result,new ArrayList<Integer>(),0,target,candidates,0);
        return result;
    }
    private void handler(List<List<Integer>> result,List<Integer> list,int sum,int target,int[] candidates,int start){
        if(sum==target){
            result.add(new ArrayList<>(list));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            sum+=candidates[i];
            if(sum>target){
                break;
            }
            list.add(candidates[i]);
            handler(result,list,sum,target,candidates,i);
            sum-=candidates[i];
            list.remove(list.size()-1);
        }
    }
}
