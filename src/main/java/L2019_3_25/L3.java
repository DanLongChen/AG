package L2019_3_25;

import java.util.HashMap;
import java.util.Map;

/**最长非重复字符串
 * Created by DanLongChen on 2019/3/25
 **/
public class L3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars=s.toCharArray();
        int max=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0,j=0;j<chars.length;j++){
            if(map.containsKey(chars[j])){
                /**
                 * 这个用来记录上次相同的字符所匹配的位置，使用max保证了i不会倒退
                 */
                i=Math.max(i,map.get(chars[j])+1);
            }
            map.put(chars[j],j);
            max=Math.max(max,j-i+1);
        }
        return max;
    }

    public static void main(String[] args) {
        L3 l3=new L3();
        System.out.println(l3.lengthOfLongestSubstring("abcabcbb"));
    }
}
