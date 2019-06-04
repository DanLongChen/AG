package L2019_6_4;

/**
 * Created by DanLongChen on 2019/6/4
 * 求最大公共子串
 **/
public class zuidaGongGongZiChuan {
    /**
     * 构造二维数组分别表示两个子串相同的部分，如果相同则标记为1.然后计算最长的为1的对角线长度（为了方便，可以直接在查找的时候就记录下长度）
     * @param s1
     * @param s2
     * @return
     */
    public String Dp(String s1,String s2){
        int[][] dp=new int[s1.length()][s2.length()];
        int end=0,max=0;
        for (int i=0;i<s1.length();i++){
            for (int j=0;j<s2.length();j++){
                if (s1.charAt(i)==s2.charAt(j)){
                    if (i==0 || j==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j]=dp[i-1][j-1]+1;
                        if(dp[i][j]>max){
                            max=dp[i][j];
                            end=i;//记录i，因为最后拿的是s1的子串
                        }
                    }
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return s1.substring(end-max+1,end+1);
    }

    public static void main(String[] args) {
        System.out.println(new zuidaGongGongZiChuan().Dp("acbcbcef","abcbced"));
    }
}
