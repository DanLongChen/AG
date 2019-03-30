package L2019_3_30;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**最长字符串数组前缀
 * Created by Paser on 2019/3/30.
 */
public class L14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if (strs.length==1){
            return strs[0];
        }
        StringBuilder builder=new StringBuilder();
        int min=strs[0].length();
        /**
         * 现求出最小长度
         */
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<min){
                min=strs[i].length();
            }
        }
        int index=0;
        out:
        while (true){
            Set<Character> set=new HashSet<>();
            if(index<min){
                set.add(strs[0].charAt(index));
            }else{
                break ;
            }
            for (int i=1;i<strs.length;i++){
                if(index<min){
                    if(set.contains(strs[i].charAt(index))){
                        continue;
                    }else{
                        break out;
                    }
                }
            }
            builder.append(strs[0].charAt(index));
            index++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] test={"","",""};
        System.out.println(new L14().longestCommonPrefix(test));
    }
}
