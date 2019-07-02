package L2019_7_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanLongChen on 2019/7/2
 * 电话号码组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L17 {
    private String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        //递归实现
        List<String> result=new ArrayList<>();
        if(digits==null || digits.length()==0){
            return result;
        }
        handler(result,"",digits);
        return result;
    }

    /**
     *
     * @param result    存放所有结果的集合
     * @param current   当前的组合数（还没有完全组合好的那个数）
     * @param digits    表示输入的数字
     */
    private void handler(List<String> result,String current,String digits){
        if(current.length()>=digits.length()){
            if(current.length()==digits.length())
            result.add(current);
            return;
        }
        int index=digits.charAt(current.length())-'0';//表示当前的数字在map的下标
        String mapValue=map[index];
        for(int i=0;i<mapValue.length();i++){
            handler(result,current+mapValue.charAt(i),digits);
        }
    }

    public static void main(String[] args) {
        System.out.println(new L17().letterCombinations("23"));
    }
}
