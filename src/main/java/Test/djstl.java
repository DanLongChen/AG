package Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by DanLongChen on 2019/8/22
 **/
public class djstl {
    public static void main(String[] args) {
        int M=1000;
        int[][] weight1 = {
                {0,4,M,2,M},
                {4,0,4,1,M},
                {M,4,0,1,3},
                {2,1,1,0,7},
                {M,M,3,7,0}
        };
        dj(weight1,0);
    }
    public static void dj(int[][] G,int start){
        int length=G.length;
        boolean[] visited=new boolean[length];
        int[] dis=new int[length];
        int[] path=new int[length];
        for(int i=0;i<length;i++){
            dis[i]=G[start][i];
            if(dis[i]!=Integer.MAX_VALUE){
                path[i]=start;//可以通过start到达这一点
            }
        }
        int startID=0;//下一个搜索的节点
        visited[start]=true;
        for(int i=0;i<length;i++){
            int min=Integer.MAX_VALUE;
            startID=-1;
            for(int j=0;j<length;j++){
                if(visited[j]==false && dis[j]<min){
                    min=dis[j];
                    startID=j;
                }
            }
            if(startID==-1){
                break;
            }
            visited[startID]=true;
            for(int j=0;j<length;j++){
                if(dis[j]>dis[startID]+G[startID][j]){
                    dis[j]=dis[startID]+G[startID][j];
                    path[j]=startID;
                }
            }
        }
        System.out.println(Arrays.toString(dis));
        System.out.println(Arrays.toString(path));
    }
}
