package SuanFa;

/**
 * Created by Paser on 2019/2/22.
 */
public class DFS {
    public Graph graph=new Graph();
    public static void main(String[] args) {
        DFS dfs=new DFS();
        dfs.init();
        dfs.DFSReserve();
    }
    public void init(){
        char[] vt={'0','1','2','3','4','5','6'};
        int[][] vr={
                {0,1,1,1,0,0,0},
                {1,0,0,0,1,1,1},
                {1,0,0,0,0,0,1},
                {1,0,0,0,0,0,0},
                {0,1,0,0,0,1,0},
                {0,1,0,0,1,0,0},
                {0,1,1,0,0,0,0}
        };
        graph=new Graph();
        graph.setVt(vt);
        graph.setVr(vr);
    }
    public void DFSReserve(){
        int length=graph.getVt().length;
        boolean[] flag=new boolean[length];
        for(int i=0;i<length;i++){//从某个点开始DFS
            if(flag[i]==false){
                DFS(graph,i,flag);
            }
        }

    }
    public void DFS(Graph graph,int i,boolean[] flag){//从该点开始寻找其邻居有没有被遍历过
        flag[i]=true;
        System.out.println("当前遍历："+i);
        for(int j=0;j<graph.getVt().length;j++){
            if (graph.getVr()[i][j]==1 && !flag[j]){//==1说明有边相连
                DFS(graph,j,flag);
            }
        }
    }
}
