package L2019_7_23;

/**
 * Created by DanLongChen on 2019/7/23
 **/
public class L240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //直接使用二分查找呗
        if(matrix==null || matrix.length==0){
            return false;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int index=0;
        for(int i=0;i<row;i++){
            if(matrix[i][0]<target){
                index=i;
            }
        }
        System.out.println(index);
        int left=0,right=col-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(matrix[index][mid]==target){
                return true;
            }
            if(target>matrix[index][mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;
    }
    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0){
            return false;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int startRow=row-1;
        int startCol=0;
        while (startRow>=0 && startCol<col){
            if(matrix[startRow][startCol]==target){
                return true;
            }
            else if(matrix[startRow][startCol]<target){
                startCol++;
            }else{
                startRow--;
            }
        }
        return false;
    }
}
