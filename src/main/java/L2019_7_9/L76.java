package L2019_7_9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DanLongChen on 2019/7/9
 **/
public class L76 {
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.println(new L76().minWindow(s,t));
    }
    public String minWindow(String s, String t) {
        //解法1：滑动窗口
        if(s==null || s.length()==0){
            return "";
        }
        Map<Character,Integer> map=new HashMap<>();//记录对应的关系

        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.get(t.charAt(i))==null?1:map.get(t.charAt(i))+1);
        }
        int left=0,right=0;
        int format=0;
        Map<Character,Integer> map1=new HashMap<>();//记录对应的关系
        int[] result={-1,0,0};//用于记录结果，长度，起点，终点
        int required=map.size();//表示map中存放了多少种不同的字符
        while(right<s.length()){
            char temp=s.charAt(right);
            map1.put(temp,map1.get(temp)==null?1:map1.get(temp)+1);
            if(map.containsKey(temp) && map.get(temp)==map1.get(temp)){
                format++;
            }
            while(left<=right && format==required){//不同的字符种类数要相同
                if(result[0]==-1 || (right-left)+1<result[0]){
                    int length=right-left+1;
                    result[0]=length;
                    result[1]=left;
                    result[2]=right;
                }
                map1.put(s.charAt(left),map1.get(s.charAt(left))-1);
                System.out.println(map1+"  "+format);
                if(map.containsKey(s.charAt(left)) && map1.get(s.charAt(left))<map.get(s.charAt(left))){
                    format--;
                }
                left++;
            }
            right++;
        }
        if(result[0]==-1){
            return "";
        }else{
            System.out.println(Arrays.toString(result));
            return s.substring(result[1],result[2]+1);
        }
    }
}
