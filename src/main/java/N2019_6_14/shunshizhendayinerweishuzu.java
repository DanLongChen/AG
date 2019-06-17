package N2019_6_14;

import javafx.scene.transform.MatrixType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanLongChen on 2019/6/14
 * 顺时针打印二维数组
 **/
public class shunshizhendayinerweishuzu {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4}};
        System.out.println(new shunshizhendayinerweishuzu().printMatrix(matrix));
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix==null || matrix.length==0){
            return null;
        }
        ArrayList<Integer> list=new ArrayList<>();
        int rows=matrix.length;
        int cols=matrix[0].length;
        int start=0;//第一次开始的位置为[0,0],第二次为[1,1]，当rows>start*2的时候还可以继续
        while(rows>start*2 && cols>start*2){
            handler(matrix,rows,cols,start,list);
            start++;
        }
        return list;
    }
    public void handler(int[][] matrix, int rows, int cols, int start, ArrayList<Integer> list){
        /**
         * 首先需要限定边界
         */
        int maxX=cols-start-1;
        int maxY=rows-start-1;
        /**
         * 从左到右
         */
        for (int i=start;i<=maxX;i++){
            list.add(matrix[start][i]);
        }
        /**
         * 从上往下
         */
        if(start<maxY)
        for (int i=start+1;i<=maxY;i++){
            list.add(matrix[i][maxX]);
        }
        /**
         * 从右往左
         */
        if (start<maxX && start<maxY)
        for (int i=maxX-1;i>=start;i--){
            list.add(matrix[maxY][i]);
        }
        /**
         * 从下往上
         */
        if (start<maxX && start<maxY-1)
        for (int i=maxY-1;i>=start+1;i--){
            list.add(matrix[i][start]);
        }
    }
}
