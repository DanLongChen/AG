package L2019_4_6;

import javax.jnlp.IntegrationService;
import java.util.*;

/**将具有相同字符的字符串组合在一起
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 * Created by Paser on 2019/4/6.
 */
public class L49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
         * 总体思想就是算出每个字符串的ascll码，将ascll码相同的字符串放在一起(不过好像不行)
         */
        List<List<String>> result=new ArrayList<>();
        int[] ascll=new int[strs.length];//对应于每一个字符串
        for(int i=0;i<strs.length;i++){
            int num=0;
            for (int j=0;j<strs[i].length();j++){
                num+=strs[i].charAt(j);
            }
            ascll[i]=num;
        }
        for (int i=0;i<ascll.length;i++){
            int temp=ascll[i];
            if(temp!=Integer.MAX_VALUE){
                List<String> stringList=new ArrayList<>();
                stringList.add(strs[i]);
                for (int j=i+1;j<ascll.length;j++){
                    if (ascll[j]!= Integer.MAX_VALUE && ascll[j]==temp){
                        stringList.add(strs[j]);
                        ascll[j]=Integer.MAX_VALUE;
                    }else{
                        continue;
                    }
                }
                result.add(stringList);
            }
        }
        return result;

    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        /**
         * 为每一个string配置一个set，用来检测是否相同
         */
        List<List<String>> result=new ArrayList<>();
        int[] flag=new int[strs.length];
        for (int i=0;i<strs.length;i++){
            if (flag[i]==0){
                Set<Character> set=new HashSet<Character>();//记录当前i位置的string的字符串
                List<String> list=new ArrayList<>();
                list.add(strs[i]);
                flag[i]=1;
                for (int c=0;c<strs[i].length();c++){
                    set.add(strs[i].charAt(c));
                }
                for (int j=i+1;j<strs.length;j++){
                    if (flag[j]==0){
                        Set<Character> setj=new HashSet<Character>();//记录当前i位置的string的字符串
                        for (int c=0;c<strs[j].length();c++){
                            setj.add(strs[j].charAt(c));
                        }
                        if (set.equals(setj)){
                            flag[j]=1;
                            list.add(strs[j]);
                        }
                    }

                }
                result.add(list);
            }
        }
        return result;
    }


    /**
     * 使用 hashmap<String,List<String></>></>
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams3(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for (String str:strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            /**
             * 这里把排序之后的String作为key
             */
            String key=String.valueOf(chars);
            if (map.containsKey(key)){
                map.get(key).add(str);
            }else{
                map.put(key,new ArrayList<String>());
                map.get(key).add(str);
            }
        }
        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {
        String[] nums={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new L49().groupAnagrams3(nums));

    }
}
