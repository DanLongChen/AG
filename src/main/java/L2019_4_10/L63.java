package L2019_4_10;

import javax.xml.crypto.dom.DOMCryptoContext;

/**机器人从左上角到达右下角，只能往右或者下移动，在中间给定一些障碍，问有多少种走法（0表示可以走，1表示这个格子不能走）
 * Created by DanLongChen on 2019/4/10
 **/
public class L63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
         * 简单DP实现
         */
        if (obstacleGrid[0][0]==1){//0,0点就是障碍物，那就说明不能走
            return 0;
        }

        int row=obstacleGrid.length;//行数
        int col=obstacleGrid[0].length;//列数
        /**
         * 若右下角那个格子有障碍物，则不能到达
         */
        if (obstacleGrid[row-1][col-1]==1){
            return 0;
        }
        int[][] DP=new int[row][col];
        DP[0][0]=1;
        boolean flag=false;
        for (int i=1;i<col;i++){
            if (obstacleGrid[0][i]==1){
                flag=true;
            }
            if (flag==false){
                DP[0][i]=1;
            }else{
                DP[0][i]=Integer.MAX_VALUE;
            }
        }
        flag=false;
        for(int j=1;j<row;j++){
            if(obstacleGrid[j][0]==1){
                flag=true;
            }
            if(flag==false){
                DP[j][0]=1;
            }else{
                DP[j][0]=Integer.MAX_VALUE;
            }
        }
        for (int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if (obstacleGrid[i][j]==1){
                    DP[i][j]=Integer.MAX_VALUE;
                    continue;
                }
                DP[i][j]=(DP[i-1][j]==Integer.MAX_VALUE?0:DP[i-1][j])+(DP[i][j-1]==Integer.MAX_VALUE?0:DP[i][j-1]);
            }
        }
        return DP[row-1][col-1];

    }

    public static void main(String[] args) {
        int[][] nums={{0,0,0},{0,1,0},{0,0,0}};
        int[][] arr={{0,1}};
        System.out.println(new L63().uniquePathsWithObstacles(arr));
    }
}
