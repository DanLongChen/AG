package L2019_4_14;

/**编码方式（字母和数字对应），求其对应的编码方式有多少种
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * Created by DanLongChen on 2019/4/14
 **/
public class L91 {
    public int numDecodings(String s) {
        if (s.length()==0 || s.length()==1&&s.charAt(0)=='0'){
            return 0;
        }
        if (s.length()==1){
            return 1;
        }
        /**
         * 使用迭代+回溯
         */
        char[] chars = s.toCharArray();
        int[] result=new int[1];
        handler(result,0,chars);
        return result[0];
    }
    public int DP(String s){
        if (s.length()==0){
            return 0;
        }
        /**
         * 字符串长度为1的情况
         */
        int[] dp=new int[s.length()];
        dp[0]=s.charAt(0)=='0'?0:1;
        if (s.length()==1){
            return dp[0];
        }
        /**
         * 字符串长度为2，第一种是拆分的情况，第二种是合并的情况
         */
        dp[1]+=s.charAt(0)>'0' && s.charAt(1)>'0'?1:0;//第一种是独立的情况，有一个为0，就不能拆分了1-0这样子
        dp[1]+=(s.charAt(0)=='1'||s.charAt(0)=='2'&&s.charAt(1)<='6'?1:0);//这一种是合并的情况
        for (int i=2;i<s.length();i++){
            /**
             * 当前位置i，能否独立
             */
            if (s.charAt(i)!='0'){
                dp[i]+=dp[i-1];
            }
            /**
             * 当前位置i，能否合并
             */
            if (s.charAt(i-1)=='1' || s.charAt(i-1)=='2'&&s.charAt(i)<='6'){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()-1];
    }
    public void handler(int[] result,int position,char[] chars){
        if (position==chars.length){
            result[0]+=1;
            return;
        }
        for (int i=position;i<chars.length;i++){
            if (chars[i]=='0'){//存在0的情况，要么和前面的数进行组合，要么把这种情况排除（也就是不统计次数）
                break;
            }
            if (i+1<chars.length){
                String temp=chars[i]+""+chars[i+1];
                if (Integer.valueOf(temp)<=26){
                    handler(result,i+2,chars);
                    continue;
                }
            }
            handler(result,i+1,chars);
        }
    }

    public static void main(String[] args) {
        String s="100";
        System.out.println(new L91().DP(s));
    }
}
