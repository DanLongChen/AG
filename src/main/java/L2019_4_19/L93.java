package L2019_4_19;

import sun.util.resources.cldr.en.TimeZoneNames_en_PK;

import java.util.ArrayList;
import java.util.List;

/**给出可能的Ip组合
 * Example:
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * Created by DanLongChen on 2019/4/19
 **/
public class L93 {
    public List<String> restoreIpAddresses(String s) {
        /**
         * 初步想法，使用递归,分为四段，每一段的值都必须在0~255之间，因此必须是1位或者3位。可以理解为从s将数字划拨到temp中，符合要求则加入result
         */
        List<String> result=new ArrayList<>();

        handler(result,"",s,0);//当前有多少段
        return result;
    }
    public void handler(List<String> result,String temp,String s,int duan){
        if (duan==4){
            if (s.isEmpty()){
                result.add(temp);
            }
            return;
        }

        for (int i=1;i<4;i++){
            if (s.length()<i){
                break;
            }
            String sub=s.substring(0,i);
            int subInt=Integer.parseInt(sub);
            /**
             * 防止出现010这种不合法的情况
             */
            if (subInt>255 || String.valueOf(subInt).length()!=sub.length()){
                continue;
            }
            handler(result,temp+sub+(duan==3?"":"."),s.substring(i),duan+1);
        }
    }

    public static void main(String[] args) {
        List<String> result=new L93().restoreIpAddresses("25525511135");
        System.out.println(result);
    }
}
