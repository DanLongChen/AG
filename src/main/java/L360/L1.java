package L360;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/8/15
 **/
public class L1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int N=input.nextInt();
        int M=input.nextInt();
        int[][] grid=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                grid[i][j]=input.nextInt();
            }
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    sum += grid[i][j] * 4 + 2;
                }
                if (i != 0) {
                    sum -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                }
                if (j != 0) {
                    sum -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                }
            }
        }

        System.out.println(sum);


//        int[] dr = new int[]{0, 1, 0, -1};
//        int[] dc = new int[]{1, 0, -1, 0};
//        int ans = 0;
//
//        for (int r = 0; r < N; ++r)
//            for (int c = 0; c < N; ++c)
//                if (grid[r][c] > 0) {
//                    ans += 2;
//                    for (int k = 0; k < 4; ++k) {
//                        int nr = r + dr[k];
//                        int nc = c + dc[k];
//                        int nv = 0;
//                        if (0 <= nr && nr < N && 0 <= nc && nc < N)
//                            nv = grid[nr][nc];
//
//                        ans += Math.max(grid[r][c] - nv, 0);
//                    }
//                }
//
//        System.out.println(ans);
    }
}
