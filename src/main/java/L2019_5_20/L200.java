package L2019_5_20;

/**
 * Created by DanLongChen on 2019/5/20
 **/

/**
 * 计算岛屿数量，给定二维数组，1表示岛屿，0表示水，岛屿被水隔开，只能横向或者纵向移动，计算岛屿数量
 */
public class L200 {
    public int numIslands(char[][] grid) {
        /**
         * 递归+回溯
         */
        if(grid==null || grid.length==0){
            return 0;
        }
        int nums=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    nums++;
                    dfs(grid,i,j);
                }
            }
        }
        return nums;
    }
    public void dfs(char[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0'){
            return ;
        }
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
