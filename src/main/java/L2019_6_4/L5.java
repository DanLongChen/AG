package L2019_6_4;

import com.sun.prism.shader.DrawPgram_ImagePattern_AlphaTest_Loader;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.util.Arrays;

/**
 * Created by DanLongChen on 2019/6/4
 * 最长回文子串
 **/
public class L5 {
    public static void main(String[] args) {
        System.out.println(new L5().DP("babad"));
    }
    public String longestPalindrome(String s) {
        if (s.length()==1 || s.length()==0){
            return s;
        }
        /**
         * 暴力破解
         */
        int l=0,r=0;
        int maxLength=0;
        int start=0;
        int length=s.length();
        for(int i=0;i<length;i++){
            for (int j=i;j<length;j++){
                /**
                 * 再判断i~j这个区间的字符串是否是回文
                 */
                for (l=i,r=j;l<r;l++,r--){
                    if (s.charAt(l)!=s.charAt(r)){
                        break;
                    }
                }
                if (l>=r && (j-i+1)>maxLength){
                    start=i;
                    maxLength=j-i+1;
                }
            }
        }
        return s.substring(start,start+maxLength);
    }
    public String DP(String s){
        if (s.length()==1 || s.length()==0){
            return s;
        }
        int length=s.length();
        int[][] dp=new int[length][length];
        String result=s.substring(0,1);
        for (int i=0;i<length;i++){
            dp[i][i]=1;
            if(i<length-1 && s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1;//两个相邻的字符相同的情况
                dp[i+1][i]=1;//因为是对称的
                result=s.substring(i,i+2);
            }
        }
        int maxLength=0;
        for (int l=3;l<=length;l++){
            for (int i=0;i+l-1<length;i++){
                int j=i+l-1;
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1];
                    if (dp[i][j]==1 && j-i+1>maxLength){
                        result=s.substring(i,j+1);
                    }
                }
            }
        }
        return result;
    }
}
