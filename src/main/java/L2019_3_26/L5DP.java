package L2019_3_26;

/**最长回文子串
 * Created by DanLongChen on 2019/3/27
 **/
public class L5DP {
    public static String longestPalindrome(String s) {
        if (s.length() <= 0) {
            return "";
        }
        int[][] dp = new int[s.length()][s.length()];
        int start = 0;
        int longest = 1;
        for (int i = 0; i < s.length(); i++) {//用于查找相同的元素
            dp[i][i] = 1;
            if (i < s.length() - 1) {
                if (s.charAt(i) == s.charAt(i + 1)) {//长度是2的情况（有相邻的两个元素重复）
                    dp[i][i + 1] = 1;
                    start = i;
                    longest = 2;
                }
                // } else {
                // dp[i][i + 1] = 0;//默认初始化为0，所以0的情况不用管
                // }
            }
        }

        for (int l = 3; l <= s.length(); l++) {// 代表长度（长度一直在变，查看不同起点）
            for (int i = 0; i + l - 1 < s.length(); i++) {// 起始点,终点《s.length,这里是划分了一个区间
                int j = i + l - 1;// 终点
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    start = i;
                    longest = l;
                }
            }
        }
        return s.substring(start, start + longest);// [start,start+longest)
    }
}
