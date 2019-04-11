package L2019_4_9;

import com.sun.deploy.panel.ITreeNode;

import java.io.FileReader;

/**给定一个矩形从左上角到右下角，寻找一条路径，是的这条路径上的数的和最小，只能向下或者向右移动
 * Created by DanLongChen on 2019/4/9
 **/
public class L64 {
    /**
     * 可以使用迭代+回溯/直接使用DP
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        /**
         * DP[i][j]=Math.min(DP[i][j-1],DP[i-1][j])+grid[i][j]  计算源点到当前点的代价
         */
        int row=grid.length;
        int col=grid[0].length;
        int[][] DP=new int[row][col];//代表0,0到达i,j的代价
        DP[0][0]=grid[0][0];
        /**
         * 下面两个for表示只能向右和向下运动的情况（也就是第一行，第一列）
         */
        for (int i=1;i<col;i++){
            DP[0][i]=DP[0][i-1]+grid[0][i];
        }
        for (int i=1;i<row;i++){
            DP[i][0]=DP[i-1][0]+grid[i][0];
        }
        for (int i=1;i<row;i++){
            for (int j=1;j<col;j++){
                DP[i][j]=Math.min(DP[i][j-1],DP[i-1][j])+grid[i][j];
            }
        }
        return DP[row-1][col-1];

    }
    public void handler(int[][] grid,int[] result,int i,int j){
        if (i==grid.length-1 && j==grid[0].length-1){
            return;
        }
        /**
         * 对于每一步只有两种选择（要么向右，要么向下）
         */
        if (i+1<grid.length && j+1<grid[0].length){
            if (result[0]+grid[i+1][j]<result[0]+grid[i][j+1]){//向右比向下小，则选择向右，向下的那一步回溯
                result[0]+=grid[++i][j];
                handler(grid,result,i,j);
            }else{
                result[0]+=grid[i][++j];
                handler(grid,result,i,j);
            }
        }else{
            if(i+1<grid.length){//说明到达最后一行，只能往右
                result[0]+=grid[++i][j];
                handler(grid,result,i,j);
            }else{//只能向下
                result[0]+=grid[i][++j];
                handler(grid,result,i,j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new L64().minPathSum(grid));
    }
}
