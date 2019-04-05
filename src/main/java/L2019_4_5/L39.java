package L2019_4_5;

import java.util.ArrayList;
import java.util.List;

/**组合数组中的数字，使其和为target（每个数可以多次使用）
 * Created by Paser on 2019/4/5.
 */
public class L39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        handler(result,new ArrayList<Integer>(),candidates,0,target);
        return result;
    }
    public void handler(List<List<Integer>> result,List<Integer> temp,int[] candidates,int from,int target){
        if(target==0){
            result.add(temp);
        }
        if(target<0){
            return;
        }
        for (int i=from;i<candidates.length;i++){
            if (target-candidates[i]>=0){
                List<Integer> list=new ArrayList<>(temp);
                System.out.println(candidates[i]);
                list.add(candidates[i]);
                handler(result,list,candidates,i,target-candidates[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={2,3,6,7};
        List<List<Integer>> list=new L39().combinationSum(arr,7);
        System.out.println(list.toString());
    }
}
