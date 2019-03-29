package SuanFa;

import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.portable.ValueInputStream;

/**
 * Created by Paser on 2019/2/22.
 */
public class Prime {
    public Graph graph;
    public void init(){
        char[] vt={'0','1','2','3','4','5'};
        int[][] vr={
                {0,6,1,5,Integer.MAX_VALUE, Integer.MAX_VALUE},
                {6,0,5,Integer.MAX_VALUE,3,Integer.MAX_VALUE},
                {1,5,0,7,5,4},
                {5,Integer.MAX_VALUE,7,0,Integer.MAX_VALUE,2},
                {Integer.MAX_VALUE,3,5,Integer.MAX_VALUE,0,6},
                {Integer.MAX_VALUE, Integer.MAX_VALUE,4,2,6,0}
        };
        graph=new Graph();
        graph.setVt(vt);
        graph.setVr(vr);
    }
    public void startPrime(int startPoint){
        System.out.println("起始点为："+startPoint);
        int length=graph.getVt().length;
        int[] dist=new int[length];//对应于加入最小生成树的集合的距离列表
        int[] visit=new int[length];
        int sum=0;
        for(int i=0;i<length;i++){//找到起始节点相连边的距离
            dist[i]=graph.getVr()[startPoint][i];
        }
        visit[startPoint]=1;
        for(int i=0;i<length;i++){//对图中的每一个节点执行如下操作
            //找到当前边集中的最小距离
            int min=Integer.MAX_VALUE;
            int index=startPoint;
            for(int j=0;j<length;j++){
                if(visit[j]==0 && dist[j]<min){//找到最小值
                    min=dist[j];
                    index=j;
                }
            }
            if(index!=startPoint){
                System.out.println("加入最小生成树的定点是："+index);
            }
            visit[index]=1;
            sum+=dist[index];
            //更新距离列表（刚找到这个index，然后查看与index相连的边，看看有没有更加小的）
            for(int j=0;j<length;j++){
                if(visit[j]==0 && dist[j]>graph.getVr()[index][j]){
                    dist[j]=graph.getVr()[index][j];
                }
            }

        }
        System.out.println(sum);

    }

    public static void main(String[] args) {
        Prime prime=new Prime();
        prime.init();
        prime.startPrime(2);
    }
}
