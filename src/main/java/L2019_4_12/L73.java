package L2019_4_12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**给定一个矩阵，找出矩阵中为0的数，并且将去行列置为0（0的个数不确定）
 * Created by DanLongChen on 2019/4/12
 **/
public class L73 {
    public void setZeroes(int[][] matrix) {
        Map<String,Integer> map = new HashMap<>();
        int row=matrix.length;
        int col=matrix[0].length;
        for (int i = 0;i<row;i++){
            for(int j=0;j<col;j++){
                if (matrix[i][j]==0){
                    System.out.println(matrix[i][j]);
                    /**
                     * 把矩阵中为0的数的位置记录下来
                     */
                    map.put(String.valueOf(i+" "+j),j);
                }
            }
        }
        for (Map.Entry entry:map.entrySet()){
            String temp=(String) entry.getKey();
            int iPosition=Integer.parseInt(temp.split(" ")[0]);
            int jPosition=(int)entry.getValue();
            for (int i = 0;i<col;i++){
                matrix[iPosition][i]=0;
            }
            for(int i = 0;i<row;i++){
                matrix[i][jPosition]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new L73().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
