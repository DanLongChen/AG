package L2019_4_10;

/**唯一路径，机器人想要从矩阵的左上角到达右下角，有多少种不同的路径(机器人可以往右或者下移动)
 * Created by DanLongChen on 2019/4/10
 **/
public class L62 {
    public int uniquePaths2(int m, int n) {
        /**
         * 使用简单DP，第一行，第一列，到每一个各自都只有一种走法
         */
        /**
         * 二维数组代表到达从0,0点到达该点有多少种走法，第一行，第一列中的每一个格子都只有一种走法
         * DP[i][j]=DP[i-1][j]+DP[i][j-1],第i,j的位置可以从（i-1,j）或者(i,j-1)两个方向过来，那么到达(i-1,j)又有DP[i-1][j]种走法
         */
        int[][] DP=new int[m][n];//
        DP[0][0]=1;
        for(int i=1;i<n;i++){
            DP[0][i]=1;
        }
        for(int j=1;j<m;j++){
            DP[j][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                DP[i][j]=DP[i-1][j]+DP[i][j-1];
            }
        }
        return DP[m-1][n-1];
    }
    public int uniquePaths(int m, int n) {
        /**
         * 初步想法（使用迭代）TODO  答案是正确的，但是速度太慢了
         */
        int[] result=new int[1];
        handler(1,1,m,n,result);
        return result[0];
    }
    public void handler(int x,int y,int m,int n,int[] result){//起始点为1,1点，重点为m,n点
        if(x==m && y==n){
            result[0]++;
            return;
        }
        if (y==n){//机器人到达最优边，只能往下走
            handler(x+1,y,m,n,result);
            return;
        }
        if (x==m){//机器人到达最下边，只能往右走
            handler(x,y+1,m,n,result);
            return;
        }

        handler(x+1,y,m,n,result);

        handler(x,y+1,m,n,result);
    }

    public static void main(String[] args) {
        System.out.println(new L62().uniquePaths(51,9));
    }
}
