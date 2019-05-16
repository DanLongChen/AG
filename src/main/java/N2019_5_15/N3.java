package N2019_5_15;

import java.util.Scanner;

/**
 * Created by DanLongChen on 2019/5/15
 **/
public class N3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int length=input.nextInt();
        char[][] graph=new char[length][length];
        int[][] direction=new int[4][2];
        /*
        定义四个方向
         */
        direction[0][0]=1;
        direction[0][1]=0;
        direction[1][0]=-1;
        direction[1][1]=0;
        direction[2][0]=0;
        direction[2][1]=1;
        direction[3][0]=0;
        direction[3][1]=-1;
        int[] num=new int[0];
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                if (graph[i][j]=='@'){
                    handler(i,j,graph,direction,num,0);
                }
            }
        }
        System.out.println(num[0]);

    }
    public static void handler(int i,int j,char[][] graph,int[][] direction,int[] num,int step){
        if ( i<0 || i>=graph.length || j<0 || j>=graph.length || graph[i][j]=='#') {
            return;
        }
        if (graph[i][j]=='*'){
            num[0]=Math.min(step,num[0]);
            return;
        }
        for (int k=0;k<4;k++){
            handler(i+direction[i][0],j+direction[i][1],graph,direction,num,step+1);
        }
    }
}
