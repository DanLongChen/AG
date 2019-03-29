package L2019_3_26;

import java.util.Arrays;

/**Longest Palindromic Substring(最长回文子串)
 * Created by DanLongChen on 2019/3/26
 **/
public class L5 {
    public static void main(String[] args) {
        L5 l5=new L5();
        System.out.println(l5.longestPalindrome("abaa"));
    }
    /**
     * 方法一：由中心点向两端扩散
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s.length()<=0){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        char[] temp=s.toCharArray();
        int[] leftAndMaxLength=new int[2];
        leftAndMaxLength[0]=0;
        leftAndMaxLength[1]=1;
        for(int i=0;i<temp.length;i++){
            handler(temp,i,i,leftAndMaxLength);//考虑aba
            handler(temp,i,i+1,leftAndMaxLength);//考虑aooa
        }
        return s.substring(leftAndMaxLength[0],leftAndMaxLength[0]+leftAndMaxLength[1]);
    }

    /**
     * 两个指针向两端扩散
     * @param chars
     * @param start
     * @param end
     * @param
     * @param
     */
    public void handler(char[] chars,int start ,int end,int[] leftAndMAxLength){
        System.out.println(Arrays.toString(chars));
        if(start>=0 && end<chars.length && chars[start]==chars[end]){
            /**
             * 向两端扩散
             */
            --start;
            ++end;
            System.out.println(start+"   "+end);
        }
        if(leftAndMAxLength[1]<end-start-1){//(end-1)-(start+1)+1
            leftAndMAxLength[1]=end-start-1;
            leftAndMAxLength[0]=start+1;
            System.out.println("max"+"   "+Arrays.toString(leftAndMAxLength));
        }
    }
}
