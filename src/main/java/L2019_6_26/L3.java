package L2019_6_26;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by DanLongChen on 2019/6/26
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L3 {
    public int lengthOfLongestSubstring(String s) {
        /**
         * 解法1：暴力破解，从当前位置开始查看最长的不重复子串是多少
         */
        int max=0;
        for(int i=0;i<s.length();i++){
            Set<Character> set=new HashSet<>();
            for(int j=i;j<s.length();j++){
                if(set.contains(s.charAt(j))){
                    break;
                }else{
                    set.add(s.charAt(j));
                    if(set.size()>max){
                        max=set.size();
                    }
                }
            }
        }
        return max;
    }
    public int lengthOfLongestSubstring1(String s) {
        /**
         * 使用滑动窗口（使用数组代替map）
         */
        int n = s.length(), a = 0;
        int [] index = new int[128];
        int i = 0;
        for (int j = 0;j < n; j++){
            i = Math.max(index[s.charAt(j)], i);
            a = Math.max(a, j-i+1);
            index[s.charAt(j)] = j + 1;//写入下一个不重复的位置
        }
        return a;
    }
    public int lengthOfLongestSubstring2(String s) {
        /**
         * 也是使用滑动窗口，用map来记录
         * 比如abcabcbb
         * 首先是abc都是不重复的，然后start=0,end=2,result=3
         * 下一个指向的是a，与num[start]重复了，那么start=start+1，这个时候不重复范围是bca
         */
        char[] a = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; j < a.length; j++) {
            if (map.containsKey(a[j])) {
                i = Math.max(i, map.get(a[j]) + 1);//获取上一个含a[j]字符的下标，那么不重复的下标从a[j]+1开始
            }
            max = Math.max(max, j - i + 1);
            map.put(a[j], j);
        }
        return max;
    }
}
