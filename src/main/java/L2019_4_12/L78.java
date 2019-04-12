package L2019_4_12;

import java.util.ArrayList;
import java.util.List;

/**要求返回nums的子集，和L77差不多
 * Created by DanLongChen on 2019/4/12
 **/
public class L78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        handler(result,new ArrayList<Integer>(),nums,0);
        return result;
    }
    public void handler(List<List<Integer>> result,List<Integer> temp,int[] nums,int position){
        if (temp.size()<=nums.length){
            result.add(new ArrayList<Integer>(temp));
        }
        for (int i=position;i<nums.length;i++){
            temp.add(nums[i]);
            handler(result,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> result=new L78().subsets(nums);
        System.out.println(result);
    }
}
