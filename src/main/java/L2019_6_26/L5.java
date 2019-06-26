package L2019_6_26;

/**
 * Created by DanLongChen on 2019/6/26
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L5 {
    public static void main(String[] args) {
        System.out.println(new L5().longestPalindrome("babad"));
    }
    public String longestPalindrome(String s) {
        if(s.length()<=0){
            return "";
        }
        //先使用暴力
        for(int i=s.length();i>0;i--){//表示长度（直接从最长的长度开始查验能否构成回文）
            for(int j=0;j<=s.length()-i;j++){//开始的下标
                String sub=s.substring(j,j+i);
                int start=0,end=sub.length()-1;
                while(start<=end){
                    if(sub.charAt(start)==sub.charAt(end)){
                        start++;
                        end--;
                    }else{
                        break;
                    }
                }
                if (start>end)
                return sub;
            }
        }
        return "";
    }
}
