package L2019_4_1;

import java.util.ArrayList;
import java.util.List;

/**获取（可能的所有组合，输入n表示给多少对括号
 * Created by DanLongChen on 2019/4/1
 **/
public class L22 {
    /**
     * 暴力破解（当(>)的时候，下一个可以为（也可以为）；当）==（的时候，下一个只能为（               ），这里可以使用迭代
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
       return handler("",n,0,0);
    }
    public List<String> handler(String result,int n,int left,int right){
        List<String> list = new ArrayList<>();
        /**
         * 左括号个数没有到达总个数的情况下
         */
        if(left<n){
            /**
             * 左括号>右括号----则可以加左括号或者右括号
             */
            if(left>right){
                list.addAll(handler(result+"(",n,left+1,right));
                list.addAll(handler(result+")",n,left,right+1));
                /**
                 * 否则只能加左括号
                 */
            }else{
                list.addAll(handler(result+"(",n,left+1,right));
            }
        }
        /**
         * 如果左边的已经到达指定的个数，则直接添加右括号
         */
        if(left==n && right<n){
            String temp=result;
            for(int i=right;i<n;i++){
                temp+=")";
            }
            list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new L22().generateParenthesis(1));
    }
}
