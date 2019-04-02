package L2019_4_1;

import java.util.Stack;

/**字符括号匹配
 * Created by DanLongChen on 2019/4/1
 **/
public class L20 {
    public boolean isValid(String s) {
        /**
         * 左边的括号都放在栈中，右边的括号进行消解
         */
        char[] chars=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty()){
                /**
                 * 括号进行消解
                 */
                if(stack.peek()=='{' && s.charAt(i)=='}' || stack.peek()=='['&& s.charAt(i)==']' || stack.peek()=='('&&s.charAt(i)==')'){
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new L20().isValid("{}{}"));
    }
}
