package L2019_6_26;

/**
 * Created by DanLongChen on 2019/6/26
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class L5 {
    public static void main(String[] args) {
        System.out.println(new L5().longestPalindrome("babad"));
    }
    public String longestPalindrome(String s) {
        if(s.length()<=0){
            return "";
        }
        //先使用暴力
        for(int i=s.length();i>0;i--){//表示长度（直接从最长的长度开始查验能否构成回文）
            for(int j=0;j<=s.length()-i;j++){//开始的下标
                String sub=s.substring(j,j+i);
                int start=0,end=sub.length()-1;
                while(start<=end){
                    if(sub.charAt(start)==sub.charAt(end)){
                        start++;
                        end--;
                    }else{
                        break;
                    }
                }
                if (start>end)
                return sub;
            }
        }
        return "";
    }
    public String longestPalindrome1(String s) {
        /**
         * 使用DP
         */
        if(s==null || s.length()==0){
            return "";
        }
        int[][] dp=new int[s.length()][s.length()];//表示起点和终点是否为回文
        int start=0;//表示起点
        int length=1;//表示回文的长度
        for(int i=0;i<s.length();i++){
            dp[i][i]=1;
            if(i<s.length()-1)
                if(s.charAt(i)==s.charAt(i+1)){
                    dp[i][i+1]=1;
                    start=i;
                    length=2;
                }
        }
        for(int l=3;l<=s.length();l++){//表示长度
            for(int i=0;i+l-1<s.length();i++){//起点，终点为i+l-1要<s.length()
                int j=i+l-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                    dp[i][j]=1;
                    start=i;
                    length=l;
                }

            }
        }
        return s.substring(start,start+length);
    }
    public String longestPalindrome2(String s) {
        //中心扩展
        if(s==null || s.length()==0){
            return "";
        }
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int len1=handler(s,i,i);//单核扩展
            int len2=handler(s,i,i+1);//双核扩展
            int len=Math.max(len1,len2);
            if(len>end-start+1){
                start=i-(len-1)/2;//从当前节点往前推算起始节点
                end=i+len/2;//从当前节点推算重点（这个可以自己代数看看）
            }
        }
        return s.substring(start,end+1);
    }
    private int handler(String s,int start,int end){
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;//end-start-2+1，因为start--，end++会超过边界，所以需要返回操作
    }
}
