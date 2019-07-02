package L2019_7_2;

import java.util.Stack;

/**
 * Created by DanLongChen on 2019/7/2
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L20 {
    public boolean isValid(String s) {
        //遇到左括号，进栈，遇到右括号出栈，并且判断是否匹配，字符串便利完之后，再判断栈是否为空
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ss=s.charAt(i);
            if(ss=='(' || ss=='{' || ss=='['){
                stack.push(ss);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char temp=stack.pop();
                if(temp=='(' && ss==')' || temp=='{' && ss=='}' || temp=='[' && ss==']'){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
