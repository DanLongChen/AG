package L2019_4_12;

/**在二维数组中查找给定的数值
 * Created by DanLongChen on 2019/4/12
 **/
public class L74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0){
            return false;
        }
        if (matrix.length==1 && matrix[0].length==1){
            if(matrix[0][0]==target){
                return true;
            }
            return false;
        }
        /**
         * 初步采用的方法是，分层次的二分查找
         */
        //首先对比target和二维数组每一行最末尾的数，查看当前的target属于哪一行
        int row=matrix.length;
        int col=matrix[0].length;
        int targetRow=0;
        for (int i=0;i<row;i++){
            if (matrix[i][col-1]>=target){
                targetRow=i;//找到第i行为需要搜索的行
                break;
            }
        }
        /**
         * 然后按照二分查找法进行查找
         */
        int left=0;
        int right=col-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (matrix[targetRow][mid]==target){
                return true;
            }
            if (matrix[targetRow][mid]<target){
                left=mid+1;
            }
            if(matrix[targetRow][mid]>target){
                right=mid-1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] nums={{1},{3}};
        System.out.println(new L74().searchMatrix(nums,1));
    }
}
