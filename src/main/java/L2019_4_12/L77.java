package L2019_4_12;

import java.util.ArrayList;
import java.util.List;

/**给定两个数，k表示有多少个1~n的数参与组合，要求返回所有的组合数(递归+回溯)
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * Created by DanLongChen on 2019/4/12
 **/
public class L77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        handler(result,new ArrayList<Integer>(),n,k,1);
        return result;
    }
    public void handler(List<List<Integer>> result,List<Integer> temp,int n,int k,int position){
        if (temp.size()==k){
            List<Integer> list = new ArrayList<>(temp);
            result.add(list);
            return;
        }
        for (int i=position;i<=n;i++){
            temp.add(i);
            handler(result,temp,n,k,i+1);
            temp.remove(temp.size()-1);
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> result=new L77().combine(4,2);
        System.out.println(result);
    }
}
