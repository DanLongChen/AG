package L2019_5_20;

/**
 * Created by DanLongChen on 2019/5/20
 **/

import com.sun.org.glassfish.external.amx.AMX;

import javax.management.relation.InvalidRelationTypeException;
import java.util.Stack;

/**
 * 最长有效括号
 */
public class L32 {
    public static void main(String[] args) {
        System.out.println(new L32().DP(")()())"));
    }
    public int longestValidParentheses(String s) {
        Stack<Character> stack1=new Stack<>();//用于记录放入的括号
        Stack<Integer> stack2=new Stack<>();//用于记录当前括号在字符串中的ID
        int max=0,temp=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                stack1.push(s.charAt(i));//左括号直接入栈
                stack2.push(i);//同时记录当前括号的坐标
            }else{//处理当前的括号是)的情况
                if(!stack1.isEmpty() && stack1.peek()=='('){//正好匹配
                    stack1.pop();
                    stack2.pop();
                    temp=stack2.isEmpty()?i+1:(i-stack2.peek());
                    max=Math.max(temp,max);
                    System.out.println(max);
                }else{
                    stack1.push(s.charAt(i));//左括号直接入栈
                    stack2.push(i);//同时记录当前括号的坐标
                }
            }
        }
        return max;
    }
    public int DP(String s){
        int max=0;
        s=')'+s;
        int[] dp=new int[s.length()];
        for(int i=1;i<s.length();i++){
            if (s.charAt(i)==')'){
                if (s.charAt(i-1-dp[i-1])=='('){
                    dp[i]=dp[i-1]+2;
                }
                dp[i]+=dp[i-dp[i]];
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
