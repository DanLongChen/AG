package L2019_4_14;

/**编码方式（字母和数字对应），求其对应的编码方式有多少种
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * Created by DanLongChen on 2019/4/14
 **/
public class L91 {
    public int numDecodings(String s) {
        /**
         * 使用迭代+回溯
         */
        if (s.length()==0){
            return 0;
        }
        if (s.length()==1){
            return 1;
        }
        char[] chars = s.toCharArray();
        return 0;
    }
}
