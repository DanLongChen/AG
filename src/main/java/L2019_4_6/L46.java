package L2019_4_6;

import com.sun.org.apache.xerces.internal.xs.LSInputList;

import javax.xml.transform.Templates;
import java.util.ArrayList;
import java.util.List;

/**给定一组不同的整数，求其全部排列数
 * Input: [1,2,3]
 Output:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 * Created by Paser on 2019/4/6.
 */
public class L46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            arr.add(nums[i]);
        }
        handler(result,new ArrayList<Integer>(),arr);
        return result;
    }
    public void handler(List<List<Integer>> result,List<Integer> temp,List<Integer> arr){
        /**
         * 使用arr是否为空表示结束，每一次从arr中取一个数加入当前的temp结果集合
         */
        if(arr.size()==0){
            result.add(temp);
            return;
        }
        for(int i=0;i<arr.size();i++){
            List<Integer> list=new ArrayList<>(temp);
            List<Integer> newArr=new ArrayList<>(arr);//防止递归中的其他修改对这次递归造成影响
            int value=arr.get(i);
            list.add(value);
            newArr.remove(i);
            handler(result,list,newArr);
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(new L46().permute(nums).toString());
    }
}
