package L2019_4_5;

import sun.util.resources.cldr.da.CurrencyNames_da;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**找到数组中的数的组合，使得其和为target（每个数字只能用一次）,这里使用递归
 * Created by Paser on 2019/4/5.
 */
public class L40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        handler(result,new ArrayList<Integer>(),candidates,0,target);
        return result;
    }
    public void handler(List<List<Integer>> result,List<Integer> temp,int[] candidates,int from,int target){
        //这里使用temp来记录这次的结果，在加新元素的时候新建一个list，避免对原来的list产生影响
//        if(target==0){
//            result.add(temp);
//            return;
//        }
//        if(target<0){
//            return;
//        }
        for(int i=from;i<candidates.length;i++){
            if(target-candidates[i]>0){
                if (i>from && candidates[i]==candidates[i-1]){
                    continue;
                }
                target-=candidates[i];
                temp.add(candidates[i]);
                handler(result,temp,candidates,i+1,target);//这个目标已经搜索过了，那么朝着下一个目标搜索
                /**
                 * 这里使用了回溯
                 */
                target+=candidates[i];
                temp.remove(temp.size()-1);
            }
            else if(target-candidates[i]==0){
                List<Integer> list=new ArrayList<>(temp);
                list.add(candidates[i]);
                result.add(list);
                break;
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={2,5,2,1,2};
        System.out.println(new L40().combinationSum2(nums,5));
    }
}
