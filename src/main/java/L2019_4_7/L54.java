package L2019_4_7;

import java.util.ArrayList;
import java.util.List;

/**
 * 顺时针螺旋输出矩阵
 * Created by Paser on 2019/4/7.
 */
public class L54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length==0){
            return result;
        }
        /**
         * 定义矩阵的长宽
         */
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        System.out.println(rowSize+" "+colSize);
        int rowStep = 1;//横向移动一步的步长
        int colStep = 1;
        int i = 0;
        int j = 0;
        int directioin = 0;//0代表横向，1代表纵向
        while (true) {
            if (directioin == 0 && rowStep == 1) {//横向往右
                if (j < colSize && matrix[i][j] != Integer.MAX_VALUE) {
                    result.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                    j += rowStep;
                    continue;
                } else {
                    directioin = 1;//向下转向
                    colStep = 1;
                    i += 1;
                    /**
                     * 回退操作
                     */
                    j--;
                }
            }
            if (directioin == 1 && colStep == 1) {
                if (i < rowSize && matrix[i][j] != Integer.MAX_VALUE) {
                    result.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                    i += colStep;
                    continue;
                } else {
                    directioin = 0;
                    rowStep = -1;
                    j -= 1;
//                    if (i==rowSize)
                    i--;
                }
            }
            if (directioin == 0 && rowStep == -1) {
                if (j >= 0 && matrix[i][j] != Integer.MAX_VALUE) {
                    result.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                    j += rowStep;
                    continue;
                } else {
                    directioin = 1;
                    colStep = -1;
                    i -= 1;
//                    if (j==-1)
                    j++;
                }
            }
            if (directioin == 1 && colStep == -1) {
                if (i >= 0 && matrix[i][j] != Integer.MAX_VALUE) {
                    result.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE;
                    i += colStep;
                    continue;
                } else {
                    directioin = 0;
                    rowStep = 1;
                    j += 1;
//                    if (i==-1)
                    i++;
                }
            }
            if (result.size()==rowSize*colSize)
            break;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(new L54().spiralOrder(matrix));
    }
}
