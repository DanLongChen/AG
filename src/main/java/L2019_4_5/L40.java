package L2019_4_5;

import java.util.ArrayList;
import java.util.List;

/**找到数组中的数的组合，使得其和为target（每个数字只能用一次）,这里使用递归
 * Created by Paser on 2019/4/5.
 */
public class L40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        handler(result,new ArrayList<Integer>(),candidates,0,target);
        return result;
    }
    public void handler(List<List<Integer>> result,List<Integer> temp,int[] candidates,int from,int target){
        //这里使用temp来记录这次的结果，在加新元素的时候新建一个list，避免对原来的list产生影响
        if(target==0){
            result.add(temp);
            return;
        }
        if(target<0){
            return;
        }
        for(int i=from;i<candidates.length;i++){
            if(target-candidates[i]>=0){
                List<Integer> list=new ArrayList<>(temp);
                list.add(candidates[i]);
                handler(result,list,candidates,i+1,target-candidates[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={10,1,2,7,6,1,5};
        System.out.println(new L40().combinationSum2(nums,8));
    }
}
