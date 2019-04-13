package SuanFa;

/**
 * Created by Paser on 2019/2/22.
 */
public class Graph {
    private char[] vt;//表示每一个节点
    private int[][] vr;//节点之间的邻接关系
    public void setVt(char[] vt){
        this.vt=vt;
    }
    public void setVr(int[][] vr){
        this.vr=vr;
    }
    public char[] getVt(){
        return this.vt;
    }
    public int[][] getVr(){
        return this.vr;
    }
}
