package L2019_7_20;

/**
 * Created by Paser on 2019/7/20.
 * 回文子串
 *
 */
public class L645
{
    /**
     * 向两端扩展
     * @param s
     * @return
     */
    public int countSubstrings1(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int result=0;
        for(int i=0;i<s.length();i++){
            result+=handler(s,i,i);
            result+=handler(s,i,i+1);
        }
        return result;
    }
    public int handler(String s,int start,int end){
        int count=0;
        while (start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
            count++;
        }
        return count;
    }

    /**
     * 使用DP数组来记录所有可能的子串
     * @param s
     * @return
     */
    public int countSubstrings2(String s) {
        //首先需要产生DP数组
        if(s==null || s.length()==0){
            return 0;
        }
        int length=s.length();
        int[][] dp=new int[length][length];
        for(int i=0;i<length;i++){
            dp[i][i]=1;
            if (i<length-1 && s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1;
            }
        }
        for (int len=3;len<=length;len++){
            for(int start=0;start+len-1<length;start++){
                int end=start+len-1;
                if(s.charAt(start)==s.charAt(end) && dp[start+1][end-1]==1){
                    dp[start][end]=1;
                }
            }
        }
        //再统计一下dp中1的个数，也就是子串的个数
        int result=0;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(dp[i][j]==1){
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 暴力法
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        //使用暴力，使用两个循环（表示起点和终点）
        if(s==null || s.length()==0){
            return 0;
        }
        int length=s.length();
        int result=0;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<=length;j++){
                if(isHuiWen(s.substring(i,j))){
                    result++;
                }
            }
        }
        return result;
    }
    private boolean isHuiWen(String s){
        int left=0,right=s.length()-1;
        while(left<=right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                break;
            }
        }
        return left>=right?true:false;
    }

    public static void main(String[] args) {
        System.out.println(new L645().countSubstrings2("abc"));
    }
}
