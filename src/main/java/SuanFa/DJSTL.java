package SuanFa;

import com.sun.org.apache.bcel.internal.generic.NEW;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

import java.util.Arrays;

/**
 * Created by DanLongChen on 2019/3/13
 **/
//迪杰斯特拉算法
public class DJSTL {
    public int[][] path = new int[][]{
            {0, 5, 8, 1000, 1000},
            {5, 0, 1, 3, 2},
            {8, 1, 0, 1000, 1000},
            {1000, 3, 1000, 0, 7},
            {1000, 2, 1000, 7, 0}
    };

    public static void main(String[] args) {
        new DJSTL().doDJSTL(0);
    }

    public void doDJSTL(int source) {
        int[] dis = new int[5];//源点到其他节点的距离
        boolean[] flag = new boolean[5];//标记哪些节点已经充当过源点
        int min = Integer.MAX_VALUE;
        int start = source;//下一次循环从哪个节点出发
        int[] ru=new int[5];
        for (int i = 0; i < 5; i++) {//初始化dis
            if (i == source) {
                dis[i] = 0;
            } else {
                dis[i] = Integer.MAX_VALUE;
            }
        }
        flag[start] = true;//标记当前的源点已经被访问

        for (int j = 0; j < 5; j++) {//更新源点到其他节点的距离
            dis[j] = Math.min(dis[j], path[start][j]);
            ru[j]=-1;
        }
        for (int i = 0; i < 4; i++) {
            min=Integer.MAX_VALUE;
            for (int j = 0; j < 5; j++) {//寻找下一个start
                if(!flag[j] && min>dis[j]){
                    min=dis[j];
                    start=j;
                }
            }
            System.out.println(start);
            flag[start]=true;
            for(int j=0;j<5;j++){//找到下一个start，查看source通过这个start能否减少到其他节点的距离
//                dis[j]=Math.min(dis[j],dis[start]+path[start][j]);
                if(dis[j]>dis[start]+path[start][j]){
                    dis[j]=dis[start]+path[start][j];
                    ru[j]=start;
                }
            }
        }
        System.out.println(Arrays.toString(dis));
        int end=2;
        while (ru[end]!=-1){
            System.out.println(ru[end]);
            end=ru[end];
        }
        System.out.println(Arrays.toString(ru));
    }
}
