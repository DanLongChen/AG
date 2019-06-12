package N2019_6_11;

/**
 * Created by DanLongChen on 2019/6/11
 * 机器人的移动范围
 **/
public class JiQiRenDeYiDongFanWei {
    /**
     * 使用递归+回溯
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] flag=new boolean[rows][cols];
        return handler(threshold,rows,cols,0,0,flag);
    }
    public int handler(int threshold,int rows,int cols,int i,int j,boolean[][] flag){
        int sumi=0;
        int ci=i;
        while (ci!=0){
            sumi+=ci%10;
            ci/=10;
        }
        int sumj=0;
        int cj=j;
        while(cj!=0){
            sumj+=cj%10;
            cj/=10;
        }
        if (i<0 || i>rows-1 || j<0 || j>cols-1 || sumi+sumj>threshold || flag[i][j]){
            return 0;
        }
        flag[i][j]=true;//已经探测过是不行的
        return 1+handler(threshold,rows,cols,i,j-1,flag)+handler(threshold,rows,cols,i,j+1,flag)+handler(threshold,rows,cols,i-1,j,flag)+handler(threshold,rows,cols,i+1,j,flag);

    }

    public static void main(String[] args) {
        System.out.println(new JiQiRenDeYiDongFanWei().movingCount(5,10,10));
    }
}
