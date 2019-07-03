package L2019_7_3;

import java.util.Stack;

/**
 * Created by DanLongChen on 2019/7/3
 * 最长有效括号
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L32 {
    public int longestValidParentheses(String s) {
        //借助于栈来实现括号匹配，记录下当前放入栈的括号的下标，然后做个差值
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int result=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){//左括号直接放入
                stack.push(i);
            }else{//右括号判断栈是否已经空了
                stack.pop();
                if(stack.isEmpty()){//已经空了则加入当前的下标
                    stack.push(i);
                }else{
                    result=Math.max(result,i-stack.peek());//否则计算当前的最大值
                }

            }
        }
        return result;
    }
    public int longestValidParentheses2(String s) {
        //使用DP，DP[i]表示i~s.length()-1之间的有效子串的长度是多少，以)开头的不用统计，因为以)开头的子串是非法的
        /**
         * 一般对于最长XX问题容易想到利用DP求解，在这题中利用逆向DP，设状态dp[i]为从i到len - 1中，以i开头的最长合法子串长度：也就是判断串i~length-1是否是合法的，并且计算长度
         * 若为非法则其长度为0
         *  初始化：dp[len - 1] = 0
         *         如果s[i] = ')'，则跳过，因为不可能有由'('开头的串
         *         如果s[i] = '('，则需要找到右括号和它匹配，可以跳过以i + 1开头的合法子串，则需要看j = i + dp[i + 1] + 1是否为右括号。
         *         如果没越界且为右括号，那么有dp[i] = dp[i + 1] + 2，此外在这个基础上还要将j + 1开头的子串加进来（只要不越界）
         */
        //


        if(s==null || s.length()==0){
            return 0;
        }
        int length=s.length();
        int[] dp=new int[length];
        int result=0;
        for(int i=length-2;i>=0;i--){
            if(s.charAt(i)=='('){
                int j=i+dp[i+1]+1;
                if(j<length && s.charAt(j)==')'){
                    dp[i]=dp[i+1]+2;
                    if(j+1<length){
                        dp[i]+=dp[j+1];
                    }
                }
                result=Math.max(result,dp[i]);
            }
        }
        return result;
    }
}
