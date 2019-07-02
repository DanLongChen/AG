package L2019_7_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by DanLongChen on 2019/7/2
 * 括号生成
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L22 {
    /**
     * 解法2：递归加回溯，每次先添加左括号，右括号的添加是先判断右括号的数是否大于左括号
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        //使用回溯，要先添加左括号，然后添加右括号（右括号的数不能率先比左括号的数大），也就是提前排除不可能的情况
        List<String> result=new ArrayList<>();
        if(n<=0){
            return result;
        }
        traceBack(result,"",0,0,n);
        return result;
    }
    private void traceBack(List<String> result,String current,int open,int close,int n){
        if(current.length()==n*2){
            result.add(current);
        }
        if(open<n){
            traceBack(result,current+'(',open+1,close,n);
        }
        if(close<open){//右括号个数<左括号，则可以添加右括号，否则这种情况是错误的情况
            traceBack(result,current+')',open,close+1,n);
        }
    }



    /**
     * 解法1 ： 暴力，穷举所有的可能，然后判断是否符合要求
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        //给出所有组合，然后判断是否是有效的
        List<String> result=new ArrayList<>();
        handler(result,n,"",0);
        return result;
    }
    private void handler(List<String> result,int n,String current,int index){
        if(current.length()==n*2){
            if(isTrue(current)){
                result.add(current);
            }
            return;
        }

        for(int i=index;i<n*2;i++){
            handler(result,n,current+'(',i+1);
            handler(result,n,current+')',i+1);
        }
    }
    private boolean isTrue(String s){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
