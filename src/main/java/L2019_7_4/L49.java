package L2019_7_4;

import java.util.*;

/**
 * Created by DanLongChen on 2019/7/4
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L49 {
    public static void main(String[] args) {
        String[] strings=new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(new L49().groupAnagrams1(strings));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
         * 排序string之后再作为key
         */
        List<List<String>> result=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] temp=s.toCharArray();
            Arrays.sort(temp);
            String key=new String(temp);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        result.addAll(map.values());
        return result;
    }
    public List<List<String>> groupAnagrams1(String[] strs) {
        /**
         * 计算数值，作为key
         */
        List<List<String>> result=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        int[] point=new int[26];
        for(String s:strs){
            Arrays.fill(point,0);
            for (char c:s.toCharArray()){
               point[c-'a']++;
            }
            System.out.println(Arrays.toString(point));
            StringBuilder builder=new StringBuilder();
            for(int i=0;i<26;i++){
                builder.append(point[i]);
            }
            String key=builder.toString();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        result.addAll(map.values());
        return result;
    }
}
