package L2019_7_24;

import java.util.Arrays;

/**
 * Created by DanLongChen on 2019/7/24
 * 最大正方形
 **/
public class L221 {
    public int maximalSquare(char[][] matrix) {
        /**
         * 使用DP，dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
         * 这里首先对dp进行初始化，其实不需要进行初始化，就是需要扩宽辅助空间
         */
        if(matrix==null || matrix.length==0){
            return 0;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] dp=new int[row][col];
        int result=0;
        for(int i=0;i<row;i++){
            if(matrix[i][0]=='1'){
                dp[i][0]=1;
                result=1;
            }
        }
        for(int i=0;i<col;i++){
            if(matrix[0][i]=='1'){
                dp[0][i]=1;
                result=1;
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    result=Math.max(result,dp[i][j]);
                }
            }
        }
        return result*result;
    }
    public int maximalSquare1(char[][] matrix) {
        /**
         * 还是DP，这次不需要进行初始化
         */
        if(matrix==null || matrix.length==0){
            return 0;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] dp=new int[row+1][col+1];
        int result=0;
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;//这样子的话在matrix中第一行，第一列为1的地方就会赋值为1，省去了初始化
                    result=Math.max(result,dp[i][j]);
                }
            }
        }
        return result*result;
    }
    public int maximalSquare2(char[][] matrix) {
        /**
         * 空间优化版本，使用一维的dp数组
         */
        if(matrix==null || matrix.length==0){
            return 0;
        }
        int col=matrix[0].length;
        int[] dp=new int[col+1];
        int result=0,pre=0;
        for (int i=1;i<=matrix.length;i++){
            for (int j=1;j<=col;j++){
                int temp=dp[j];
                if(matrix[i-1][j-1]=='1'){
                    dp[j]=Math.min(Math.min(dp[j-1],pre),dp[j])+1;
                    result=Math.max(result,dp[j]);
                }else{
                    dp[j]=0;
                }
                pre=temp;
            }
        }
        return result*result;
    }
    public static void main(String[] args) {
        char[][] matrix={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new L221().maximalSquare2(matrix));
    }
}
