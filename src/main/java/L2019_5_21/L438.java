package L2019_5_21;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanLongChen on 2019/5/21
 **/

/**
 * 找出字符串中的所有匹配字谜的下标(只含小写字母)
 */
public class L438 {
    public static void main(String[] args) {
        List<Integer> result=new L438().findAnagrams("baa","aa");
        System.out.println(result.toString());
    }
    public List<Integer> findAnagrams(String s, String p) {
        /**
         * 滑动窗口
         */
        int[] nums=new int[26];//记录p中所有的字母所在的位置
        for (int i=0;i<p.length();i++){
            nums[p.charAt(i)-'a']++;
        }
        List<Integer> result=new ArrayList<>();
        int left=0,right=0,count=p.length();
        while (right<s.length()){
            /**
             * 首先扩展窗口
             */
            if (nums[s.charAt(right)-'a']>0){
                nums[s.charAt(right)-'a']--;//这样做是为了防止匹配串是aab这样子的情况
                right++;
                count--;
            }else{//如果不是对应的值，那么出窗口，并且将其在nums中的值+1，这样子遇到这个值的时候会进入窗口
                nums[s.charAt(left)-'a']++;
                left++;
                count++;
            }
            if (count==0){
                result.add(left);
            }
        }
        return result;
    }
}
