package L2019_4_8;

import java.util.Arrays;

/**给定一个数n，从1到n^2螺旋输出一个矩阵
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * Created by DanLongChen on 2019/4/8
 **/
public class L59 {
    public int[][] generateMatrix(int n) {
        int[][] result=new int[n][n];
        int rowSize=n;
        int colSize=n;
        /**
         * 定义横向和纵向移动的步长（定义是向前移动还是向后移动，向下移动还是向上移动）
         */
        int rowStep=1;
        int colStep=1;
        int direction=1;//1代表横向，0代表纵向
        /**
         * 用于存放需要填写如矩阵的变量
         */
        int number=1;
        /**
         * 定义两个指针（确定一个矩阵的位置）
         */
        int i=0,j=0;
        while (true){//当number==n^2的时候结束循环
            if(direction==1 && colStep==1){
                if (j<colSize && result[i][j]==0){
                    result[i][j]=number++;
                    j+=colStep;
                    continue;
                }else{
                    i++;
                    j--;
                    direction=0;
                    rowStep=1;
                }
            }
            if(direction==0 && rowStep==1){
                if(i<rowSize && result[i][j]==0){
                    result[i][j]=number++;
                    i+=rowStep;
                    continue;
                }else{
                    i--;
                    j--;
                    direction=1;
                    colStep=-1;
                }
            }
            if(direction==1 && colStep==-1){
                if(j>=0 && result[i][j]==0){
                    result[i][j]=number++;
                    j+=colStep;
                    continue;
                }else{
                    j++;
                    i--;
                    direction=0;
                    rowStep=-1;
                }
            }
            if(direction==0 && rowStep==-1){
                if(i>=0 && result[i][j]==0){
                    result[i][j]=number++;
                    i+=rowStep;
                    continue;
                }else{
                    i++;
                    j++;
                    direction=1;
                    colStep=1;
                }
            }
            if(number==n*n+1){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new L59().generateMatrix(0)));
    }
}
